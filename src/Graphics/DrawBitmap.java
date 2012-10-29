package Graphics; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * some code fragments are used by the following source:
 * "Beginning Java Game Programming", 3rd Edition by Jonathan S. Harbour
 * Courtesy of the Castel Image to Reiner Prokein
 * @see http://www.reinerstilesets.de/de/2d-grafiken/2d-buildings/
 * 
 * @version October 14, 2012
 */

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DrawBitmap extends JFrame {

	private static final long serialVersionUID = 1L;
	// convenience functions to access the dimensions of the current render
	// context and the definition of the background color used in the canvas
	private int canvasWidth, canvasHeight;
	private Color backgroundColor = Color.BLACK;

	private Image image;

	public DrawBitmap() {
		super("Draw Bitmap Demo");
		setSize(800, 600);
		canvasWidth = getSize().width;
		canvasHeight = getSize().height;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage(getURL("Images/castle.png"));
	}

	private URL getURL(String filename) {
		URL url = null;
		try {
			url = this.getClass().getResource(filename);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return url;
	}

	/**
	 * Fills the background of the canvas with a color defined in
	 * backgroundColor.
	 * 
	 * @param renderContext
	 *            a handle to the canvas object
	 */
	public void clearCanvas(Graphics2D renderContext) {
		// fill background
		renderContext.setColor(backgroundColor);
		renderContext.fillRect(0, 0, canvasWidth, canvasHeight);
	}

	public void paint(Graphics g) {
		// Graphics2D is a more powerful version of the Graphics class
		Graphics2D renderContext = (Graphics2D) g;
		clearCanvas(renderContext);
		renderContext.drawImage(image, 0, 40, this);
	}

	public static void main(String[] args) {
		new DrawBitmap();
	}
}
