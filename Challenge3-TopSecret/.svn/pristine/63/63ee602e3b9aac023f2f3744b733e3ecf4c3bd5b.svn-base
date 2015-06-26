//UIUC CS125 FALL 2012 MP. File: ExampleNestedLoops.java, CS125 Project: Challenge3-TopSecret, Version: 2012-09-22T01:39:04-0500.114506000
/**
 * Example of using nested loops to print a multiplication table
 * This program is not graded.
 * @author angrave
 * 
 */
public class ExampleNestedLoops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i, j;
		for (i = 1; i <= 10; i++) {
			TextIO.put("| ");
			for (j = 1; j <= 10; j++) {
				// One way to convert an integer to a string:
				String s = Integer.toString(i * j);
				// 
				for (int pad = 3 - s.length(); pad > 0; pad--) {
					TextIO.put(' ');
				}

				TextIO.put(s);
				TextIO.put(" | ");
			}
			TextIO.putln();
		}
	}

}
