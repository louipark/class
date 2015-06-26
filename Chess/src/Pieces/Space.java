package Pieces;

public class Space {
	int row;
	int colum;
	

	public Space(int r, int c) {
		row = r;
		colum = c;
	}
	

	public int getrow() {
		return row;
	}
	
	/**
	 * @return
	 */
	public int getcolum() {
		return colum;
	}
	
	/**
	 * @param other
	 * @return
	 */
	public boolean equals(Space other) {
		return (row == other.row) && (colum == other.colum);
	}
}
