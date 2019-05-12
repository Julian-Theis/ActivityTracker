package uic.prominent.activity.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.ShellAPI;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

import com4j.Com4jObject;
import uic.prominent.ScreenLogging.wsh.ClassFactory;
import uic.prominent.ScreenLogging.wsh.Folder;
import uic.prominent.ScreenLogging.wsh.FolderItem;
import uic.prominent.ScreenLogging.wsh.FolderItems;
import uic.prominent.ScreenLogging.wsh.IShellFolderViewDual3;
import uic.prominent.ScreenLogging.wsh.IShellWindows;
import uic.prominent.ScreenLogging.wsh.IWebBrowser2;
import uic.prominent.activity.tracker.AppTracker.Kernel32;

public class WindowsExplorerPath {

	public static final String CLSID_ShellWindows = "9BA05972-F6A8-11CF-A442-00A0C90A8F39";
	public static final String IID_IShellWindows = "85CB6900-4D95-11CF-960C-0080C7F4EE85";

	public static void main(String[] args) {
		final List<WindowInfo> inflList = new ArrayList<WindowInfo>();
		final List<Integer> order = new ArrayList<Integer>();
		int top = User32.instance.GetTopWindow(0);

		while (top != 0) {
			order.add(top);
			top = User32.instance.GetWindow(top, User32.GW_HWNDNEXT);
		}

		User32.instance.EnumWindows(new WndEnumProc() {
			public boolean callback(int hWnd, int lParam) {
				if (User32.instance.IsWindowVisible(hWnd)) {

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
						

						if (processName.equals("explorer.exe")) {
							
							int pid = Kernel32.instance.GetProcessId(process);
							System.out.println(processName + " " + pid);

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
								
								System.out.println(path);
								
							}
							
							
							/*
					        if (view != null && browser.visible()) {
					        	System.out.println(view.folder());
					        	
					            FolderItems items = view.selectedItems();
					            ArrayList<Path> paths = new ArrayList<Path>(items.count());
					            for (Com4jObject object : items) {
					                FolderItem item = object.queryInterface(FolderItem.class);
					                if (item != null) {
					                    paths.add(Paths.get(item.path()));
					                    // this is for example only, do not create a new File just to get length
					                    System.out.println("file: " + item.path() + " length: "
					                            + new File(item.path()).length() + " type:" + item.type());
					                }
					            }
					        }
					        */
							
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
		for (WindowInfo w : inflList) {
			// System.out.println(w);
		}
	}

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
	
	
	
	public void getFullPathsOfProcesses(){
		Kernel32 kernel32 = (Kernel32) Native.loadLibrary(Kernel32.class, W32APIOptions.DEFAULT_OPTIONS);
        Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();
        HANDLE processSnapshot = 
                kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
        try {

            while (kernel32.Process32Next(processSnapshot, processEntry)) {
                // looks for a specific process
                // if (Native.toString(processEntry.szExeFile).equalsIgnoreCase("textpad.exe")) {
                System.out.print(processEntry.th32ProcessID + "\t" + Native.toString(processEntry.szExeFile) + "\t");
                HANDLE moduleSnapshot = 
                    kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPMODULE, processEntry.th32ProcessID);
                try {
                     ProcessPathKernel32.MODULEENTRY32.ByReference me = new ProcessPathKernel32.MODULEENTRY32.ByReference();
                     ProcessPathKernel32.INSTANCE.Module32First(moduleSnapshot, me);
                     System.out.print(": " + me.szExePath() );
                     System.out.println();
                 }
                 finally {
                     kernel32.CloseHandle(moduleSnapshot);
                 }
                // }
            }
        } 
        finally {
            kernel32.CloseHandle(processSnapshot);
        }
	}


	public interface ProcessPathKernel32 extends Kernel32 {
	    class MODULEENTRY32 extends Structure {
	        public static class ByReference extends MODULEENTRY32 implements Structure.ByReference {
	            public ByReference() {
	            }

	            public ByReference(Pointer memory) {
	                super(memory);
	            }
	        }
	        public MODULEENTRY32() {
	            dwSize = new WinDef.DWORD(size());
	        }

	        public MODULEENTRY32(Pointer memory) {
	            super(memory);
	            read();
	        }


	        public DWORD dwSize;
	        public DWORD th32ModuleID;
	        public DWORD th32ProcessID;
	        public DWORD GlblcntUsage;
	        public DWORD ProccntUsage;
	        public Pointer modBaseAddr;
	        public DWORD modBaseSize;
	        public HMODULE hModule;
	        public char[] szModule = new char[255+1]; // MAX_MODULE_NAME32
	        public char[] szExePath = new char[MAX_PATH];
	        public String szModule() { return Native.toString(this.szModule); }
	        public String szExePath() { return Native.toString(this.szExePath); }
	        @Override
	        protected List<String> getFieldOrder() {
	            return Arrays.asList(new String[] {
	                "dwSize", "th32ModuleID", "th32ProcessID", "GlblcntUsage", "ProccntUsage", "modBaseAddr", "modBaseSize", "hModule", "szModule", "szExePath"
	            });
	        }
	    }

	    ProcessPathKernel32 INSTANCE = (ProcessPathKernel32)Native.loadLibrary(ProcessPathKernel32.class, W32APIOptions.UNICODE_OPTIONS);
	    boolean Module32First(HANDLE hSnapshot, MODULEENTRY32.ByReference lpme);
	    boolean Module32Next(HANDLE hSnapshot, MODULEENTRY32.ByReference lpme);
	}

	public static interface WndEnumProc extends StdCallLibrary.StdCallCallback {
		boolean callback(int hWnd, int lParam);
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
	
	public static interface Shell32 extends ShellAPI, StdCallLibrary {
	    final Shell32 instance = Native.loadLibrary("shell32", Shell32.class, W32APIOptions.DEFAULT_OPTIONS);
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
		
		void SetForegroundWindow(int hWnd);

		final int GW_HWNDNEXT = 2;
	}

	public static class WindowInfo {
		int hwnd;
		RECT rect;
		String title;
		int pid;
		String processName;
		int width;
		int height;

		public WindowInfo(int hwnd, RECT rect, int pid, String processName, String title) {
			this.hwnd = hwnd;
			this.rect = rect;
			this.pid = pid;
			this.processName = processName;
			this.title = title;

			this.height = rect.top - rect.bottom;
			this.width = rect.right - rect.left;
		}

		public boolean isMinimized() {
			if (rect.left > -3000) {
				return false;
			} else {
				return true;
			}
		}

		public String toString() {
			return String.format(pid + " - size: (" + width + "," + height + ") - topleft: " + rect.top + ","
					+ rect.left + ") - " + title);
		}
	}

}
