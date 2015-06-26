package Pieces;

import java.util.ArrayList;

public class Spec1 extends Piece {

	public void updateMoves(Piece[][] spaces, int rank, int file) {
		moves = new ArrayList<Space>();
		
		Piece knight = new Knight();
		knight.updateMoves(spaces,rank,file);
		
		Piece bishop = new Bishop();
		bishop.updateMoves(spaces,rank,file);
		
		for (int it = 0; it < knight.moves.size(); it++) {
			moves.add(knight.moves.get(it));
			}
		
		for (int it = 0; it < bishop.moves.size(); it++) {
			moves.add(bishop.moves.get(it));
			}
	}

}
