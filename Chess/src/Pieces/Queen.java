package Pieces;
import java.util.ArrayList;

public class Queen extends Piece{

	public void updateMoves(Piece[][] spaces, int row, int colum) {
		moves = new ArrayList<Space>();
		
		for (int r = row+1; r < spaces.length; r++) {
			if (addMove(spaces[r][colum],r,colum)) 
				break;
		} // right
		
		for (int r = row-1; r >= 0; r--) {
			if (addMove(spaces[r][colum],r,colum)) 
				break;
		} // left
		
		for (int f = colum+1; f < spaces[0].length; f++) {
			if (addMove(spaces[row][f],row,f)) 
				break;
		} // down
		
		for (int f = colum-1; f >= 0; f--) {
			if (addMove(spaces[row][f],row,f)) 
				break;
		} // up
		
		for (int r = row+1,f = colum+1; r < spaces.length && f < spaces[0].length; r++,f++) {
			if (addMove(spaces[r][f],r,f))
				break;
		}// upper /
		
		for (int r = row-1,f = colum+1; r >= 0 && f < spaces[0].length; r--,f++) {
			if (addMove(spaces[r][f],r,f))
				break;
		}// lower\
		
		for (int r = row+1,f = colum-1; r < spaces.length && f >= 0; r++,f--) {
			if (addMove(spaces[r][f],r,f))
				break;
		}// upper\
		
		for (int r = row-1,f = colum-1; r >= 0 && f >= 0; r--,f--) {
			if (addMove(spaces[r][f],r,f))
				break;
		}// lower/
	}

}
