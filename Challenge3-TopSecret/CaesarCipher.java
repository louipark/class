//UIUC CS125 FALL 2012 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2012-09-22T01:39:04-0500.114506000
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author lzhou8
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		int shift=TextIO.getlnInt();
			
		
		while ((Math.abs(shift)>25&&Math.abs(shift)!=999)||(Math.abs(shift)<1&&Math.abs(shift)!=999)){
			TextIO.putln(shift+" is not a valid shift value.");
			TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
			shift=TextIO.getlnInt();}
		
		if (Math.abs(shift)==999)
			TextIO.putln("Using position shift");

		else
		TextIO.putln("Using shift value of "+shift);
		TextIO.putln("Please enter the source text (empty line to quit)");
		String source = TextIO.getln();
		String result = "";
		boolean done=false;
		

		while(!done){
		
		  if(source.length()>0){
		  TextIO.putln("Source   :" +source);
		  int shiften=0;
		  for (int i=0;i<source.length();i++){
			char c=source.toUpperCase().charAt(i);
			char encoded=' ';

			if (c>='A'&&c<='Z'){
				if (shift!=Math.abs(999)) encoded=(char)((c-'A'+shift+26)%26+'A');
				else if(shift==Math.abs(999)) 
					if (shift==999) encoded=(char)((c-'A'+shiften+26)%26+'A');
				   // else encoded=(char)((c-'A'-shiften)%26+'A');}
					}
			else encoded=c;
			if (shift==999)shiften=shiften+1;
			//if (shift==-999)shiften=shiften-1;
			result+=encoded; 
			
		  
		  
		  }

		  TextIO.putln("Processed:"+result.toUpperCase());
		  TextIO.putln("Please enter the source text (empty line to quit)");
		  source = TextIO.getln();
		} 
		TextIO.putln("Bye.");
		done=true;}
	
	}}
	

