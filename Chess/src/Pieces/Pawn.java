package Pieces;
import java.awt.Color;
import java.util.ArrayList;

public class Pawn extends Piece {
	boolean firstMove = true;

	public void updateMoves(Piece[][] spaces, int row, int colum) {
		moves = new ArrayList<Space>();
		
		if (color == Color.WHITE) {
			if (firstMove) {
				firstMove = false;
				if (!outOfBounds(spaces,row,colum-2))
					addMove(spaces[row][colum-2],row,colum-2);
			}
			if (!outOfBounds(spaces,row+1,colum-1))
				if (spaces[row+1][colum-1] != null)
					addMove(spaces[row+1][colum-1],row+1,colum-1);
			if (!outOfBounds(spaces,row-1,colum-1))
				if (spaces[row-1][colum-1] != null)
					addMove(spaces[row-1][colum-1],row-1,colum-1);
			if (!outOfBounds(spaces,row,colum-1)) 
				addMove(spaces[row][colum+1],row,colum-1);
			
		}
		else {
			if (firstMove) {
				firstMove = false;
				if (!outOfBounds(spaces,row,colum+2))
					addMove(spaces[row][colum+2],row,colum+2);
			}
			if (!outOfBounds(spaces,row+1,colum+1)) 
				if (spaces[row+1][colum+1] != null)
					addMove(spaces[row+1][colum+1],row+1,colum+1);
			if (!outOfBounds(spaces,row-1,colum+1))
				if (spaces[row-1][colum+1] != null)
					addMove(spaces[row-1][colum+1],row-1,colum+1);
			if (!outOfBounds(spaces,row,colum+1))
				addMove(spaces[row][colum+1],row,colum+1);
			
		}
	}
	
	/**
	 * @param spaces
	 * @param row
	 * @param colum
	 * @return
	 */
	protected boolean outOfBounds(Piece [][] spaces, int row, int colum) {
		return (row < 0) || (colum < 0) || (row >= spaces.length) || (colum >= spaces[0].length);
	}

}
