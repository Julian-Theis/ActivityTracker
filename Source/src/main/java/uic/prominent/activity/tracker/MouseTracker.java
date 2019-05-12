package uic.prominent.activity.tracker;

import static uic.prominent.activity.util.Utils.currentTime;
import static uic.prominent.activity.util.Utils.getStackTrace;

import java.awt.MouseInfo;
import java.awt.Point;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MouseTracker {
	private static Logger log = LogManager.getRootLogger();
	private String output_dir;

	public MouseTracker(String output_dir){
		this.output_dir = output_dir;
	}
	
	public Point getPosition(){
		return MouseInfo.getPointerInfo().getLocation();
	}
	
	public String getPositionEntry(){
		Point p = getPosition();
		return System.currentTimeMillis() + "\tM\t[" + (int) p.getX() + "," + (int) p.getY() + "]";
	} 
	
	public void toFile(List<String> entries) {
		try {
			log.debug("Write mouse tracking log");
			OutputStreamWriter printWriter = new OutputStreamWriter(new FileOutputStream(output_dir + "mousetrace_" + currentTime() + ".tsv"), StandardCharsets.UTF_8);
			for(String entry : entries) {
				printWriter.write(entry + "\n");
				printWriter.flush();
			}
			printWriter.close();
			log.debug("mouse tracking written");
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}
	

}
