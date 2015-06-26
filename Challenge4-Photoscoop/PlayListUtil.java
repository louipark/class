//UIUC CS125 FALL 2012 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2012-10-03T12:48:54-0500.923498000
/**
 * lzhou8
 * @author angrave
 *
 */
public class PlayListUtil {

	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should work.
	 * Hint: Fix the formatting (shift-cmd-F) to help debug the following code
	 * @param list
	 * @param maximum
	 */
	public static void list(String[] list, int maximum) {
		int i;
		for ( i = 0; i<list.length; i++)
			
        if (i<maximum) TextIO.putln(   ""  + (i +1)+ ". " + list[i]); 
        else if (maximum==-1) TextIO.putln(   ""  + (i +1)+ ". " + list[i]); 
	}

	/**
	 * Appends or prepends the title
	 * @param list
	 * @param title
	 * @param prepend if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {
		
		if (prepend){ String[] newlist={title,list[0],list[1],list[2]}; list=newlist;}
		else { String[] newlist={list[0],list[1],list[2],title};list=newlist;}
		return list;
	}
	/**
	 * Returns a new list with the element at index removed.
	 * @param list the original list
	 * @param index the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		String[] newlist= new String[list.length - 1];
	    System.arraycopy(list, 0, newlist, 0, index );
	    System.arraycopy(list, index+1, newlist, index, list.length - index-1);
	    
		return newlist;
	}

}
