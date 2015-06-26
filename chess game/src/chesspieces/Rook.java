package chesspieces;
import java.util.ArrayList;

public class Rook extends pieces{
	public void updateMoves(pieces [][] spaces, int r, int c) {
		availble_checks = new ArrayList<check>();
	
		for (int row = r+1; row < spaces.length; row++) {
			if (addcheck(c,row,spaces[row][c])) 
				break;
		} // right
		
		for (int row = r-1; row >= 0; row--) {
			if (addcheck(c,row,spaces[row][c])) 
				break;
		} // left
		
		for (int colum = c+1; colum < spaces[0].length;colum++) {
			if (addcheck(colum,r,spaces[r][colum])) 
				break;
		} // down
		
		for (int colum = c-1; colum >= 0; colum--) {
			if (addcheck(colum,r,spaces[r][colum])) 
				break;
		} // up
	}
}
