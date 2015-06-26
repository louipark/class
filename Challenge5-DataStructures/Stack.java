//UIUC CS125 FALL 2012 MP. File: Stack.java, CS125 Project: Challenge5-DataStructures, Version: 2012-10-12T13:24:10-0500.281837000
/**@author lzhou8*/

public class Stack {
	
	private String[] s=new String [0];
	
	
	/** Adds a value to the top of the stack.*/
	public void push(String value){
		String[] tmp= new String[s.length+1];
		for (int i=0;i<s.length;i++)
			tmp[i+1]=s[i];
		tmp[0]=value;
		s=tmp;
		//throw new RuntimeException("Elevator stuck. Abort Retry Fail?");
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		String[] top= new String[1];
		if (s.length==0)return null;
		else {
		  String[] tmp= new String[s.length-1];
			for (int i=1;i<s.length;i++)
				tmp[i-1]=s[i];
			top[0]=s[0];
			s=tmp;}
		return top[0];
		//throw new RuntimeException("Ones and Zeros. Mostly.");
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		if (s.length==0)return null;
		else return s[0];
		//throw new RuntimeException("Don't peek. It's too scary");
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		return s.length==0;
		
		//throw new RuntimeException("Need more");
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return s.length;
		//throw new RuntimeException("Must be relative");
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		String result="";
		if (s.length==0)return null;
		else {
			for (int i=s.length;i>0;i--)
				result=result+ s[i-1]+"\n";
		}
		return result;
	//	throw new RuntimeException("Rope is thicker but String is quicker");
	}
}
