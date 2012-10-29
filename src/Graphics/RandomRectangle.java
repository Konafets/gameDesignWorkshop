package Graphics;
/**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class RandomRectangle extends JFrame {

	private static final long serialVersionUID = 1;

	// convenience functions to access the dimensions of the current render
	// context and the definition of the background color used in the canvas
	private int canvasWidth, canvasHeight;
	private Color backgroundColor = Color.BLACK;
	// a single rectangle shape will be reused again and again
	// global variables to control the maximal size of a rectangle and the
	// number of rectangles
	Shape rectangleShape = new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0);
	private double maxRectangleSize = 200.0;
	private final int maxRectangles = 5;
	// affine transformations summarize translations, scalings and rotations
	// a identity transformation does not affect position, size or rotation
	private AffineTransform identity = new AffineTransform();

	public RandomRectangle() {
		super("Random Rectangle");
		// define the dimensions of the canvas 
		setSize(800, 600);
		// the operation system must not follow hints, so double check it
		canvasWidth = getSize().width;
		canvasHeight = getSize().height;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	 * @param renderContext
	 *            a handle to the canvas object
	 */
	public void drawRectangle(Graphics2D renderContext) {
		Color fillColor = new Color(Tools.getNumber());
		int xPosition = Tools.getNumber(canvasWidth);
		int yPosition = Tools.getNumber(canvasHeight);
		double xScale = Tools.getDouble(maxRectangleSize);
		double yScale = Tools.getDouble(maxRectangleSize);
		double angle = Math.toRadians(Tools.getDouble(360));

		// reset previous changes 
		renderContext.setTransform(identity);
		// apply transformation
		renderContext.translate(xPosition, yPosition);
		renderContext.scale(xScale, yScale);
		renderContext.rotate(angle);
		renderContext.setColor(fillColor);
		renderContext.fill(rectangleShape);
	}

	public void paint(Graphics g) {
		// Graphics2D is a more powerful version of the Graphics class
		Graphics2D renderContext = (Graphics2D) g;
		clearCanvas(renderContext);
		for (int counter = 0; counter < maxRectangles; counter++) {
			drawRectangle(renderContext);
		}
	}

	public static void main(String[] args) {
		new RandomRectangle();
	}
}
