//UIUC CS125 FALL 2012 MP. File: RippleEffectApp.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000

import java.awt.Image;
import java.awt.image.BufferedImage;


/**
 * A simple Water ripple effect applied to a picture.
 * 
 * @author angrave
 * 
 */
public class RippleEffectApp {
	private static final String PICTURE_FILENAME = "LHC5.jpg";
	private final static float DAMP_FACTOR = 0.03f;
	private final static float MASS = 5f;
	private final static double DRIP_PROBABILITY = 0.01;
	private final static int w=256,h=256;
	
	/**
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		BufferedImage image = Zen.getCachedImage(PICTURE_FILENAME);
		// Make a smaller version (if it's too larger the simulation is too
		// slow)
		// if it runs too slow on your machine, change the constants here
		Image smallerImage = image.getScaledInstance(w, h, 0);
		int[][] pictureArray = Zen.toRGBArray(smallerImage);

		// our output picture will be displaced in the Y direction to simulation
		// ripples
		int[][] distortedArray = new int[w][h];

		// simulation part. For each part of the surface we need current
		// displacement and velocity
		float[][] displacement = new float[w][h];
		float[][] velocity = new float[w][h];

		// displace the picture at the center of the image
		displacement[w / 2][h / 2] = 100;

		// Main loop: Move the water and display. Occasionally displace it at a
		// random position...
		while (Zen.isRunning()) {
			simulationStep( displacement, velocity);
			display( pictureArray, distortedArray, displacement);
			if (Math.random() < DRIP_PROBABILITY)
				displacement[(int) (Math.random() * w)][(int) (Math.random() * h)] = 10;
		} // while
	}

	/**
	 * Displays the image
	 * 
	 * @param pictureArray
	 *            original picture array
	 * @param distortedArray
	 *            output array
	 * @param displacement
	 *            field
	 */
	private static void display(int[][] pictureArray, int[][] distortedArray, float[][] displacement) {
		for (int x = 0; x < w; x++)
			for (int y = 0; y < h; y++) {
				int srcY = (int) (y + displacement[x][y]);
				if (srcY < 0)
					srcY = 0;
				if (srcY >= h)
					srcY = h - 1;
				distortedArray[x][y] = pictureArray[x][srcY];
			}
		BufferedImage distorted = Zen.toImage(distortedArray);
		Zen.drawImage(distorted, 0, 0, Zen.getZenWidth(), Zen.getZenHeight());
		Zen.sleep(5); // not too fast
	}

	/**
	 * Calculates the next time step. New values of the boundary are not
	 * calculated.
	 * 
	 * @param z
	 *            displacement array
	 * @param vel
	 *            velocity array
	 */
	private static void simulationStep(float[][] z, float[][] vel) {
		for (int x = 1; x < w - 1; x++) {
			for (int y = 1; y < h - 1; y++) {
				float springImpulseForce = -4 * z[x][y] + (z[x - 1][y] + z[x + 1][y] + z[x][y - 1] + z[x][y + 1]);
				vel[x][y] += springImpulseForce / MASS - DAMP_FACTOR * vel[x][y];
			}
		}
		for (int x = 1; x < w - 1; x++) {
			for (int y = 1; y < h - 1; y++)
				z[x][y] += vel[x][y] - DAMP_FACTOR * z[x][y];
		}
		for (int x = 1; x < w - 1; x++)
			z[x][0] = z[x][h - 1] = 0;
		for (int y = 0; y < h; y++)
			z[0][y] = z[w - 1][y] = 0; // set boundary cells to zero
}	}
