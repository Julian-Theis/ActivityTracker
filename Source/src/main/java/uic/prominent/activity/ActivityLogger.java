package uic.prominent.activity;

import static uic.prominent.activity.util.Utils.getStackTrace;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import uic.prominent.activity.tracker.AppTracker;
import uic.prominent.activity.tracker.KeyTracker;
import uic.prominent.activity.tracker.MouseTracker;
import uic.prominent.activity.tracker.ScreenActivityTracker;
import uic.prominent.activity.tracker.WinLogExtractor;

public class ActivityLogger {
	private static Logger log = LogManager.getRootLogger();
	
	
	public static volatile boolean fStop = false;
	
	public static volatile boolean fWinlog = true;
	public static volatile boolean fKeytrack = true;
	public static volatile boolean fMousetrack = true;
	public static volatile boolean fScreentrack = true;
	public static volatile boolean fApptracker = true;

	private static Properties configFile(String filename) {
		Properties prop = new Properties();
		try {
			log.debug("Loading config file");
			File f = new File(filename);
			InputStream is = new BufferedInputStream(new FileInputStream(f));
			prop.load(is);
			log.debug("Loaded config file");
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
		return prop;
	}

	public static void main(String[] args) {
		try {
			log.debug("Starting application ...");
			Properties basicconf = configFile("conf//basic.conf");

			
			/**
			 * ################# WINLOGS ###########################
			 */
			String[] sources = ((String) basicconf.get("SOURCES")).split(",");
			List<WinLogExtractor> extractors = new ArrayList<WinLogExtractor>();
			for (String source : sources) {
				extractors.add(new WinLogExtractor(source, basicconf));
			}
			log.debug("Extractors created.");

			Runnable winLogTask = () -> {
				try {		
					int sleep = 0;
					int interval = Integer.parseInt(basicconf.getProperty("WINLOG_INTERVAL")) * 1000;
					while (!fWinlog) {
						extractors.parallelStream().forEach((extractor) -> {
							extractor.extract();
						});
						
						sleep = 0;
						while((sleep < interval) && !fWinlog){
							TimeUnit.MILLISECONDS.sleep(10);
							sleep += 10;
							if(fStop){
								extractors.parallelStream().forEach((extractor) -> {
									extractor.extract();
								});
								fWinlog = true;
								log.debug("WINLOG module stopped.");
							}
						}	
						
					}
				} catch (Exception e) {
					log.error(getStackTrace(e));
				}
			};
			
			
			/**
			 * ################# MOUSETRACKING ###########################
			 */
			
			Runnable mouseTrackingTask = () -> {
				try{
					int buffersize = Integer.parseInt(basicconf.getProperty("MOUSETRACE_BUFFER"));
					int mousetraceInterval = Integer.parseInt(basicconf.getProperty("MOUSETRACE_INTERVAL"));
					int sleep = 0;
					int cnt = 0;
					MouseTracker tracker = new MouseTracker(basicconf.getProperty("OUTPUT_DIR_MOUSETRACE"));
					List<String> entries = new ArrayList<String>();
					while(!fMousetrack){
						entries.add(tracker.getPositionEntry());
						cnt++;
						if(cnt > buffersize){
							tracker.toFile(entries);
							entries.clear();
							cnt = 0;
						}						
						sleep = 0;
						while((sleep < mousetraceInterval) && !fMousetrack){
							TimeUnit.MILLISECONDS.sleep(10);
							sleep += 10;
							if(fStop){
								tracker.toFile(entries);
								fMousetrack = true;
								log.debug("MOUSETRACKING module stopped.");
							}
						}	
					}
				}catch(Exception e){
					log.error(getStackTrace(e));
				}
			};
			
			
			/**
			 * ################# KEYTRACKING ###########################
			 */
			
			
			Runnable keyTrackTask = () -> {
				try{
					KeyTracker keyTracker = new KeyTracker(basicconf.getProperty("OUTPUT_DIR_KEYTRACKER"));
					try {
						GlobalScreen.registerNativeHook();
					}
					catch (NativeHookException ex) {
						log.error("There was a problem registering the native hook.");
						log.error(ex.getMessage());
						System.exit(1);
						log.error(getStackTrace(ex));
					}
					GlobalScreen.addNativeKeyListener(keyTracker);
					GlobalScreen.addNativeMouseListener(keyTracker);
					GlobalScreen.addNativeMouseWheelListener(keyTracker);
					
					while(!fKeytrack){
						if(fStop){
							keyTracker.toFile();
							fKeytrack = true;
							log.debug("KEYTRACKING module stopped.");
						}
						TimeUnit.SECONDS.sleep(1);
					}
					
				}catch(Exception e){
					log.error(getStackTrace(e));
				}
			};
			
			/**
			 * ################# SCREENACTIVITY ###########################
			 */
			Runnable screenTrackTask = () -> {
				int interval = Integer.parseInt(basicconf.getProperty("SCREENACTIVITY_INTERVAL"));
				ScreenActivityTracker screenTracker = new ScreenActivityTracker(basicconf.getProperty("OUTPUT_DIR_SCREENACTIVITY"));
				try{
					while(!fScreentrack){
						screenTracker.capture();
						long lasttime = screenTracker.getLastTime();
						long difference = interval - (System.currentTimeMillis() - lasttime);
						TimeUnit.MILLISECONDS.sleep(difference);
						if(fStop){
							fScreentrack = true;
							log.debug("SCREENACTIVITY module stopped.");
						}
					}
				}catch(Exception e){
					log.error(getStackTrace(e));
				}
			};
			
			/**
			 * ################# APPTRACKER ###########################
			 */
			Runnable appTrackTask = () -> {
				int interval = Integer.parseInt(basicconf.getProperty("APPTRACKER_INTERVAL"));
				AppTracker appTracker = new AppTracker(basicconf.getProperty("OUTPUT_DIR_APPTRACKER"), Long.parseLong(basicconf.getProperty("APPTRACKER_WRITE_INTERVAL")));
				try{
					while(!fApptracker){
						long lasttime = System.currentTimeMillis();
						appTracker.track();
						long difference = interval - (System.currentTimeMillis() - lasttime);
						TimeUnit.MILLISECONDS.sleep(difference);
						if(fStop){
							appTracker.forceWrite();
							fApptracker = true;
							log.debug("APPTRACKER module stopped.");
						}
					}
				}catch(Exception e){
					log.error(getStackTrace(e));
				}
			};
			

			/**
			 * ################# ACTIVATE MODULES ###########################
			 */
			if(basicconf.getProperty("WINLOGS").equals("ON")){
				fWinlog = false;
				Thread winLogThread = new Thread(winLogTask);
				winLogThread.start();
				log.debug("WINLOGS module started");
			}
			
			if(basicconf.getProperty("MOUSETRACE").equals("ON")){
				fMousetrack = false;
				Thread mouseTrackingThread = new Thread(mouseTrackingTask);
				mouseTrackingThread.start();
				log.debug("MOUSETRACE module started");
			}
			
			if(basicconf.getProperty("KEYTRACKER").equals("ON")){
				fKeytrack = false;
				Thread keyTrackThread = new Thread(keyTrackTask);
				keyTrackThread.start();
				log.debug("KEYTRACKER module started");
			}
			
			if(basicconf.getProperty("SCREENACTIVITY").equals("ON")){
				fScreentrack = false;
				Thread screenTrackThread = new Thread(screenTrackTask);
				screenTrackThread.start();
				log.debug("SCREENACTIVITY module started");
			}
			
			if(basicconf.getProperty("APPTRACKER").equals("ON")){
				fApptracker = false;
				Thread appTrackThread = new Thread(appTrackTask);
				appTrackThread.start();
				log.debug("APPTRACKER module started");
			}

		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
		
		
		Runnable commandLineTask = () -> {
			try{
				while(true){
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					String command = reader.readLine();
					
					if(command.equals("stop")){
						log.debug("Stopping the application ...");
						
						fStop = true;
						while(fWinlog == false || fMousetrack == false || fKeytrack == false || fScreentrack == false || fApptracker == false){
							TimeUnit.SECONDS.sleep(1);
						}
						log.debug("Application closed.");
						System.exit(0);
						
					}else{
						System.out.println("Unknown command " + command);
					}
				}
			}catch(Exception e){
				log.error(getStackTrace(e));
			}
		};
		
		Thread commandLineThread = new Thread(commandLineTask);
		commandLineThread.start();
		log.debug("CommandLine module started");
	}
}