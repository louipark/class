//UIUC CS125 FALL 2012 MP. File: PixelEffects.java, CS125 Project: Challenge4-Photoscoop, Version: 2012-10-03T12:48:54-0500.923498000

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author lzhou8
 */
public class PixelEffects {

	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source) {
		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				result[i][j] = RGBUtilities.toRGB(red, green, blue);}
		return result; // Fix Me
	}
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		int width = source.length, height = source[0].length;
		int[][] result = new int[newWidth][newHeight];
		for (int i = 0; i < newWidth; i++)
			for (int j = 0; j < newHeight; j++) {
				int srcY=(int)((j/(double)newHeight)*height);
				int srcX=(int)((i/(double)newWidth)*width);
				result[i][j]=source[srcX][srcY];
			}
		return result; // Fix Me
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate)  in the original image.
		// For example if you're setting a pixel halfway across the image, you should be reading half way across the original image too.
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {
		int width = source.length/2, height = source[0].length/2;
		return resize(source,width,height); // Fix Me
	}
	
	/**
	 * Create a new image array that is the same dimesions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference) {
		int width = reference.length, height = reference[0].length;
		return resize(source,width,height); // Fix Me
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source) {
		int width = source.length, height = source[0].length;
		int tgtw=width;
		int tgth=height;
		int[][] result = new int[tgtw][tgth];
		for (int i = 0; i < tgtw; i++)
			for (int j = 0; j < tgth; j++){
				int srcY= tgth-1-j;
				int srcX= i;
				result[i][j]=source[srcX][srcY];
			}
		return result;// Fix Me
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {
		int width = source.length, height = source[0].length;
		int tgtw=width;
		int tgth=height;
		int[][] result = new int[tgtw][tgth];
		for (int i = 0; i < tgtw; i++)
			for (int j = 0; j < tgth; j++){
				int srcY= j;
				int srcX= tgtw-1-i;
				result[i][j]=source[srcX][srcY];
			}
		return result;
		// Fix Me
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {
		int width = source.length, height = source[0].length;
		int tgtw=height;
		int tgth=width;
		int[][] result = new int[tgtw][tgth];
		for (int i = 0; i < tgtw; i++)
			for (int j = 0; j < tgth; j++){
				int srcY= i;
				int srcX= tgth-1-j;
				result[i][j]=source[srcX][srcY];
			} 
		
		return result;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel ofthe background).
		int width = sourceA.length, height = sourceA[0].length;
		int[][] sourceT=resize(sourceB,sourceA);
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgbA = sourceA[i][j];
				int redA = RGBUtilities.toRed(rgbA);
				int greenA = RGBUtilities.toGreen(rgbA);
				int blueA = RGBUtilities.toBlue(rgbA);
				
				int rgbT = sourceT[i][j];
				int redT = RGBUtilities.toRed(rgbT);
				int greenT = RGBUtilities.toGreen(rgbT);
				int blueT = RGBUtilities.toBlue(rgbT);
				
				int redAB=(redA+redT)/2;
				int greenAB=(greenA+greenT)/2;
				int blueAB=(blueA+blueT)/2;
				
				result[i][j]=RGBUtilities.toRGB(redAB, greenAB, blueAB);
			}
		return result;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		int width = backImage.length, height = backImage[0].length;
		int[][] sourceT=resize(foreImage,backImage);
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgbA = backImage[i][j];
				int redA = RGBUtilities.toRed(rgbA);
				int greenA = RGBUtilities.toGreen(rgbA);
				int blueA = RGBUtilities.toBlue(rgbA);
				
				int rgbT = sourceT[i][j];
				int redT = RGBUtilities.toRed(rgbT);
				int greenT = RGBUtilities.toGreen(rgbT);
				int blueT = RGBUtilities.toBlue(rgbT);
                if (greenT > 4*Math.max(redT, blueT) && greenT > 64 ){
                	redT=redA;
                    greenT=greenA;
                    blueT=blueA;}
                result[i][j]=RGBUtilities.toRGB(redT, greenT, blueT);		
			}
		return result;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		int width = source.length, height = source[0].length;
		int tgtw=width;
		int tgth=height;
		int[][] result = new int[tgtw][tgth];
		for (int i = 0; i < tgtw; i++)
			for (int j = 0; j < tgth; j++){
				int srcY= tgth-1-j;
				int srcX= tgtw-1-i;
				result[i][j]=source[srcX][srcY];
			}
		return result;
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
	
	}
}
