package Graphics; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DrawRectangle extends JFrame {

	private static final long serialVersionUID = 1;

	// convenience functions to access the dimensions of the current render
	// context and the definition of the background color used in the canvas
	private int canvasWidth, canvasHeight;
	private Color backgroundColor = Color.BLACK;

	public DrawRectangle() {
		super("Draw Rectangle");
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
	public void clearCanvas(Graphics renderContext) {
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
		Color borderColor = new Color(Tools.getNumber());	
		int xPosition = Tools.getCenteredNumber(canvasWidth);
		int yPosition = Tools.getCenteredNumber(canvasHeight);
		int xSize = Tools.getNumber(canvasWidth / 2);
		int ySize = Tools.getNumber(canvasHeight / 2);
		Shape borderRectangle = new Rectangle2D.Double(xPosition, yPosition, xSize, ySize);
		renderContext.setColor(borderColor);
		renderContext.fill(borderRectangle);
		
		// determine new color, positions and dimensions 
		Color fillColor = new Color(Tools.getNumber());
		xPosition = Tools.getCenteredNumber(canvasWidth);
		yPosition = Tools.getCenteredNumber(canvasHeight);
		xSize = Tools.getNumber(canvasWidth / 2);
		ySize = Tools.getNumber(canvasHeight / 2);		
		Shape filledRectangle = new Rectangle2D.Double(xPosition, yPosition, xSize, ySize);
		renderContext.setColor(fillColor);
		renderContext.draw(filledRectangle);	
	}

	public void paint(Graphics g) {
		// Graphics2D is a more powerful version of the Graphics class
		Graphics2D renderContext = (Graphics2D) g;
		clearCanvas(renderContext);
		drawRectangle(renderContext);
	}

	public static void main(String[] args) {
		new DrawRectangle();
	}
}
