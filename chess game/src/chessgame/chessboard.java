package chessgame;
import java.awt.Color;

import chesspieces.check;
import chesspieces.pieces;




public class chessboard {
	public pieces [][] checks;
	public condition_check condition;

	public chessboard() {
		checks = new pieces[8][8];
	}
	
	public chessboard(chessboard other){
		if (other == null){
			checks = null;
			return;
		}
		
		checks = new pieces[other.checks.length][other.checks[0].length];
		
		for (int r=0;r<checks.length;r++){
			for (int c=0;c<other.checks[0].length;c++)
			checks[r][c] = other.checks[r][c];
		}
	}
	
	public pieces getpiece(int c, int r){
		return checks[r][c];
	}

	public boolean setpiece(String piece,int r, int c, Color player){
		if (condition.outboard(checks,r,c)) return false;
		if (checks[r][c]!=null) return false;
		
		checks[r][c]=pieces.stringToPiece(piece,player);
				
		return true;
	}
	
	
	public boolean movechess(int rOri, int cOri,int rNew, int cNew){
		if(condition.outboard(checks,rOri,cOri)) return false;
		if (checks[rOri][cOri]==null) return false;
		if (checks[rOri][cOri].same_color(checks[rNew][cNew])) return false;
		
		check des = new check(rNew,cNew);
		
		if (checks[rOri][cOri].isValidMove(des)){
			chessboard colon = new chessboard(this);
			checks[rNew][cNew]=checks[rOri][cOri];
			checks[rOri][cOri] = null;
			updateboard();
			
			if (condition.incheck((checks[rNew][cNew]).get_color())){
				checks = colon.checks;
				return false;
			}
			
			return false;
		}
		else return false;
	}
	
	
	public void updateboard(){
		for (int r =0; r<checks.length;r++){
			for (int c = 0; c<checks[0].length;c++){
				if (checks[r][c]!=null)
					checks[r][c].updateMoves(checks,r,c);
			}
		}
	}

	


	
	
	
	
	
}

