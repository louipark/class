package chesspieces;
import java.util.ArrayList;



public class Queen extends pieces {
	public void updateMoves(pieces[][] spaces, int r, int c) {
		
		pieces rook = new Rook();
		pieces bishop = new Bishop();
		
		rook.set_color(color);
		bishop.set_color(color);
		
		rook.updateMoves(spaces, r, c);
		bishop.updateMoves(spaces, r, c);
		
		availble_checks = new ArrayList<check>();
		
		for (int it = 0; it < rook.availble_checks.size(); it++) {
			availble_checks.add(rook.availble_checks.get(it));
		}
		
		for (int it = 0; it < bishop.availble_checks.size(); it++) {
			availble_checks.add(bishop.availble_checks.get(it));
		}
	}
}
