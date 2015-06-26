package chesspieces;
import java.util.ArrayList;

public class Bishop extends pieces {
	public void updateMoves(pieces[][] spaces, int row, int colum) {
		availble_checks = new ArrayList<check>();
		
		for (int r = row+1,c = colum+1; r < spaces.length && c < spaces[0].length; r++,c++) {
			if (addcheck(c,r,spaces[r][c]))
				break;
		}
		
		for (int r = row-1,c = colum+1; r >= 0 && c < spaces[0].length; r--,c++) {
			if (addcheck(c,r,spaces[r][c]))
				break;
		}
		
		for (int r = row+1,c = colum-1; r < spaces.length && c >= 0; r++,c--) {
			if (addcheck(c,r,spaces[r][c]))
				break;
		}
		
		for (int r = row-1,c = colum-1; r >= 0 && c >= 0; r--,c--) {
			if (addcheck(r,c,spaces[r][c]))
				break;
		}
	}
}
