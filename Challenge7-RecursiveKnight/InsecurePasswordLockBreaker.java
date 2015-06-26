//UIUC CS125 FALL 2012 MP. File: InsecurePasswordLockBreaker.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2012-11-09T13:47:46-0600.831004000
public class InsecurePasswordLockBreaker {

	public static char[] breakLock(InsecurePasswordLock lock) {
		char[] key = new char[1];
		// write code here to determine the secret password
		// to unlock the given lock object.
		// Hint: Read the source code of InsecurePasswordLock
		// The lock has a weakness....
		// Understand it and you can write an algorith to quickly find the
		// secret password
		// (A brute force guess of a 40 character password would take a long
		// time...
		// as there are 26^40 combinations
		// Your method should find it in a few seconds.

		// Beginner: You should complete this code in less than an hour

		// Advanced: Can you complete this method in 8 lines
		// (excluding the top and bottom given
		// lines and after autoformating your code)
		
		// Crazy: I can write a complete albeit-inefficient solution using single while loop
		// expression: while (____){/*NoCodeHere*/}
		return key;
	}

	public static void main(String[] args) {
		InsecurePasswordLock lock = new InsecurePasswordLock();
		char[] key = breakLock(lock);
		System.out.println(key);
		System.out.println(lock.isUnlocked());
	}
}