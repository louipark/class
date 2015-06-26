//UIUC CS125 FALL 2012 MP. File: Queue.java, CS125 Project: Challenge5-DataStructures, Version: 2012-10-12T13:24:10-0500.281837000
/**@author lzhou8 */
public class Queue {
	private double[] s=new double [0];
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	public void add(double value) {
		double[] tmp= new double[s.length+1];
		for (int i=0;i<s.length;i++)
			tmp[i+1]=s[i];
		tmp[0]=value;
		s=tmp;
		//throw new RuntimeException("Don't step on the cracks");
	}
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		double[] top= new double[1];
		if (s.length==0)return 0;
		else {	
			double[] tmp= new double[s.length-1];
			for (int i=0;i<s.length-1;i++)
				tmp[i]=s[i];
			top[0]=s[s.length-1];
			s=tmp;
			}
		return top[0];
		//throw new RuntimeException("Grilled Cheese");
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return s.length;
		//throw new RuntimeException("I am not a number; I am free man.");		
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		return s.length==0;
		//throw new RuntimeException("The butler did it");
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		String result="";
			for (int i=s.length;i>1;i--)
				result=result+ s[i-1]+",";
			result=result+s[0];
		return result;
		//throw new RuntimeException("Daisy daisy daisy");
	}
}
