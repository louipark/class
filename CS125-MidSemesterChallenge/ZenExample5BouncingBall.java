//UIUC CS125 FALL 2012 MP. File: ZenExample5BouncingBall.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000
public class ZenExample5BouncingBall {
	/**
	 * Simulates bouncing a ball.
	 */
	public static void main(String[] args) {
		double x = 0;
		double y = 0;
		double velocityX = 1;
		double velocityY = 0;

		while (Zen.isRunning()) {
			Zen.fillOval((int) x, (int) y, 4, 4);
			Zen.sleep(20);
			velocityY = velocityY + 1;
			if (y + velocityY > 400)
				velocityY = -Math.abs(0.9 * velocityY);
			x = x + velocityX;
			y = y + velocityY;
		}
	}

}
