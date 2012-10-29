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
import java.awt.geom.Rectangle2D;
import GUI.JFrameDemo;

@SuppressWarnings("serial")
public class DrawRectangle extends JFrameDemo {

	public DrawRectangle() {
		initCanvas("Draw Rectangle Demo", 800, 600);
		setVisible(true);
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
		Shape borderRectangle = new Rectangle2D.Double(xPosition, yPosition,
				xSize, ySize);
		renderContext.setColor(borderColor);
		renderContext.fill(borderRectangle);

		// determine new color, positions and dimensions
		Color fillColor = new Color(Tools.getNumber());
		xPosition = Tools.getCenteredNumber(canvasWidth);
		yPosition = Tools.getCenteredNumber(canvasHeight);
		xSize = Tools.getNumber(canvasWidth / 2);
		ySize = Tools.getNumber(canvasHeight / 2);
		Shape filledRectangle = new Rectangle2D.Double(xPosition, yPosition,
				xSize, ySize);
		renderContext.setColor(fillColor);
		renderContext.draw(filledRectangle);
	}

	@Override
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
