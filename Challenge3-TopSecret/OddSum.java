//UIUC CS125 FALL 2012 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2012-09-22T01:39:04-0500.114506000
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author lzhou8
 */
public class OddSum { 
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args) { 
	 int num = TextIO.getlnInt();
	 int sum=0;
	 TextIO.putln("Max?");
	 for (int n=1;n<=num;n=n+2){
		 sum=sum+n;	 		 
		 TextIO.put(n);
		 if (n<=num-2){
			 TextIO.put(" + ");}}
	 TextIO.putln(" = "+sum );
	 
	 TextIO.put(sum+" = ");	 
	 if (num%2==0){
	 for (int n=num-1;n>0;n=n-2){
		 sum=sum+n;	 		 
		 TextIO.put(n);
		 if (n<=num-1 && n>1){
			 TextIO.put(" + ");}}}
	 else if (num%2!=0){
		 for (int n=num;n>0;n=n-2){
			 sum=sum+n;	 		 
			 TextIO.put(n);
			 if (n<=num && n>1){
				 TextIO.put(" + ");}}
 }
	 
 } // end of main method
} // end of class 
