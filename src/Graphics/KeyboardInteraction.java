package Graphics; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class KeyboardInteraction extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1;

	// convenience functions to access the dimensions of the current render
	// context and the definition of the background color used in the canvas
	private int canvasWidth, canvasHeight;
	private Color backgroundColor = Color.BLACK;
	// rectangle definition and its geometric attributes
	private Rectangle2D rectangleShape;
	private Color fillColor;
	private int xPosition, yPosition;
	private int deltaX = 0;
	private int deltaY = 0;
	private int rectangleWidth, rectangleHeight;

	// affine transformations summarize translations, scalings and rotations
	// a identity transformation does not affect position, size or rotation
	private AffineTransform identity = new AffineTransform();

	public KeyboardInteraction() {
		super("Keyboard Interaction Demo");
		initCanvas();
		initRectangle();
		addKeyListener(this);
	}

	private void initCanvas() {
		// define the dimensions of the canvas
		setSize(800, 600);
		// the operation system must not follow hints, so double check it
		canvasWidth = getSize().width;
		canvasHeight = getSize().height;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	 * Fills the background of the canvas with a color defined in
	 * backgroundColor.
	 * 
	 * @param renderContext
	 *            a handle to the canvas object
	 */
	private void clearCanvas(Graphics2D renderContext) {
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
	private void drawRectangle(Graphics2D renderContext) {
		// reset previous changes
		renderContext.setTransform(identity);
		// apply transformation
		renderContext.translate(xPosition, yPosition);
		renderContext.setColor(fillColor);
		renderContext.fill(rectangleShape);
	}

	public void paint(Graphics g) {
		// Graphics2D is a more powerful version of the Graphics class
		Graphics2D renderContext = (Graphics2D) g;
		clearCanvas(renderContext);
		drawRectangle(renderContext);
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
		case KeyEvent.VK_UP:
		case KeyEvent.VK_NUMPAD8:
		case KeyEvent.VK_W:
			deltaY--;
			yPosition = yPosition + deltaY;
			if (yPosition < 0) {
				yPosition = canvasHeight;
			}
			repaint();
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_NUMPAD2:
		case KeyEvent.VK_S:
			deltaY++;
			yPosition =+ yPosition + deltaY;
			if (yPosition > canvasHeight) {
				yPosition = 0;
			}
			repaint();
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		deltaX = 0;
		deltaY = 0;
	}

	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		new KeyboardInteraction();
	}
}
