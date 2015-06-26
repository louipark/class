package chesspieces;
import java.util.ArrayList;

public class Knight extends pieces{
	private static final int [][] L_MOVES = {{ 2, 1},{ 2,-1},
		 {-2, 1},{-2,-1},
		 {-1, 2},{-1,-2},
		 { 1, 2},{ 1,-2}};


	public void updateMoves(pieces[][] spaces, int row, int colum) {
		availble_checks = new ArrayList<check>();

		for (int r, c, it = 0; it < L_MOVES.length; it++) {
			r = row + L_MOVES[it][0];
			c = colum + L_MOVES[it][1];

			if (!outboard(spaces, r, c))
				if (addcheck(c, r, spaces[r][c]))
					break;
		}
	}

	public boolean outboard(pieces[][] checks, int r, int c) {
		if ((r < 0) || (c < 0) || (r > checks.length) || (c > checks[0].length))
			return true;
		return false;
	}

}
