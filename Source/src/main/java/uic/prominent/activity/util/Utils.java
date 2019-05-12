package uic.prominent.activity.util;

public final class Utils {
	public static String getStackTrace(Exception e){
		String message = e.getMessage();
		for(StackTraceElement stackTraceElement : e.getStackTrace()) {                         
		    message = message + System.lineSeparator() + stackTraceElement.toString();
		}   
		return message;
	}
	
	public static String currentTime() {
		return (System.currentTimeMillis() / 1000) + "";
	}
}
