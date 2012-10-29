package GUI; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerDemo extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1;

	public MouseListenerDemo() {
		setTitle("Mouse Listener Demo");
		setSize(300, 280);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JButton btn = new JButton("Label");
		btn.addMouseListener(this);
		add(btn);
		setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setText("Getroffen!");
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public static void main(String[] args) {
		new MouseListenerDemo();
	}
}
