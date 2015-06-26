package chessgame;
import java.awt.Color;
import java.util.ArrayList;

import chesspieces.King;
import chesspieces.check;
import chesspieces.pieces;


public class condition_check {
	
	public pieces [][] checks;
	public chessboard board;
	
	
	
	public boolean outboard(pieces [][] checks, int r, int c){
		if ((r<0)||(c<0)||(r>checks.length)||(c>checks[0].length))
			return true;
		return false;
	}
	
	
	public boolean incheck(Color player){
		check king = null;
		for (int r =0; r<checks.length;r++){
			for (int c = 0; c<checks[0].length;c++){
				if(checks[r][c] instanceof King)
					if (checks[r][c].get_color()==player)
						king = new check(r,c);
			}
		}
		if(king == null) return false;
		
		ArrayList<check> chessMoves;
		for (int r =0; r<checks.length;r++){
			for (int c = 0; c<checks[0].length;c++){
				if (checks[r][c]!=null){
					chessMoves = checks[r][c].availble_checks;
					for (int i = 0; i<chessMoves.size();i++){
						if (chessMoves.get(i).equals(king))
							return true;
					}
				}				
			}				
		}
		
		return false;
	}
	
	
	
	public boolean inCheckmate(Color player){
		if (incheck(player)){
			chessboard colon;
			ArrayList<check> chessMoves;
			for (int r =0; r<checks.length;r++){
				for (int c = 0; c<checks[0].length;c++){
					if(checks[r][c]!=null&&checks[r][c].get_color() == player){
						chessMoves = checks[r][c].availble_checks;
						for (int i=0;i<chessMoves.size();i++){
							colon = new chessboard(board);
							int row = chessMoves.get(i).get_row();
							int colum = chessMoves.get(i).get_colum();
							if (board.movechess(r,c,row,colum))
								if(!incheck(player))
									return false;
							checks = colon.checks;
						}
					}					
				}
			}
			
			return true;
		}
		else 
			return false;
	}
	
	
	public boolean instalemate(Color player){
		if (incheck(player)){
			check king = null;
			for (int r =0; r<checks.length;r++){
				for (int c = 0; c<checks[0].length;c++){
			if (checks[r][c] instanceof King)
				if (checks[r][c].get_color()==player)
					king =new check(r,c);
				}
			}	
		
			ArrayList<check> chessMoves = checks[king.get_row()][king.get_colum()].availble_checks;
			chessboard colon;
			
			if (chessMoves == null || chessMoves.isEmpty()) return true;
			
			for (int i =0; i<chessMoves.size();i++){
				colon = new chessboard(board);
				int row = chessMoves.get(i).get_row();
				int colum = chessMoves.get(i).get_colum();
				if (board.movechess(king.get_row(),king.get_colum(),row,colum))
					if (!incheck(checks[row][colum].color))
						return false;
				checks = colon.checks;	
			}
			return true;
		}
		return false;
	}
	
	
	
	

}
