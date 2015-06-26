package chesspieces;
import java.awt.Color;
import java.util.ArrayList;


public class pieces {
	public Color color = null;
	public ArrayList <check> availble_checks;
	
	public Color get_color(){
		return color;
	}
	
	public void set_color(Color player){
		color = player;
	}
	
	public boolean same_color(pieces target){
		if (target == null) return false;
		else if (color == target.color) return true;
		return false;
	}
	
	
	
	public boolean isValidMove(check target){
		
		if (availble_checks == null) return false;
		
		for (int i = 0; i < availble_checks.size(); i++ ){
			if(availble_checks.get(i).equals(target))
				return true;
		}
		return false;
	}
	
	public boolean addcheck(int r, int f,pieces curcheck){
		if (curcheck == null) {
			availble_checks.add(new check(r,f));
			return true;
		}
		
		else if (same_color(curcheck)) return false;
		
		else {
			availble_checks.add(new check(r,f));
			return true;
		}
	}
	
	
	public static pieces stringToPiece(String name, Color player) {
		pieces retVal = null;
		
		switch (name){
		
		case "Pawn":
			retVal = new Pawn();
			break;
		case "Knight":
			retVal = new Knight();
			break;
		case "Queen":
			retVal = new Queen();
			break;
		case "King":
			retVal = new King();
			break;
		case "Bishop":
			retVal = new Bishop();
			break;
		case "Rook":
			retVal = new Rook();
			break;
		default:
			return null;
		
		}
		
		retVal.set_color(player);
		return retVal;
	}

	public void updateMoves(pieces[][] spaces, int r, int c) {
		
	}
	
}


