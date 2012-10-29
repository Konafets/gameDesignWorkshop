package Graphics;

/**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 19, 2012
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import GUI.JFrameDemo;

@SuppressWarnings("serial")
public class CanvasDemo extends JFrameDemo {
	
	public CanvasDemo() {
		initCanvas("Canvas Demo", 800, 600);
		setVisible(true);
	}

	@Override
	public void paint(Graphics graphicContext) {
		clearCanvas(graphicContext);
		
		graphicContext.setColor(Color.WHITE);
		// coordinates of the starting and end point
		graphicContext.drawLine(100, 100, 600, 600);

		// RBG (additive) color definition:
		// 0.0f minimal intensity
		// 1.0f maximal intensity
		Color c = new Color(0.0f, 0.0f, 1.0f);
		graphicContext.setColor(c);
		// rectangle definition: coordinates of the left upper corner +
		// dimensions
		graphicContext.fillRect(200, 200, 100, 200);

		// text display
		graphicContext.setColor(Color.RED);
		graphicContext.setFont(new Font("Tahoma", Font.ITALIC, 30));
		graphicContext.drawString("Hello World!", 30, 60);
	}

	public static void main(String[] args) {
		new CanvasDemo();
	}
}
