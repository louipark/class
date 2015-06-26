//UIUC CS125 FALL 2012 MP. File: FindScriptLine.java, CS125 Project: Challenge2-Hollywood, Version: 2012-09-14T17:11:15-0500.186579000
/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author lzhou8
 */
public class FindScriptLine {

	public static void main(String[] args) {
		
		boolean output=false;
		
		TextIO.putln("Please enter the word(s) to search for");
		
		String SearchingFor = TextIO.getln();
		
		TextIO.putln("Searching for "+"\'"+SearchingFor+"\'");
		
		TextIO.readFile("thematrix.txt");
		
		output = false;
		int count=0;
		while (false == TextIO.eof()) {
			String line = TextIO.getln();

			
			if (line.length()>=0)
				count=count+1;

			if (line.toLowerCase().indexOf(SearchingFor.toLowerCase()) >= 0){
				output = true;

			
			if (line.length()==0)
				output = false;
			
			line = line.trim();
			
			line=count+" - "+line;
			
			if (output)
				TextIO.putln(line);}

// TODO: Implement the functionality described in FindScriptLine.txt
// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest		
		}
		TextIO.putln("Done Searching for "+"\'"+SearchingFor+"\'");}
}
