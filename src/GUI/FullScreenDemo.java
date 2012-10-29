package GUI; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import javax.swing.*;
import java.awt.*;

public class FullScreenDemo extends JFrame {

	private static final long serialVersionUID = 1;
	private static final long DEMO_TIME = 5000;

	public void run(DisplayMode displayMode) {
		setBackground(Color.blue);
		setForeground(Color.white);
		setFont(new Font("Tahoma", 0, 24));

		ScreenManager screen = new ScreenManager();
		try {
			screen.setFullScreen(displayMode, this);
			try {
				Thread.sleep(DEMO_TIME);
			} catch (InterruptedException ex) {
			}
		} finally {
			screen.restoreScreen();
		}
	}

	public void paint(Graphics renderContext) {
		renderContext.drawString("Hello World!", 20, 50);
	}

	public static void main(String[] args) {
		DisplayMode displayMode = new DisplayMode(800, 600, 16,
				DisplayMode.REFRESH_RATE_UNKNOWN);
		FullScreenDemo test = new FullScreenDemo();
		test.run(displayMode);
	}
}
