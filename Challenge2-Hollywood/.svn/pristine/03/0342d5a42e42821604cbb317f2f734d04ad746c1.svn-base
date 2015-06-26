//UIUC CS125 FALL 2012 MP. File: MyScriptPrinter.java, CS125 Project: Challenge2-Hollywood, Version: 2012-09-14T17:11:15-0500.186579000
/**
 * A program to print one actor's lines. 
 * See ScriptPrinter.txt for more information.
 * TODO: add your netid to the line below
 * @author lzhou8
 */
public class MyScriptPrinter {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean output=false; //Set to true when we find the desired character
		String name=""; // Only print lines for this character
		
		TextIO.putln("Which character's lines would you like? (NEO,MORPHEUS,ORACLE)");
		name = TextIO.getln();

		TextIO.readFile("thematrix.txt"); // stop reading from the keyboard- use the script
        
		name=name.toUpperCase();
		TextIO.putln(name+"\'s lines:");// Print the name here (see ScriptPrinter.txt example output for format)
		
		output = false; // initially don't print anything

		// This loop will read one line at a time from the script until it
		// reaches the end of the file and then TextIO.eof() will return true.
		// eof means end-of-file
		while (false == TextIO.eof()) {
			String line = TextIO.getln(); // Read the next line
			
			if (line.indexOf(name) >= 0)
				output = true; // We found the character's name, time to start printing their lines
			


			if (line.length()==0)
				output = false;// If it's a blank line set 'output' to false


			int posn = line.indexOf(name);
			if(posn!=-1)
				line=line.substring(posn+name.length(),line.length());
			line = line.trim();	
			if (line.length()>0){
				line= name+":"+"\""+line+"\"";// Correct the output format (see ScriptPrinter.txt example output)
	              if (output)
					TextIO.putln(line); }// Only print the line if 'output' is true

		}
		TextIO.putln("---");// Print 3 dashes here to indicate processing is complete
	}

}
