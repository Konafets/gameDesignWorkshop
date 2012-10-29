package Graphics;

/**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * Courtesy of the castle image to Reiner Prokein
 * @see http://www.reinerstilesets.de/de/2d-grafiken/2d-buildings/
 * 
 * @version October 20, 2012
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import GUI.JFrameDemo;

@SuppressWarnings("serial")
public class DrawBitmap extends JFrameDemo {

	private BufferedImage image = null;
	private MediaTracker mediaTracker = new MediaTracker(this);

	public DrawBitmap() {
		initCanvas("Draw Bitmap Demo", 800, 600);
		image = loadImage("Images/castle.png");
		repaint();
		setVisible(true);
	}

	/**
	 * the read-method streams the image ... so force a repaint
	 * 
	 * @param fileName
	 */
	private BufferedImage loadImage(String fileName) {
		BufferedImage image = null;
		URL url;
		try {
			// file directory relative to the file structure of the class
			url = this.getClass().getResource(fileName);
			// System.out.println(url);
			image = ImageIO.read(url);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		mediaTracker.addImage(image, 1);
		try {
			mediaTracker.waitForAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return image;
	}

	@Override
	public void paint(Graphics g) {
		// Graphics2D is a more powerful version of the Graphics class
		Graphics2D graphicContext = (Graphics2D) g;
		clearCanvas(graphicContext);
		if (image != null) {
			graphicContext.drawImage(image, 0, 40, this);
		} else {
			System.out.println("frame not yet loaded");
		}
	}

	public static void main(String[] args) {
		new DrawBitmap();
	}
}
