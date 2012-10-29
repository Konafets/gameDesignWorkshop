package GUI; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerDemo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;

	public ActionListenerDemo() {
		setTitle("ActionListener Demo");
		setSize(300, 280);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JButton btn = new JButton("Du triffst mich NIE!");
		btn.addActionListener(this);
		add(btn);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setText("Das gildet nicht!");
	}

	public static void main(String[] args) {
		new ActionListenerDemo();
	}
}
