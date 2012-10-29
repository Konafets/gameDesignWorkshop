package Graphics;

/**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * Courtesy of the Ship Images to 
 * 
 * @version October 21, 2012
 */

import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class StaticAnimation {

	private JFrame canvas;
	private MediaTracker mediaTracker;
	
	private ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
	private int currentFrame = 0;
	private float animationFrequency = 25.0f;
	private int frameTime = Math.round(1000 / animationFrequency);
	private final int ANIMATIN_CYCLES = 25;
	
	Point position = new Point(0, 0);

	public StaticAnimation(JFrame canvas) {
		this.canvas = canvas;
		mediaTracker = new MediaTracker(canvas);
	}

	public void addFrame(String fileName) {
		URL url;
		BufferedImage frame = null;

		try {
			url = this.getClass().getResource(fileName);
			System.out.println(url);
			frame = ImageIO.read(url);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

		mediaTracker.addImage(frame, 1);
		try {
			mediaTracker.waitForAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (frame == null) {
			System.out.println("Error: cant load image " + fileName);
		} else {
			frames.add(frame);
			// center the sprite on canvas
			position.x = (canvas.getWidth() - frame.getWidth()) / 2;
			position.y = (canvas.getHeight() - frame.getHeight()) / 2;
		}
	}

	public BufferedImage getCurrentFrame() {
		if (frames.size() > 0) {
			return frames.get(currentFrame);
		} else {
			return null;
		}
	}

	public void setNextFrame() {
		if (currentFrame < frames.size() - 1) {
			currentFrame++;
		} else {
			currentFrame = 0;
		}
	}

	public void animate() {
		for (int index = 0; index < ANIMATIN_CYCLES; index++) {
			canvas.repaint();
			try {
				Thread.sleep(frameTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setNextFrame();
		}
	}

	public void draw(Graphics2D graphicContext) {
		BufferedImage frame = getCurrentFrame();
		if (frame != null) {
			graphicContext.drawImage(frame, position.x, position.y, canvas);
		} else {
			System.out.println("frame #" + currentFrame + " not yet ready");
		}
	}
}
