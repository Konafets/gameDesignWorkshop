package Graphics; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;
import java.awt.*;

public class CanvasDemo extends JFrame {
	
	private static final long serialVersionUID = 1;
	
	public CanvasDemo() {
		setTitle("Canvas Demo");
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void paint(Graphics renderContext) {
		System.out.println("Test");
		
		// renderContext implements a finite state machine, i.e.,
		// changes will effect the rendering until they are redefined
		setBackground(Color.LIGHT_GRAY);
		
		renderContext.setColor(Color.BLACK);
		// coordinates of the starting and end point
		renderContext.drawLine(100, 100, 600, 600);

		// RBG (additive) color definition:
		// 0.0f minimal intensity
		// 1.0f maximal intensity
		Color c = new Color(0.0f, 0.0f, 1.0f);
		renderContext.setColor(c);
		// rectangle definition: coordinates of the left upper corner + dimensions 
		renderContext.fillRect(200, 200, 100, 200);

		// text display. 
		renderContext.setColor(Color.RED);
		renderContext.setFont(new Font("Tahoma", Font.ITALIC, 30));
		renderContext.drawString("Hello World!", 30, 60);
	}	
	
	public static void main(String[] args) {
		new CanvasDemo();
	}
}
