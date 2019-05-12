package uic.prominent.activity.tracker;

import static uic.prominent.activity.util.Utils.currentTime;
import static uic.prominent.activity.util.Utils.getStackTrace;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

import com4j.Com4jObject;
import uic.prominent.ScreenLogging.wsh.ClassFactory;
import uic.prominent.ScreenLogging.wsh.Folder;
import uic.prominent.ScreenLogging.wsh.IShellFolderViewDual3;
import uic.prominent.ScreenLogging.wsh.IShellWindows;
import uic.prominent.ScreenLogging.wsh.IWebBrowser2;
import uic.prominent.activity.util.WindowInfo;

public class AppTracker {
	
	public static final String CLSID_ShellWindows = "9BA05972-F6A8-11CF-A442-00A0C90A8F39";
	public static final String IID_IShellWindows = "85CB6900-4D95-11CF-960C-0080C7F4EE85";
	
	private static Logger log = LogManager.getRootLogger();
	private String output_dir;
	public List<WindowInfo> windows;

	private List<Integer> order;
	
	private long lastwrite = 0L;
	private long writeInterval;
	
	private List<String> buffer;

	public AppTracker(String output_dir, long writeInterval) {
		this.output_dir = output_dir;
		this.windows = new ArrayList<WindowInfo>();
		this.writeInterval = writeInterval;
		this.buffer = new ArrayList<String>();
	}

	public void track() {
		List<WindowInfo> newWindows = getWindows();
		buffer.addAll(checkEvents(newWindows, System.currentTimeMillis()));
		toFile(false);
	}
	
	public void forceWrite(){
		toFile(true);
	}

