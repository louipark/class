
public class fact {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		factt(3);
	}
	
public static int factt(int n){
  if	(n==1) return 1;
  else {
	 return n* factt(n-1);
  }
}

}
