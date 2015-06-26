//UIUC CS125 FALL 2012 MP. File: StaticMethodsAreEasy.java, CS125 Project: Challenge5-DataStructures, Version: 2012-10-12T13:24:10-0500.281837000
public class StaticMethodsAreEasy {


// Oh no... Someone removed  the methods but left the comments!!
// Hint: Get the Geocache class working and passing its tests first.
    /**@author lzhou8
	/**
	 * Returns an array of num geocaches. Each geocache is initialized to a random
	 * (x,y) location.
	 * if num is less than zero, just return an empty array of length 0.
	 * 
	 * @param num
	 *            number of geocaches to create
	 * @return array of newly minted Points
	 */
	public static Geocache[] createGeocaches(int a) {
		if (a<0){ Geocache[] d=new Geocache[0];return d;}
		else{ 
		Geocache[] g=new Geocache[a];
		 for (int i=0; i<a;i++){
	    	 double x=Math.random(),y=Math.random();
	    	 Geocache n = new Geocache(x,y); 
	    	 g[i]=n;
	    	} 
	     return g;}
	     }

	/**
	 * Modifies geocaches if the geocache's X value is less than the allowable minimum
	 * value.
	 * 
	 * @param p
	 *            array of geocaches
	 * @param minX
	 *            minimum X value.
	 * @return number of modified geocaches (i.e. x values were too small).
	 */
	public static void ensureMinimumXValue(Geocache[] pts, double value) {
		for(int i=0;i<pts.length;i++){
			double x=pts[i].getX();
			if (x<value){
				pts[i].setX(value);}
		}
	}
	/**
	 * Counts the number of geocaches that are equal to the given geocache
	 * Hint: Use geocache.equals() method 
	 * @param p -
	 *            geocache array
	 * @param test -
	 *            test geocache (compared using .equal)
	 * @return number of matching geocaches
	 */
	public static Object countEqual(Geocache[] pts, Geocache origin) {
		int n=0;
		for(int i=0;i<pts.length;i++)
			if (pts[i].equals(origin)==true)
				n++;
		return n;
	}
}
