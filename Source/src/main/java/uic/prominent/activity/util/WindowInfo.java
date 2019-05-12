package uic.prominent.activity.util;

import com.sun.jna.platform.win32.WinDef.RECT;

public class WindowInfo {
	public int hwnd;
	public RECT rect;
	public String title;
	public int pid;
	public String processName;
	public int width;
	public int height;
	public boolean minimized;
	
	public String misc;

	public WindowInfo(int hwnd, RECT rect, int pid, String processName, String title, String misc) {
		this.hwnd = hwnd;
		this.rect = rect;
		this.pid = pid;
		this.processName = processName;
		this.title = title;
		this.misc = misc;
		
		this.height = rect.bottom-rect.top;
		this.width = rect.right-rect.left;
		
		if(rect.left > -3000){
			minimized = false;
		}else{
			minimized = true;
		}
	}
	
	
	public String toString() {
		return String.format(pid + " " + processName + " - size: (" + width + "," + height + ") - topleft: " + rect.top + "," + rect.left + ") - " + title );
	}
	
	public boolean isSame(WindowInfo external){
		if(external.pid == this.pid && this.processName.equals(external.processName))
			return true;
		else
			return false;
	}
	
	public boolean sizeOrPositionChanged(WindowInfo external){
		if(this.width != external.width || this.height != external.height || this.rect.left != external.rect.left || this.rect.top != external.rect.top)
			return true;
		else
			return false;
	}
	
	public boolean isExplorer(){
		return ((this.processName.toLowerCase()).equals("explorer.exe"));
	}
	
	public boolean miscChanged(WindowInfo external){
		return !(this.misc.equals(external.misc));
	}
}