//UIUC CS125 FALL 2012 MP. File: ZenExample2SpriteMoveFlipBuffer.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000
public class ZenExample2SpriteMoveFlipBuffer {

	/**
	 * Drawing a sprite using a two buffers. When the scene is ready to be
	 * displayed, call 'flipBuffer' to present the new image to the user.
	 * 
	 **/
	public static void main(String[] args) {
        // This is a more advanced example.
		//
		// With flipBuffer: Changes are written to a secret background buffer
		// first
		// When flipBuffer is called, the background buffer and the foreground
		// buffer are swapped.

		// When flipBuffer is called one (or more times)
		// Zen stops painting immediately to the screen and instead uses a
		// behind-the-scenes buffer
		// to assemble the next complete image to display.
		int x = 100;
		while (true) { // this loop will run repeatedly until the program is
						// exited
			Zen.drawImage("sprite1.gif", x, 200);

			Zen.flipBuffer();
			Zen.sleep(50); // 50 milliseconds (1/20th second)
			x = x + 5; // changes the x-coordinate of where the image will be
						// drawn next
		} // while
	} // main
}
