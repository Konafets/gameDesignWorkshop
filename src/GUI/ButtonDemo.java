package GUI; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;

public class ButtonDemo extends JFrame {

	private static final long serialVersionUID = 1;
	
	public ButtonDemo() {
		setTitle("Inserts a button into a display container");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// insert a button into the display container 
		JButton btn = new JButton("Hello World!");
		add(btn);
		setVisible(true);		
	}

	public static void main(String[] args) {
		new ButtonDemo();
	}
}
