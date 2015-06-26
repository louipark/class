package Pieces;
import java.awt.Color;
import java.util.ArrayList;




abstract public class Piece {	
    public Color color = null;
    public ArrayList<Space> moves; //an arraylist to hold all the possible moves
    
	/**
	 * @param spaces
	 * @param row
	 * @param colum
	 */
	abstract public void updateMoves(Piece [][] spaces, int row, int colum);
	
	/**
	 * @param target
	 * @return boolean
	 * check if the move is valid. Which means the target space is in the possible moves list.
	 */
	public boolean isValidMove(Space target) {
		if (moves != null) {

			for (int it = 0; it < moves.size(); it++) {
				if (moves.get(it).equals(target))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * @return color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * @param player
	 */
	protected void setColor(Color player) {
		color = player;
	}
	
	/**
	 * @param other
	 * @return boolean
	 * check if the pieces have same owner.
	 */
	public boolean sameOwner(Piece other) {
		if (other == null)
			return false;
		return color == other.color;
	}
	
	
	/**
	 * @param piece
	 * @param player
	 * @return
	 * Convert the name of the pieces into actual pieces.
	 */
	public static Piece stringToPiece(String name, Color player) {
		Piece retVal = null;
		
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
		case "Spec1":
			retVal = new Spec1();
			break;
		case "Spec2":
			retVal = new Spec2();
			break;
		default:
			return null;
		
		}
		
		retVal.setColor(player);
		return retVal;
	}
	
	/**
	 * checks if a given square should be added to the move list.
	 * @return true if the piece cannot jump past the square,
	 * so it have to add a move to get through this square
	 */
	protected boolean addMove(Piece curSpace, int row, int colum) {
		if (curSpace == null) {
			moves.add(new Space(row,colum));
			return false;
		} 
		else if (sameOwner(curSpace)) {
			return true;
		} 
		else {
			moves.add(new Space(row,colum));
			return true;
		}
	}
	
}