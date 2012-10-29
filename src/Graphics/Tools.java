package Graphics; /**
 * @author Knut Hartmann <BR>
 * Flensburg University of Applied Sciences <BR>
 * Knut.Hartmann@FH-Flensburg.DE
 * 
 * @version October 14, 2012
 */

import java.util.Random;

public final class Tools {

	private static Random randomGenerator = new Random();

	public static int getNumber() {
		int result = Math.abs(randomGenerator.nextInt());
		return result;
	}

	public static int getNumber(int maximum) {
		int result = Math.abs(randomGenerator.nextInt()) % maximum;
		return result;
	}

	public static int getCenteredNumber(int maximum) {
		int center = maximum / 2;
		int offset = randomGenerator.nextInt() % (maximum / 2);
		return center + offset;
	}

	/**
	 * Rendom.nextDouble returns a double value in the interval [0.0, 1.0).
	 * 
	 * @param scaleFactor
	 *            maximal return value
	 * @return result a pseudo random double in the interval [0.0, scaleFactor)
	 */
	public static double getDouble(double scaleFactor) {
		double result = Math.abs(randomGenerator.nextDouble()) * scaleFactor;
		return result;
	}
}
