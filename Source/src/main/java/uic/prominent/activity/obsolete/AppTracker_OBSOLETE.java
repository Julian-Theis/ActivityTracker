package uic.prominent.activity.obsolete;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.profesorfalken.jpowershell.PowerShell;

import static uic.prominent.activity.util.Utils.currentTime;
import static uic.prominent.activity.util.Utils.getStackTrace;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class AppTracker_OBSOLETE {

	private static Logger log = LogManager.getRootLogger();
	private String output_dir;
	private ActiveApplications activeApps;
	
	private PowerShell powerShell;
	
	private List<String> buffer;
	
	public AppTracker_OBSOLETE(String output_dir){
		this.output_dir = output_dir;
		
		try{
			powerShell = PowerShell.openSession();
			//Print results 
			//System.out.println(powerShell.executeCommand("Set-ExecutionPolicy RemoteSigned").getCommandOutput());
			//System.out.println(powerShell.executeCommand("Set-ExecutionPolicy Unrestricted").getCommandOutput());
			//System.out.println(powerShell.executeCommand("Set-ExecutionPolicy bypass").getCommandOutput());
			powerShell.executeCommand(". .\\Get-Window.ps1");
			System.out.println(". .\\Get-Window.ps1");
			//System.out.println(powerShell.executeCommand(". .\\Get-Window.ps1")..getCommandOutput());
			
		}catch(Exception e){
			log.error(getStackTrace(e));
		}
		
		activeApps = new ActiveApplications();
	}
	
	public void track(){
		long time = System.currentTimeMillis();
		List<String> events = activeApps.update(getListOfUIProcesses(), time);
		String command = activeApps.getWindowCommand();
		System.out.println(command);
		
		events.addAll(activeApps.updateWindows(getWindowInfo(command), time));
		this.toFile(events);
	}
	
	private Map<Integer, String[]> getWindowInfo(String command){
		Map<Integer, String[]> temp = new HashMap<Integer, String[]>();
		try{
			String[] lines = powerShell.executeCommand(command).getCommandOutput().split("\\r?\\n");
			for(int i = 0; i < lines.length; i++){
				if(lines[i].contains("ProcessName")){
					
					String[] size = lines[i+2].split(": ")[1].split(",");
					String[] pos = lines[i+3].split(": ")[1].split(",");
					String[] str = {
							size[0], // width
							size[1], //height
							pos[1], //top left x
							pos[0] //top left y
							};
					
					temp.put(Integer.parseInt(lines[i+1].split(": ")[1]),str);
					i+=4;
				}
			}
		
		}catch(Exception e){
			log.error(getStackTrace(e));
		}
		
		return temp;
	}
	
	private void toFile(List<String> buffer) {
		try{
			if(buffer.size() > 0){
				log.debug("Prepare APPTRACKER log");
				FileWriter fileWriter = new FileWriter(this.output_dir + "apptracker_" + currentTime() + ".tsv");
				PrintWriter printWriter = new PrintWriter(fileWriter);
				for (String entry : buffer) {
					printWriter.println(entry);
				}
				printWriter.close();
				log.debug("APPTRACKER log written");
			}
		}catch(Exception e){
			log.error(getStackTrace(e));
		}
	}
	
	private List<String[]> getListOfUIProcesses(){
		List<String[]> temp = new ArrayList<String[]>();
		try{
			String command = "powershell -command \"get-Process | format-table Id, processname, mainwindowtitle\"";
			
			Process p = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = input.readLine();
            int outLen = 500;
            int header = 0;
            while(line != null && outLen > 0){
            	line = input.readLine().trim().toLowerCase();
        		outLen = line.length();
            	if(header < 2){
            		header++;
            	}else{
	            	String[] arr = line.split(" ");
	            	if(arr.length > 2){
	            		String[] str = {arr[0], arr[1], parseWindowTitle(arr)};
	            		temp.add(str);
	            	}
            	}
            }
            input.close();
		}catch(Exception e){
			log.error(getStackTrace(e));
		}
		
		return temp;
	}
	
	private String parseWindowTitle(String[] input){
		String title="";
		boolean started = false;
		for(int i = 2; i < input.length; i++){
			if(!(!started && input[i].equals(""))){
				started = true;
				title += input[i] + " ";
			}
		}
		return title;
	}
	
	public void stop(){
		this.powerShell.close();
	}
}
