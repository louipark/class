//UIUC CS125 FALL 2012 MP. File: ZenExample3ColorOvalsIf.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000
public class ZenExample3ColorOvalsIf {

	/*
	 * Draw some colorful ovals.
	 */
	public static void main(String[] args) {
		long lastClickTime = 0;

		// It's polite to ask Zen when to close down
		while (Zen.isRunning()) {

			long clickTime = Zen.getMouseClickTime();
			int x = Zen.getMouseX();
			int y = Zen.getMouseY();
			if (clickTime != 0) // starts drawing after mouse is clicked
				Zen.fillOval(x - 16, y - 16, 32, 32);
            
			//the code inside of these braces will only be run 
			//if the mouse has been clicked again
			if (clickTime != lastClickTime) { 
				lastClickTime = clickTime;
				Zen.setColor(x, y, x + y); // sets the color based on the
											// current mouse position
			}
		}
	}
}
