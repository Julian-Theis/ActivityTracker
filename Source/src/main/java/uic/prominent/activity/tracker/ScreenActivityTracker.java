package uic.prominent.activity.tracker;

import static uic.prominent.activity.util.Utils.currentTime;
import static uic.prominent.activity.util.Utils.getStackTrace;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScreenActivityTracker {

	private static Logger log = LogManager.getRootLogger();
	private String output_dir;

	private Rectangle screenRect;
	private BufferedImage img1;
	private BufferedImage img2;
	private Robot robot;

	private double widthFactor = 0.2;
	private double heightFactor = 0.2;
	
	private long lasttime;

	public ScreenActivityTracker(String output_dir) {
		robot = null;
		try {
			this.output_dir = output_dir;
			robot = new Robot();
			this.screenRect = getScreenRect();
			this.lasttime = System.currentTimeMillis();
			img1 = resize(robot.createScreenCapture(screenRect));
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}

	public void capture() {
		try {
			//while(flag){
				img2 = resize(robot.createScreenCapture(screenRect));
				BufferedImage activityImage = differenceImage(img1, img2);
				lasttime = System.currentTimeMillis();
				img1 = img2;
				toFile(activityImage);
			//}
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}
	
	public long getLastTime(){
		return this.lasttime;
	}

	private void toFile(BufferedImage img) {
		try {
			log.debug("Prepare writing screenactivity");
			ImageIO.write(img, "png", new File(output_dir + "activity_ " + currentTime() + ".png"));
			log.debug("Screenactivity written");
		} catch (Exception e) {
			log.error(getStackTrace(e));
		}
	}

	private Rectangle getScreenRect() {
		Rectangle screenRect = new Rectangle(0, 0, 0, 0);
		for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
			screenRect = screenRect.union(gd.getDefaultConfiguration().getBounds());
		}
		return screenRect;
	}

	private BufferedImage differenceImage(BufferedImage img1, BufferedImage img2) {
		BufferedImage difference = new BufferedImage(img1.getWidth(), img1.getHeight(), img1.getType());

		for (int xx = 0; xx < img1.getWidth(); xx++) {
			for (int yy = 0; yy < img1.getHeight(); yy++) {
				Color originalColor = new Color(img1.getRGB(xx, yy));
				int r1 = originalColor.getRed();
				int g1 = originalColor.getGreen();
				int b1 = originalColor.getBlue();

				Color newColor = new Color(img2.getRGB(xx, yy));
				int r2 = newColor.getRed();
				int g2 = newColor.getGreen();
				int b2 = newColor.getBlue();

				Color bnw = Color.white;
				if ((r1 == r2 || isRelativelyEqual(r1, r2)) && (g1 == g2 || isRelativelyEqual(g1, g2)) && (b1 == b2)
						|| isRelativelyEqual(b1, b2)) {
					bnw = Color.black;
				}
				difference.setRGB(xx, yy, bnw.getRGB());
			}
		}
		return difference;
	}

	private static boolean isRelativelyEqual(double d1, double d2) {
		return 0.1 > Math.abs(d1 - d2) / Math.max(Math.abs(d1), Math.abs(d2));
	}

	private BufferedImage resize(BufferedImage input) {
		int newWidth = new Double(input.getWidth() * widthFactor).intValue();
		int newHeight = new Double(input.getHeight() * heightFactor).intValue();

		BufferedImage resized = new BufferedImage(newWidth, newHeight, input.getType());
		Graphics2D g = resized.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(input, 0, 0, newWidth, newHeight, 0, 0, input.getWidth(), input.getHeight(), null);
		g.dispose();

		return resized;
	}

}
