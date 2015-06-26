package Pieces;
import java.util.ArrayList;

public class Bishop extends Piece {


	public void updateMoves(Piece[][] spaces, int row, int colum) {
		moves = new ArrayList<Space>();
		
		for (int r = row+1,f = colum+1; r < spaces.length && f < spaces[0].length; r++,f++) {
			if (addMove(spaces[r][f],r,f))
				break;
		}
		
		for (int r = row-1,f = colum+1; r >= 0 && f < spaces[0].length; r--,f++) {
			if (addMove(spaces[r][f],r,f))
				break;
		}
		
		for (int r = row-1,f = colum-1; r >= 0 && f >= 0; r--,f--) {
			if (addMove(spaces[r][f],r,f))
				break;
		}
		
		for (int r = row+1,f = colum-1; r < spaces.length && f >= 0; r++,f--) {
			if (addMove(spaces[r][f],r,f))
				break;
		}
		

	}
}
