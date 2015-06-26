package ChessGame;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;
import Pieces.Space;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.io.File;
import java.io.IOException;


@SuppressWarnings("serial")
public class Board extends JPanel{
	private Piece [][] spaces;
	

	
	public Board() {
		spaces = new Piece[8][8];
	}
	
	/**
* A copy helper function that performs
* a deep copy of every element in the other board.
* @param other
*/
	public void copy(Board other) {
		for (int row = 0; row < spaces.length; row++) {
			for (int column = 0; column < spaces[0].length; column++) {
				spaces[row][column] = other.spaces[row][column];
			}
		}
	}

	/**
	 * Restarts the current board to the unitialized state with no pieces.
	 */
	public void reset() {
		for (int row = 0; row < spaces.length; row++) {
			for (int column = 0; column < spaces[0].length; column++) {
				spaces[row][column] = null;
			}
		}
	}
	
	/**
	 * @param paint is a java.swing.JComponent build in function
	 * http://blog.csdn.net/cnlht/article/details/8176130
	 */	  
	  public void paint(Graphics g) {
                                  //draw the chess board
		int gridSize = 80;
		for (int row = 0; row < spaces.length; row++) {
			for (int column = 0; column < spaces[0].length; column++) {
				int xpos = gridSize*row;
				int ypos = gridSize*column;
				
				if ((row+column)%2==1)
				g.setColor(Color.orange);
				else
				g.setColor(Color.yellow);
				
				g.fillRect(xpos,ypos,xpos+gridSize,ypos+gridSize);
                                 //place chess pieces on the chess board	
			if (spaces[row][column] != null) {
				
					BufferedImage piece = null;
					
					Color color = spaces[row][column].getColor();
					Piece chess = spaces[row][column];
					String filename = "./images/";
					
					if (color == null){};
					if (color == Color.BLACK)
						filename += "black/";
					if (color == Color.WHITE)
						filename += "white/";
					if (chess instanceof King)
						filename += "king.png";
					if (chess instanceof Queen)
						filename += "queen.png";
					if (chess instanceof Bishop)
						filename += "bishop.png";
					if (chess instanceof Knight)
						filename += "knight.png";
					if (chess instanceof Rook)
						filename += "rook.png";
					if (chess instanceof Pawn)
						filename += "pawn.png";
					try {
						piece = ImageIO.read(new File(filename));
					} catch (IOException e) {
						System.out.println("File read failed.");
					}
					
					g.drawImage(piece, gridSize * row, gridSize * column,
							null);
			}
			}
		}
		  }
	/**
	 * @param other
	 */
	public Board(Board other) {
		if (other == null) {
			spaces = null;
			return;
		}
		
		spaces = new Piece[other.spaces.length][other.spaces[0].length];
		
		for (int row = 0; row < spaces.length; row++) {
			for (int colum = 0; colum < spaces[0].length; colum++) {
				spaces[row][colum] = other.spaces[row][colum];
			}
		}
	}
	
	/**
	 * @param piece
	 * @param row
	 * @param colum
	 * @param player
	 * @return true if the piece was set successfully
	 */
	public boolean setPiece(String piece, int row, int colum, Color player) {
		if ((row < 0) || (colum < 0) || (row >= spaces.length) || (colum >= spaces[0].length))
			return false;  //check if out of the board
		if (spaces[row][colum] != null)
			return false;
		
		spaces[row][colum] = Piece.stringToPiece(piece,player);
		for (int r = 0; r < spaces.length; r++) {
			for (int f = 0; f < spaces[0].length; f++) {
				if (spaces[r][f] != null) {
					spaces[r][f].updateMoves(spaces,r,f); //update all the possible moves
				}
			}
		}
		return true;
	}
		
	/**
	 * @param row
	 * @param colum
	 * @return the piece at a given space
	 */
	public Piece getPiece(int row, int colum) {
		return spaces[row][colum];
	}
	
