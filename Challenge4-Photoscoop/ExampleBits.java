//UIUC CS125 FALL 2012 MP. File: ExampleBits.java, CS125 Project: Challenge4-Photoscoop, Version: 2012-10-03T12:48:54-0500.923498000

public class ExampleBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<16;i++) {
			TextIO.putln(i+ " "+Integer.toHexString(i)+ " : "+Integer.toBinaryString(i));
		}
	}
}
