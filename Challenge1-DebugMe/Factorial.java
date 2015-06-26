//UIUC CS125 FALL 2012 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2012-09-07T19:52:51-0500.589872000

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author lzhou8
 */
public class Factorial {
	public static void main(String[] args) {
		boolean done = false;
		long max = 0;
		TextIO.putln("Enter a number between 1 and 20 inclusive.");
		max = TextIO.getlnInt();
		while (!done) {
			while (max < 1 || max >= 21){
				TextIO.putln("Enter a number between 1 and 20 inclusive.");
			    max = TextIO.getlnInt();
			    done = true;}
			long x,fact =1;
			for(x=1;x<=max; x++)
				fact*=x;
		    if(max >= 1 && max < 21)
		    	TextIO.putln(max +"! = "+fact);
		     done = true;}

	

	}
}