	/**
	 * @param rstart
	 * @param fstart
	 * @param rtarget
	 * @param ftarget
	 * @return true if the move was successful
	 * false otherwise
	 */
	public boolean movePiece(int rstart, int fstart, int rtarget, int ftarget) {
		if ((rstart < 0) || (fstart < 0) || (rstart >= spaces.length) || (fstart >= spaces[0].length))
			return false; //bound check
		
		if((rtarget < 0) || (ftarget < 0) || (rtarget >= spaces.length) || (ftarget >= spaces[0].length))
			return false; //bound check
		
		if (spaces[rstart][fstart] == null||(spaces[rstart][fstart].sameOwner(spaces[rtarget][ftarget])))
			return false;
		
		Space target = new Space(rtarget, ftarget);
		
		if (!spaces[rstart][fstart].isValidMove(target)) {
			return false;
		}
		else {
			spaces[rtarget][ftarget] = spaces[rstart][fstart];
			spaces[rstart][fstart] = null;
			for (int row = 0; row < spaces.length; row++) {
				for (int colum = 0; colum < spaces[0].length; colum++) {
					if (spaces[row][colum] != null) {
						spaces[row][colum].updateMoves(spaces,row,colum);
					}
				}
			} //copy everything to the target and update moves
			
			if (inCheck(spaces[rtarget][ftarget].getColor())) {
				return false;
			}//if in check 
			
			return true;
		}
	}
	
	
	
	/**
	 * @return boolean
	 * If the player is in check.
	 */
	public boolean inCheck(Color player) {
		Space king = null;
		for (int row = 0; row < spaces.length; row++) {
			for (int colum = 0; colum < spaces[0].length; colum++) {
				if (spaces[row][colum] instanceof King)
					if (spaces[row][colum].getColor() == player)
						king = new Space(row,colum);					
			}
		} //detect if the player's king is exist
		
		if (king == null)
			return false; //king dosen't exist
		
		for (int row = 0; row < spaces.length; row++) {
			for (int colum = 0; colum < spaces[0].length; colum++) {
				if (spaces[row][colum] != null) {
					for (int it = 0; it < spaces[row][colum].moves.size(); it++) {
						if(spaces[row][colum].moves.get(it).equals(king))
							return true;
					}
				}
			}
		} //check if there is an overlap between all the pieces' possible moves and player's king.
		
		return false;
	}
	
	/**
	 * @param player
	 * @return
	 */
	public boolean inCheckmate(Color player) {
		
		if (inCheck(player)) {
			Board copy;
	
			for (int row = 0; row < spaces.length; row++) {
				for (int colum = 0; colum < spaces[0].length; colum++) {
					if (spaces[row][colum] != null && spaces[row][colum].getColor() == player) {
						for (int r,f,it = 0; it < spaces[row][colum].moves.size(); it++) { //go through each space's move
							 copy = new Board(this);
							 r = spaces[row][colum].moves.get(it).getrow();
							 f = spaces[row][colum].moves.get(it).getcolum();
							 if (movePiece(row,colum,r,f))
								 if (!inCheck(player))
									 return false; // after one more move if the check condition disappear.
							 spaces = copy.spaces;
						}
					}
				}
			}
			
			return true; //still in check
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param player
	 * @return
	 */
	public boolean inStalemate(Color player) {
		if (!inCheck(player)) {
			Space king = null;
			for (int row = 0; row < spaces.length; row++) {
				for (int colum = 0; colum < spaces[0].length; colum++) {
					if (spaces[row][colum] instanceof King)
						if (spaces[row][colum].getColor() == player)
							king = new Space(row,colum);
				}
			} //get the king

			int co = king.getcolum();
			int ro = king.getrow();
			Board copy;

			if (spaces[co][ro].moves == null || spaces[co][ro].moves.isEmpty())
				return true; //if there is no more move
			
			for (int it = 0; it < spaces[co][ro].moves.size(); it++) {
				copy = new Board(this);
				int r = spaces[co][ro].moves.get(it).getrow();
				int f = spaces[co][ro].moves.get(it).getcolum();
				if (movePiece(king.getcolum(),king.getrow(),r,f))
					if (!inCheck(spaces[r][f].color))
						return false;
				spaces = copy.spaces;
			}
			return true;
		}
		return false;
	}
}
