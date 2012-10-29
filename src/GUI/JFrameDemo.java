package GUI; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;

public class JFrameDemo extends JFrame {

	private static final long serialVersionUID = 1;

	public JFrameDemo() {
		setTitle("JFrame Demo - Just a blank Windows");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JFrameDemo();
	}
}
