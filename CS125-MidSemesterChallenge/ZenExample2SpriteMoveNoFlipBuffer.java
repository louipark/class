//UIUC CS125 FALL 2012 MP. File: ZenExample2SpriteMoveNoFlipBuffer.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000
public class ZenExample2SpriteMoveNoFlipBuffer {

	/**
	 * Drawing directly to the screen is easy - just don't call flipBuffer !
	 */
	public static void main(String[] args) {
		// Without using flipBuffer changes appear on screen immediately
		// However, this also means that each image will also stay on the
		// screen after it is drawn
		int x = 100;
		while (true) {
			Zen.drawImage("sprite1.gif", x, 200);
			Zen.sleep(50);
			x = x + 5;
		}
	}
}
