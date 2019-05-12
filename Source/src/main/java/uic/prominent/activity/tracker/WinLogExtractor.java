package uic.prominent.activity.tracker;

import static uic.prominent.activity.util.Utils.currentTime;
import static uic.prominent.activity.util.Utils.getStackTrace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Advapi32Util.EventLogIterator;
import com.sun.jna.platform.win32.Advapi32Util.EventLogRecord;

public class WinLogExtractor {

	private static Logger log = LogManager.getRootLogger();

	private String source;
	private String output_dir;
	private String[] output_interfaces;

	private int lastid;
	private File temp_file;

	public WinLogExtractor(String source, Properties conf) {
		try{
			this.source = source;
			output_interfaces = conf.getProperty("OUTPUT_INTERFACE").split(",");
			this.output_dir = conf.getProperty("OUTPUT_DIR_WINLOGS");
			this.temp_file = new File("temp/" + source + ".temp");		
			
			this.getLastId();
		}catch(Exception e){
			log.error(getStackTrace(e));
		}
	}
	
	public void extract(){
		try{
			for(String output_interface : this.output_interfaces){
				if(output_interface.equals("file"))
					this.extract_file();
			}
		}catch(Exception e){
			log.error(getStackTrace(e));
		}
	}

	private void extract_file() {
		try {
			log.debug("Write" + source + " log");
			FileWriter fileWriter = new FileWriter(output_dir + source + "_" + currentTime() + ".tsv");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			EventLogIterator iter = new Advapi32Util.EventLogIterator(source);
			while (iter.hasNext()) {
				EventLogRecord record = iter.next();
				if (this.lastid < record.getRecordNumber()) {
					printWriter.println(this.getEventString(record));
					this.lastid = record.getRecordNumber();
				}
			}
			this.updateTempID();
			printWriter.close();
			log.debug(source + " log written");
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}

	private void getLastId() {
		try {
			if (!this.temp_file.exists()) {
				this.lastid = 0;
				Writer output = new BufferedWriter(new FileWriter(temp_file));
				output.write("0");
				output.close();
			} else {
				BufferedReader reader = new BufferedReader(new FileReader(temp_file));
				String line;
				while ((line = reader.readLine()) != null) {
					this.lastid = Integer.parseInt(line);
				}
				reader.close();
			}
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}

	private void updateTempID() {
		try {
			Writer output = new BufferedWriter(new FileWriter(temp_file));
			output.write((new Integer(this.lastid)).toString());
			output.close();
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}
	
	
	private String getEventString(EventLogRecord record){	

		// RecordNumber, TimeGenerated, Length, EventID, Source, String contents		
		String line = "";
		try{
			line += record.getRecordNumber();
			line += "\t";
			line += record.getRecord().TimeGenerated;
			line += "\t";
			line += record.getRecord().Length;
			line += "\t";
			line += record.getEventId();
			line += "\t";
			line += record.getRecord().EventType;
			line += "\t";
			line += record.getRecord().EventCategory;
			line += "\t";
			line += record.getSource();
		}catch(Exception e){
			log.error(getStackTrace(e));
		}

		try {
			if(record.getStrings() != null){
				String[] strings = record.getStrings();
				if(strings.length > 0){
					line += "\t";
				}
				for (String str : strings) {
					str = str.replace('\n', ' ');
					line += " ";
					line += str;
				}
			}
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
		return line;
	}
}
