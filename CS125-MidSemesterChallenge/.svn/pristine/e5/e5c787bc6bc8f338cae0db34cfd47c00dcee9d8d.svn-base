//UIUC CS125 FALL 2012 MP. File: ZenExample6ReactionTimer.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000

public class ZenExample6ReactionTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 100;
		int y = 300;
		int width = 50;
		int height = 50;
		while(true) {
			
			Zen.setColor(255,255,255);
			Zen.fillRect(x, y, width, height);
			long startTime = System.currentTimeMillis();
			
			boolean found = false;
			while(found == false) {
				int mx = Zen.getMouseX();
				int my = Zen.getMouseY();
				if(mx >= x && mx< x+width && my >= y && my <= y + height)
					found = true;
			}
			long stopTime = System.currentTimeMillis();
			long duration = stopTime - startTime;
			Zen.setColor(0,0,0); // black
			Zen.fillRect(0,0,640,480);
			Zen.setColor(255,0,0); // red
			Zen.drawText("Time:"+duration,100,200);
			Zen.sleep(1000);
			
			int oldX = x;
			x= 400 - y;
			y = oldX;
		}
	}

}