	private void toFile(boolean force) {
		try {
			if ((buffer.size() > 0 && lastwrite < (System.currentTimeMillis() - writeInterval)) || force) {
				log.debug("Prepare APPTRACKER log");
				OutputStreamWriter printWriter = new OutputStreamWriter(new FileOutputStream(this.output_dir + "apptracker_" + currentTime() + ".tsv"), StandardCharsets.UTF_8);
				for (String entry : buffer) {
					printWriter.write(entry + "\n");
					printWriter.flush();
				}
				printWriter.close();
				this.lastwrite = System.currentTimeMillis();
				buffer.clear();
				log.debug("APPTRACKER log written");
			}
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}
	
	private List<WindowInfo> getWindows() {
		List<WindowInfo> inflList = new ArrayList<WindowInfo>();
		order = new ArrayList<Integer>();
		int top = User32.instance.GetTopWindow(0);

		while (top != 0) {
			order.add(top);
			top = User32.instance.GetWindow(top, User32.GW_HWNDNEXT);
		}
		User32.instance.EnumWindows(new WndEnumProc() {
			public boolean callback(int hWnd, int lParam) {
				if (User32.instance.IsWindowVisible(hWnd)) {
					RECT r = new RECT();
					User32.instance.GetWindowRect(hWnd, r);

					byte[] buffer = new byte[1024];
					User32.instance.GetWindowTextA(hWnd, buffer, buffer.length);
					String title = Native.toString(buffer);

					if (!title.equals("")) {
						PointerByReference pointer = new PointerByReference();
						User32.instance.GetWindowThreadProcessId(hWnd, pointer);

						char[] buffer2 = new char[2048];
						Pointer process = Kernel32.instance.OpenProcess(
								Kernel32.PROCESS_QUERY_INFORMATION | Kernel32.PROCESS_VM_READ, false,
								pointer.getValue());
						Psapi.instance.GetModuleBaseNameW(process, null, buffer2, 1024);
						String processName = Native.toString(buffer2);
						
						/** PATCH CHECKER **/
						String misc = "";
						if (processName.toLowerCase().equals("explorer.exe")) {
							HANDLE remoteProcess = Kernel32.INSTANCE
									.OpenProcess(
											Kernel32.PROCESS_DUP_HANDLE | Kernel32.PROCESS_QUERY_INFORMATION
													| Kernel32.PROCESS_VM_READ,
											false, Kernel32.instance.GetProcessId(process));
							IWebBrowser2 browser = getIWebBrowser2(hWnd);
							IShellFolderViewDual3 view = getIShellFolderViewDual3(browser);
							if (view != null) {
								Folder folder = view.folder();
								String path = folder.title();
															
								while(folder.parentFolder() != null){
									folder = folder.parentFolder();
									path = folder.title() + "\\" + path;
								}
								misc = path;
							}
						}
						/** ------------ **/
						

						if (!processName.equals("")) {
							inflList.add(new WindowInfo(hWnd, r, Kernel32.instance.GetProcessId(process), processName,
									title, misc));
						}						
					}
				}
				return true;
			}
		}, 0);
		Collections.sort(inflList, new Comparator<WindowInfo>() {
			public int compare(WindowInfo o1, WindowInfo o2) {
				return order.indexOf(o1.hwnd) - order.indexOf(o2.hwnd);
			}
		});
		return inflList;
	}

	public List<String> checkEvents(List<WindowInfo> newList, long timestamp) {
		List<String> events = new ArrayList<String>();

		/**
		 * Check if application has been opened
		 */
		for (WindowInfo w1 : newList) {
			boolean found = false;
			for (WindowInfo w2 : this.windows) {
				if (w2.isSame(w1)) {
					found = true;
					break;
				}
			}
			if (!found) {
				events.add(timestamp + "\tA1\t[" + w1.pid + "," + w1.processName + "," + w1.title + ","
						+ w1.width + "," + w1.height + "," + w1.rect.left + ","+ w1.rect.top + "]");
				this.windows.add(w1);
				
				// NEW PATH ELEMENT
				if(w1.isExplorer()){
					System.out.println("\tA8\t[" + w1.pid + "," + w1.processName + "," + w1.misc + "]");
					events.add(timestamp + "\tA8\t[" + w1.pid + "," + w1.processName + "," + w1.misc + "]");
				}
			}
		}

		/**
		 * Check if application has been closed
		 */
		List<WindowInfo> delete = new ArrayList<WindowInfo>();

		for (WindowInfo w1 : this.windows) {
			boolean found = false;
			for (WindowInfo w2 : newList) {
				if (w2.isSame(w1)) {
					found = true;

					/**
					 * Check if application has been minimized/maximized
					 */
					if (w1.minimized == true && w2.minimized == false) {
						w1.minimized = false;
						events.add(timestamp + "\tA3\t[" + w1.pid + "," + w1.processName + "]");
					} else if (w1.minimized == false && w2.minimized == true) {
						w1.minimized = true;
						events.add(timestamp + "\tA4\t[" + w1.pid + "," + w1.processName + "]");
					}

					/**
					 * check if windowtitle changed
					 */
					if (!w1.title.equals(w2.title)) {
						w1.title = w2.title;
						events.add(timestamp + "\tA5\t[" + w1.pid + "," + w1.processName + "," + w1.title+"]");
					}
					
					/**
					 * check if it is explorer and path has changed
					 */
					if ((w1.processName.toLowerCase()).equals("explorer.exe") && (!w1.misc.equals(w2.misc))) {
						w1.misc = w2.misc;
						System.out.println("\tA8\t[" + w1.pid + "," + w1.processName + "," + w1.misc + "]");
						events.add(timestamp + "\tA8\t[" + w1.pid + "," + w1.processName + "," + w1.misc+"]");
					}

					/**
					 * check if size and position has been changed (window
					 * changed)
					 */
					if (w1.sizeOrPositionChanged(w2)) {
						w1.rect = w2.rect;
						w1.width = w2.width;
						w1.height = w2.height;
						events.add(timestamp + "\tA6\t[" + w1.pid + "," + w1.processName + ","
								+ w1.width + "," + w1.height + "," + w1.rect.left + ","
								+ w1.rect.top + "]");
					}
					break;
				}
			}
			if (!found) {
				events.add(timestamp + "\tA2\t[" + w1.pid + "," + w1.processName + "," + w1.title + "]");
				delete.add(w1);
			}
		}

		for (WindowInfo w : delete) {
			this.windows.remove(w);
		}

		for (int i = 0; i < newList.size(); i++) {
			//System.out.println("CHECK SIZES: " + this.windows.size() + " vs " + newList.size());
			if (!this.windows.get(i).isSame(newList.get(i))) {
				this.windows = newList;
				
				String str = "";
				boolean first = true;
				for(WindowInfo win : newList){
					if(first){
						first = false;
						str += win.pid + "#" + win.processName+"";
					}else{
						str += ";" + win.pid + "#" + win.processName;
					}
				}
			    events.add(timestamp + "\tA7\t[" + str + "]");
				break;
			}
		}
		
		return events;
	}

	public static interface WndEnumProc extends StdCallLibrary.StdCallCallback {
		boolean callback(int hWnd, int lParam);
	}

	public static interface User32 extends StdCallLibrary {
		final User32 instance = (User32) Native.loadLibrary("user32", User32.class);

		boolean EnumWindows(WndEnumProc wndenumproc, int lParam);

		boolean IsWindowVisible(int hWnd);

		int GetWindowRect(int hWnd, RECT r);

		void GetWindowTextA(int hWnd, byte[] buffer, int buflen);

		int GetTopWindow(int hWnd);

		int GetWindow(int hWnd, int flag);

		int GetWindowThreadProcessId(int hWnd, PointerByReference pref);

		final int GW_HWNDNEXT = 2;
	}

	public static interface Psapi extends com.sun.jna.platform.win32.Psapi {
		final Psapi instance = (Psapi) Native.loadLibrary("psapi", Psapi.class);

		int GetModuleBaseNameW(Pointer hProcess, Pointer hmodule, char[] lpBaseName, int size);
	}

	public static interface Kernel32 extends com.sun.jna.platform.win32.Kernel32 {
		final Kernel32 instance = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class,
				com.sun.jna.win32.W32APIOptions.DEFAULT_OPTIONS);
		public static int PROCESS_QUERY_INFORMATION = 0x0400;
		public static int PROCESS_VM_READ = 0x0010;

		int GetLastError();

		int GetProcessId(Pointer pointer);

		Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, Pointer pointer);
	}
	
	/** PATH CHECKER UTILS **/
	public static IShellFolderViewDual3 getIShellFolderViewDual3(IWebBrowser2 browser) {
	    if (browser == null)
	        return null;
	    return browser.document().queryInterface(IShellFolderViewDual3.class);
	}
	
	public static IWebBrowser2 getIWebBrowser2(int hWnd) {
	    IShellWindows windows = ClassFactory.createShell().windows().queryInterface(IShellWindows.class);
	    for (Com4jObject window : windows) {
	        IWebBrowser2 browser = window.queryInterface(IWebBrowser2.class);
	        if (browser.hwnd() == Long.parseLong(hWnd + ""))
	            return browser;
	    }
	    return null;
	}
}
