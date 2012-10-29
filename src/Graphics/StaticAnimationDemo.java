package Graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import GUI.JFrameDemo;

/**
 * @author Knut Hartmann <BR>
 *         Flensburg University of Applied Sciences <BR>
 *         Knut.Hartmann@FH-Flensburg.DE
 * 
 *         Courtesy of the ship image to Jonathan S. Harbour
 * @see http://jharbour.com/wordpress/portfolio/beginning-java-se-6-game-programming-3rd-ed/
 * 
 * @version October 21, 2012
 */

@SuppressWarnings("serial")
public class StaticAnimationDemo extends JFrameDemo {

	private StaticAnimation player;

	public StaticAnimationDemo() {
		initCanvas("Static Animation Demo", 800, 600);
		player = new StaticAnimation(this);
		player.addFrame("Images/ship_shield.png");
		player.addFrame("Images/ship_thrust.png");
		player.animate();
		setVisible(true);
	}

	public void paint(Graphics g) {
		Graphics2D graphicContext = (Graphics2D) g;
		clearCanvas(graphicContext);
		player.draw(graphicContext);
	}

	public static void main(String[] args) {
		new StaticAnimationDemo();
	}
}
