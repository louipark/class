package Pieces;
import java.util.ArrayList;



public class King extends Piece {

	public void updateMoves(Piece[][] spaces, int row, int column) {
		moves = new ArrayList<Space>();
		
		Piece queen = new Queen();
		queen.setColor(color);
		queen.updateMoves(spaces,row,column);
				
		Space curSpace;
		
		for (int it = 0; it < queen.moves.size(); it++) {
			curSpace =queen.moves.get(it);
			
			if (Math.abs(curSpace.getcolum() - column) == 1 || Math.abs(curSpace.getrow() - row) == 1)
				moves.add(curSpace);
		}
		
	}
	
}
