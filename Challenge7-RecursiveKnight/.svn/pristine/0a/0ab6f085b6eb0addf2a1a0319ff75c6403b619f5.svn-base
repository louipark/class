//UIUC CS125 FALL 2012 MP. File: BinarySearch.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2012-11-09T13:47:46-0600.831004000
/**
 * 
 * @author lzhou8
 */
public class BinarySearch {
	/** Wrapper method. Just runs the recursive search method below for the entire array*/
	public static boolean search(int[] array, int key) {
		return search(array, key, 0, array.length - 1);
	}

	/**
	 * Recursive search using Divide and Conquer approach:
	 * The given array is already sorted so we can very quickly discover if the key is in the array or not.
	 * Hint: For the recursive case check the value at (lo+hi)/2
	 * and proceed accordingly.
	 */
	static boolean search(int[] array, int key, int lo, int hi) {
		if (lo>hi)return false;
		int mid=(lo+hi)/2;
		int p=array[mid];
		if (p==key) return true;
		else if (p<key) return search(array,key,mid+1,hi);
		else  return search(array,key,lo,mid-1);
		
	
	}
}
