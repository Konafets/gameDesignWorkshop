package Graphics; /**
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
		setTitle("Main Window 1");
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameDemo();
	}
}
