//UIUC CS125 FALL 2012 MP. File: RGBUtilities.java, CS125 Project: Challenge4-Photoscoop, Version: 2012-10-03T12:48:54-0500.923498000
/* Manipulates RGB values
 * 
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author lzhou8
 */

public class RGBUtilities {

/**
 * Extracts the red component (0..255)
 * Hint: see ch12.1.2 Working With Pixels 
 * http://math.hws.edu/javanotes/c12/s1.html#GUI2.1.2
 * 
 * ... also see the notes in READ-ME-FIRST
 * 
 * @param rgb the encoded color int
 * @return the red component (0..255)
 */
	public static int toRed(int rgb) {
		int r;
		r = rgb >>16 & 0xFF;
		return r; // FIX ME
	}

	public static int toGreen(int rgb) {
		int g;
		g=rgb >>8 & 0xFF;
		return g; // FIX THIS
	}

	public static int toBlue(int rgb) {
		int b;
		b=rgb >>0 & 0xFF;
		return b; // FIX THIS
	}

	/**
	 * 
	 * @param r the red component (0..255)
	 * @param g the green component (0..255)
	 * @param b the blue component (0..255)
	 * @return a single integer representation the rgb color (8 bits per component) rrggbb
	 */
	static int toRGB(int r, int g, int b) {
		int rgb;
		r=r<<16;
		g=g<<8;
		rgb=r+g+b;
		return rgb; // FIX THIS
	}

}
