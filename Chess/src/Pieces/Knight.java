package Pieces;
import java.util.ArrayList;


public class Knight extends Piece {

	public void updateMoves(Piece[][] spaces, int row, int colum) {
		moves = new ArrayList<Space>();
		
			int r1 = row + 2;
			int f1 = colum + 1;			
			if (!outOfBounds(spaces,r1,f1))
				addMove(spaces[r1][f1],r1,f1);
			
			int r2 = row + 2;
			int f2 = colum - 1;			
			if (!outOfBounds(spaces,r2,f2))
				addMove(spaces[r2][f2],r2,f2);
			
			int r3 = row - 2;
			int f3 = colum + 1;			
			if (!outOfBounds(spaces,r3,f3))
				addMove(spaces[r3][f3],r3,f3);
			
			int r4 = row - 2;
			int f4 = colum - 1;			
			if (!outOfBounds(spaces,r4,f4))
				addMove(spaces[r4][f4],r4,f4);
			
			int r5 = row + 1;
			int f5 = colum + 2;			
			if (!outOfBounds(spaces,r5,f5))
				addMove(spaces[r5][f5],r5,f5);
			
			int r6 = row + 1;
			int f6 = colum - 2;			
			if (!outOfBounds(spaces,r6,f6))
				addMove(spaces[r6][f6],r6,f6);
			
			int r7 = row - 1;
			int f7 = colum - 2;			
			if (!outOfBounds(spaces,r7,f7))
				addMove(spaces[r7][f7],r7,f7);
			
			int r8 = row - 1;
			int f8 = colum + 2;			
			if (!outOfBounds(spaces,r8,f8))
				addMove(spaces[r8][f8],r8,f8);

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
