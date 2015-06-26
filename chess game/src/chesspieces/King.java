package chesspieces;
import java.util.ArrayList;

public class King extends pieces {
	public void updateMoves(pieces[][] spaces, int r, int c) {
		availble_checks = new ArrayList<check>();
		
		pieces queen = new Queen();
		queen.set_color(color);
		queen.updateMoves(spaces,r,c);
		
		int rankdiff, filediff;
		check curSpace;
		
		for (int it = 0; it < queen.availble_checks.size(); it++) {
			curSpace = queen.availble_checks.get(it);
			filediff = Math.abs(curSpace.get_colum() - c);
			rankdiff = Math.abs(curSpace.get_row() - r);
			
			if (filediff == 1 || rankdiff == 1)
				availble_checks.add(curSpace);
		}
	}
}
