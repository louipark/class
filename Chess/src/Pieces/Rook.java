package Pieces;
import java.util.ArrayList;

public class Rook extends Piece {
		
	public void updateMoves(Piece [][] spaces, int row, int colum) {
		moves = new ArrayList<Space>();
	
		for (int r = row+1; r < spaces.length; r++) {
			if (addMove(spaces[r][colum],r,colum)) 
				break;
		} // right
		
		for (int r = row-1; r >= 0; r--) {
			if (addMove(spaces[r][colum],r,colum)) 
				break;
		} // left
		
		for (int f = colum-1; f >= 0; f--) {
			if (addMove(spaces[row][f],row,f)) 
				break;
		} // up
		
		for (int f = colum+1; f < spaces[0].length; f++) {
			if (addMove(spaces[row][f],row,f)) 
				break;
		} // down
		

	}

}
