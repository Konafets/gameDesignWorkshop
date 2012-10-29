package Graphics;

/**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 19, 2012
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import GUI.JFrameDemo;

@SuppressWarnings("serial")
public class RandomRectangle extends JFrameDemo {

	// a single rectangle shape will be reused again and again
	// global variables to control the maximal size of a rectangle and the
	// number of rectangles
	Shape rectangleShape = new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0);
	private final double MAX_RECTANGLE_SIZE = 200.0;
	private final int MAX_RECTANGLES = 500;
	// affine transformations summarize translations, scalings and rotations
	// a identity transformation does not affect position, size or rotation
	private AffineTransform identity = new AffineTransform();

	public RandomRectangle() {
		initCanvas("Random Rectangle", 800, 600);
		setVisible(true);
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

	/**
	 * draw rectangles
	 * 
	 * @param graphicContext
	 *            a handle to the canvas object
	 */
	public void drawRectangle(Graphics2D graphicContext) {
		Color fillColor = new Color(Tools.getNumber());
		int xPosition = Tools.getNumber(canvasWidth);
		int yPosition = Tools.getNumber(canvasHeight);
		double xScale = Tools.getDouble(MAX_RECTANGLE_SIZE);
		double yScale = Tools.getDouble(MAX_RECTANGLE_SIZE);
		double angle = Math.toRadians(Tools.getDouble(360));

		// reset previous changes 
		graphicContext.setTransform(identity);
		// apply transformation
		graphicContext.translate(xPosition, yPosition);
		graphicContext.scale(xScale, yScale);
		graphicContext.rotate(angle);
		graphicContext.setColor(fillColor);
		graphicContext.fill(rectangleShape);
	}

	@Override
	public void paint(Graphics g) {
		// Graphics2D is a more powerful version of the Graphics class
		Graphics2D graphicContext = (Graphics2D) g;
		clearCanvas(graphicContext);
		for (int counter = 0; counter < MAX_RECTANGLES; counter++) {
			drawRectangle(graphicContext);
		}
	}

	public static void main(String[] args) {
		new RandomRectangle();
	}
}
