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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import GUI.JFrameDemo;

@SuppressWarnings("serial")
public class KeyboardInteraction extends JFrameDemo implements KeyListener {

	private Rectangle2D rectangleShape;
	private Color fillColor;
	private int xPosition, yPosition;
	private int deltaX = 0;
	private int rectangleWidth, rectangleHeight;

	// affine transformations summarize translations, scalings and rotations
	// a identity transformation does not affect position, size or rotation
	private AffineTransform identity = new AffineTransform();

	public KeyboardInteraction() {
		initCanvas("Keyboard Interaction Demo", 800, 600);
		initRectangle();
		addKeyListener(this);
		setVisible(true);
	}

	private void initRectangle() {
		fillColor = Color.WHITE;
		rectangleWidth = 100;
		rectangleHeight = 100;
		// place they rectangle centered on the canvas
		xPosition = (canvasWidth - rectangleWidth / 2) / 2;
		yPosition = (canvasHeight - rectangleHeight / 2) / 2;
		// the translation is done with affine transformations
		rectangleShape = new Rectangle2D.Double(0, 0,
				rectangleWidth, rectangleHeight);
	}

	/**
	 * draw rectangles
	 * 
	 * @param graphicContext
	 *            a handle to the canvas object
	 */
	private void drawRectangle(Graphics2D graphicContext) {
		// reset previous changes
		graphicContext.setTransform(identity);
		// apply transformation
		graphicContext.translate(xPosition, yPosition);
		graphicContext.setColor(fillColor);
		graphicContext.fill(rectangleShape);
	}

	@Override
	public void paint(Graphics g) {
		// Graphics2D is a more powerful version of the Graphics class
		Graphics2D graphicContext = (Graphics2D) g;
		clearCanvas(graphicContext);
		drawRectangle(graphicContext);
	}

	private void traceKeyEvents(KeyEvent e) {
		String msg = "keyCode: " + e.getKeyCode() + " keyChar: "
				+ e.getKeyChar();
		System.out.println(msg);
	}

	public void keyPressed(KeyEvent e) {
		traceKeyEvents(e);

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_NUMPAD4:
		case KeyEvent.VK_A:
			deltaX--;
			xPosition = xPosition + deltaX;
			if (xPosition < 0)
				xPosition = canvasWidth;
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_NUMPAD6:
		case KeyEvent.VK_D:
			deltaX++;
			xPosition =+ xPosition + deltaX;
			if (xPosition > canvasWidth)
				xPosition = 0;
			repaint();
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		deltaX = 0;
	}

	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		new KeyboardInteraction();
	}
}
