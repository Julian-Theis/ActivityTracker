package uic.prominent.activity.tracker;

import static uic.prominent.activity.util.Utils.currentTime;
import static uic.prominent.activity.util.Utils.getStackTrace;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class KeyTracker implements NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener  {

	private static Logger log = LogManager.getRootLogger();

	private boolean keyPressed;
	private int activeKey;

	private boolean buffer1Active;
	private List<String> buffer1;
	private List<String> buffer2;
	private String output_dir;

	private int[] keyCodes = {29, 3613, 3631, 3675, 28, 3665, 3657, 1, 56, 3640,
			42, 54, 57419, 57416, 57421, 57424, 59, 60, 61, 62 ,63 ,64 ,65 ,66 ,67 ,68 ,87 ,88,15, 14};
	
	private int[] numpadKeyCodes = {2,3,4,5,6,7,8,9,10,11, 82, 83, 79, 80, 81, 75, 76 ,77, 71, 72, 73 ,78 ,74, 55, 3637, 69};
	private int[] shiftKeyCodes = {42, 54};

	public KeyTracker(String output_dir) {
		try {
			this.buffer1Active = true;
			this.buffer1 = new ArrayList<String>();
			this.buffer2 = new ArrayList<String>();

			this.output_dir = output_dir;

			java.util.logging.Logger logger = java.util.logging.Logger
					.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.ALL);

			Handler[] handlers = java.util.logging.Logger.getLogger("").getHandlers();
			for (int i = 0; i < handlers.length; i++) {
				handlers[i].setLevel(Level.OFF);
			}
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		try {
			System.out.println(e.getKeyCode());
			if (IntStream.of(keyCodes).anyMatch(x -> x == e.getKeyCode()) || keyPressed) {
				if (!keyPressed) {
					keyPressed = true;
					activeKey = e.getKeyCode();
				}
				addEntry("K1\t[" + e.getKeyCode() + "]");
			}else if(IntStream.of(numpadKeyCodes).anyMatch(x -> x == e.getKeyCode())){
				addEntry("K1\t[NUM]");
			}else{
				addEntry("K1\t[TEXT]");
			}
		} catch (Exception ex) {
			log.error(getStackTrace(ex));
		}		
		/*
		try {
			if (IntStream.of(keyCodes).anyMatch(x -> x == e.getKeyCode()) || keyPressed) {
				if (!keyPressed) {
					keyPressed = true;
					activeKey = e.getKeyCode();
				}
				if (keyPressed && activeKey != e.getKeyCode()) {
					addEntry("K3\t[" + activeKey + "," + e.getKeyCode()+"]");
				} else {
					addEntry("K1\t[" + e.getKeyCode() + "]");
				}
			}
		} catch (Exception ex) {
			log.error(getStackTrace(ex));
		}
		*/
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		//addEntry("K2\t[" + e.getKeyCode() + "]");
		try {
			if (IntStream.of(keyCodes).anyMatch(x -> x == e.getKeyCode()) || keyPressed) {
				if (keyPressed && (activeKey == e.getKeyCode())) {
					keyPressed = false;
					addEntry("K2\t[" + e.getKeyCode() + "]");
				}else{
					addEntry("K2\t[" + e.getKeyCode() + "]");
				}
			}
		} catch (Exception ex) {
			log.error(getStackTrace(ex));
		}
		
		/*
		try {
			if (keyPressed && (activeKey == e.getKeyCode())) {
				keyPressed = false;
				addEntry("K2\t[" + e.getKeyCode() + "]");
			}
		} catch (Exception ex) {
			log.error(getStackTrace(ex));
		}
		*/
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	public void toFile(){
		if(buffer1Active){
			this.toFile(this.buffer1);
		}else{
			this.toFile(this.buffer2);
		}
	}

	private void toFile(List<String> buffer) {
		try{
			log.debug("Prepare Key tracking log");
			try {
				OutputStreamWriter printWriter = new OutputStreamWriter(new FileOutputStream(this.output_dir + "keytracker_" + currentTime() + ".tsv"), StandardCharsets.UTF_8);
				for (String entry : buffer) {
					printWriter.write(entry + "\n");
					printWriter.flush();
				}
				printWriter.close();
			} catch (Exception e) {
			}
			log.debug("Key tracking log written");
		}catch(Exception e){
			log.error(getStackTrace(e));
		}
	}

	private void addEntry(String str) {
		try{
			String event = System.currentTimeMillis() + "\t" + str;
			if (buffer1Active) {
				buffer1.add(event);
				if (buffer1.size() >= 100) {
					buffer1Active = false;
					toFile(this.buffer1);
					this.buffer1.clear();
				}
			} else {
				buffer2.add(System.currentTimeMillis() + "\t" + str);
				buffer2.add(event);
				if (buffer2.size() >= 100) {
					buffer1Active = true;
					toFile(this.buffer2);
					this.buffer2.clear();
				}
			}
		}catch(Exception e){
			log.error(getStackTrace(e));
		}
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent e) {
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent e) {
		addEntry("K3\t[" + e.getButton() + "," + e.getX() + "," + e.getY() + "]");
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent e) {
		addEntry("K4\t[" + e.getButton() + "," + e.getX() + "," + e.getY() + "]");
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {
	}

	@Override
	public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
		addEntry("K5\t["+e.getWheelRotation()+"]");
	}
}
