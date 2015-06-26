package chesspieces;
import java.awt.Color;
import java.util.ArrayList;

public class Pawn extends pieces{

	boolean firstMove = true;

	public void updateMoves(pieces[][] spaces, int row, int colum) {
		availble_checks = new ArrayList<check>();
		
		if (color == Color.BLACK) {
			if (firstMove) {
				firstMove = false;
				if (!outboard(spaces,row,colum+2))
					addcheck(colum+2,row,spaces[row][colum+2]);
			}
			if (!outboard(spaces,row+1,colum+1)) 
				if (spaces[row+1][colum+1] != null)
					addcheck(colum+1,row+1,spaces[row+1][colum+1]);
			if (!outboard(spaces,row-1,colum+1))
				if (spaces[row-1][colum+1] != null)
					addcheck(colum+1,row-1,spaces[row-1][colum+1]);
			if (!outboard(spaces,row,colum+1))
				addcheck(colum+1,row,spaces[row][colum+1]);
		}
		else {
			if (firstMove) {
				firstMove = false;
				if (!outboard(spaces,row,colum-2))
					addcheck(colum-2,row,spaces[row][colum-2]);
			}
			if (!outboard(spaces,row+1,colum-1))
				if (spaces[row+1][colum-1] != null)
					addcheck(colum-1,row+1,spaces[row+1][colum-1]);
			if (!outboard(spaces,row-1,colum-1))
				if (spaces[row-1][colum-1] != null)
					addcheck(colum-1,row-1,spaces[row-1][colum-1]);
			if (!outboard(spaces,row,colum-1)) 
				addcheck(colum-1,row,spaces[row][colum+1]);
		}
	}

	public boolean outboard(pieces[][] checks, int r, int c) {
		if ((r < 0) || (c < 0) || (r > checks.length) || (c > checks[0].length))
			return true;
		return false;
	}
	
}
