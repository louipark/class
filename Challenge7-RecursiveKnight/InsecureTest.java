//UIUC CS125 FALL 2012 MP. File: InsecureTest.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2012-11-09T13:47:46-0600.831004000
import junit.framework.TestCase;


public class InsecureTest extends TestCase {
	public void xxxTestCombinationLockBreaker() {
		for(int test = 0; test<10;test++) {
			InsecureCombinationLock lock = new InsecureCombinationLock();
			InsecureCombinationLockBreaker.breakLock(lock);
			assertTrue(lock.isUnlocked());
		}
	}
	public void testPasswordLockBreaker() {
		for(int len = 30; len<=50;len++) {
			InsecurePasswordLock lock = new InsecurePasswordLock(len);
			InsecurePasswordLockBreaker.breakLock(lock);
			assertTrue(lock.isUnlocked());
		}
	}

}
