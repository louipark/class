//UIUC CS125 FALL 2012 MP. File: MolecularSort.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2012-11-09T13:47:46-0600.831004000
/**
 * 
 * @author lzhou8
 */
public class MolecularSort {

	/** Sorts each xyz coordinate using it's Z value (coord[i][2] <= coord[j][2] for i<j). */
	static void sortCoordsByZ(double[][] coords) {
		recursiveSort( coords, 0, coords.length-1); 
		// TODO: Implement this wrapper method.
		//All the work is performed by recursiveSort
	}

	/**
	 * recursively sorts coordinates entries by their z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static void recursiveSort(double[][] coords, int lo, int hi) {
        if (lo < hi && coords[hi][2] <= coords[lo][2]) {
            swap(coords, lo, hi);
            recursiveSort(coords, lo + 1, hi);}
            // TODO: write the four lines of a recursive selection sort here.
	}

	/**
	 * returns the index of the entry with the lowest Z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static int findIndexOfZMinimum(double[][] coords, int lo, int hi) {
        int index = 1;
        if(lo==hi) return lo;
        if(coords[lo][2]>coords[lo+1][2]) index = lo + 1;
        else  index = lo;
        index = findIndexOfZMinimum(coords,lo+1,hi);
        return index; // TODO: Replace this with your three lines of recursive code
	}
	

	/* Swaps the (x,y and z) values of the i-th and j-th coordinates.*/
	static void swap(double[][] coords, int i, int j) {
		double[] tmp=coords[i];
		coords[i]=coords[j];
		coords[j]=tmp;
	}
}