//UIUC CS125 FALL 2012 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2012-09-22T01:39:04-0500.114506000
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author lzhou8
 */
public class CipherBreaker {

	public static void main(String[] args) {
		TextIO.putln("Text?");
		String line = TextIO.getln();
		String str[]={line.toUpperCase()};
		TextIO.putln(line);
		
		int space=0;
		int digit=0;
		int pun=0;
		int[] letterCount = new int[26];
		for (int count = 0; count < str.length; count++) {
			String current = str[count];
			char[] letters = current.toCharArray();
			for (int count2 = 0; count2 < letters.length; count2++) { 
				char lett = letters[count2]; 
				if ( (lett >= 'A') & (lett <= 'Z') ) {
				letterCount[lett - 'A']++;}}}
		
				for (char count = 'A'; count <= 'Z'; count++) {
				if(letterCount[count - 'A']!=0){
				System.out.println(count + ":" +
				letterCount[count - 'A'] );}
				}
				
		
		
		for (int i=0; i<line.length();i++){
			char c =line.charAt(i);
			
			if (c==' ')
			space=space+1;
			
			else if (c>='0'&&c<='9')
				digit=digit+1;
		    
			else if (c=='\''||c=='"'||c=='!'||c=='.'||c==','||c=='-') pun=pun+1;
			}
		if (digit>0)
		TextIO.putln("DIGITS:"+digit);
		if(space>0)
		TextIO.putln("SPACES:"+space);
		if(pun>0)
		TextIO.putln("PUNCTUATION:"+pun);}	}
