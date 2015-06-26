package ChessGame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Pieces.Piece;

import java.awt.event.MouseEvent;

public class Game {
	public static Board board;
	public static Board undo;
	
	public static String[] buttons = { "Forfeit","Restart","Scores","Undo"	};
	
	/**
	 * Initializes the chess board for a new chess game. Used for interaction
	 * between the MVC classes.
	 */
	public static void initialize() {
		board = new Board();
		initialize(board);
	}
	
	/**
	 * Adds the current board representation to the background of the chess GUI
	 * 
	 * @param frame
	 *            the frame for this instance of chess.
	 */
	public static void addBoard(JFrame frame) {
		frame.add(board);
	}
	
	

	public static void initialize(Board b) {

		
		for (int i = 0; i < 8; i++) {
			b.setPiece("Pawn", i, 1, Color.WHITE);
			b.setPiece("Pawn", i, 6, Color.BLACK);
		}
		
		b.setPiece("Rook", 0, 0, Color.WHITE);
		b.setPiece("Knight", 1, 0, Color.WHITE);
		b.setPiece("Bishop", 2, 0, Color.WHITE);
		b.setPiece("Queen", 3, 0, Color.WHITE);	
		b.setPiece( "King", 4, 0, Color.WHITE);	
		b.setPiece("Bishop", 5, 0, Color.WHITE);
		b.setPiece("Knight", 6, 0, Color.WHITE);	
		b.setPiece("Rook", 7, 0, Color.WHITE);
		
		b.setPiece("Rook", 0, 7, Color.BLACK);
		b.setPiece("Knight", 1, 7, Color.BLACK);
		b.setPiece("Bishop", 2, 7, Color.BLACK);
		b.setPiece("Queen", 3, 7, Color.BLACK);	
		b.setPiece( "King", 4, 7, Color.BLACK);	
		b.setPiece("Bishop", 5, 7, Color.BLACK);
		b.setPiece("Knight", 6, 7, Color.BLACK);	
		b.setPiece("Rook", 7, 7, Color.BLACK);
		
		undo = b;

	}
	
	private static void modelReset() {
		board.reset();
		initialize(board);
		undo = board;
	}

	
	/**
	 * Gets the tile clicked by the mouse.
	 * 
	 * @return the mouselistener.
	 */
	public static MouseListener getMouse(final JFrame frame) {
		FourCases.startGame();
		MouseListener mouselistener = new MouseListener() {
			int startRow;
			int startColumn;
			int endRow;
			int endFile;

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				translateMouseCoords(e, true);
				Piece piece = board.getPiece(startRow, startColumn);
				if (!(piece.getColor()==FourCases.getTurn())) {
					JOptionPane.showMessageDialog(frame,"Not your turn.");
				}
			}

			/**
			 * When the mouse is released after first being
			 * pressed.
			 * 
			 * source: java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
			 * @param e
			 *            the mouseEvent containing the location clicked
			 */
			public void mouseReleased(MouseEvent e) {
				translateMouseCoords(e, false);
				Board cache = new Board(board);
				undo = cache;
				
				if (board.movePiece(startRow, startColumn, endRow, endFile)) {
					FourCases.nextTurn();
					Color player = FourCases.getTurn();
					String curPlayer = FourCases.currentPlayer();
					
					 if (board.inCheck(player)) {
							JOptionPane.showMessageDialog(frame, curPlayer+ " is in check.");
						}
					 else if (board.inCheckmate(player)) {
							JOptionPane.showMessageDialog(frame, "Checkmate. "+ curPlayer + " loses.");
							FourCases.wins();
						}
				} else {
					JOptionPane.showMessageDialog(frame,"Error move.\nTry again.");
				}
			}

			/**
			 * Translates the mouse coordinates to 
			 * the (rank,file) position on the board.
			 * 
			 */
			private void translateMouseCoords(MouseEvent e, boolean pressed) {
				double x = e.getX() - 3;
				double y = e.getY() - 48;
				double i = x / 80;
				double j = y / 80;
				if (pressed) {
					startRow = (int) Math.floor(i);
					startColumn = (int) Math.floor(j);
				} else { //release
					endRow = (int) Math.floor(i);
					endFile = (int) Math.floor(j);
				}
			}
		};
		return mouselistener;
	}

	/**
	 * Creates a new button listener that takes all possible commands 
	 * 
	 */
	public static ActionListener getButtonListener(final JFrame frame) {
		ActionListener actionlistener = new ActionListener() {
			private static final int YES = 0;

			/**
			 * Get the menu commands
			 */
			public void actionPerformed(ActionEvent e) {
				int i = getCommandIndex(e);
				switch (i) {
				case 0: // Forfeit
					FourCases.forfeit();
					modelReset();
					break;
				case 1: // Restart
					restartGame(frame);
					break;
				case 2: // Scores
					String scoreboard = FourCases.getScoreList();
					JOptionPane.showMessageDialog(frame, scoreboard);
					break;
				case 3: // Undo
					board.copy(undo);
					FourCases.nextTurn();
					break;
				}
			}

			/**
			 * Restart the current game 
			 */
			private void restartGame(final JFrame frame) {
				int n = JOptionPane.showConfirmDialog(
						frame,
						FourCases.currentPlayer()
						+ " wants to restart. "
						+ "Do you accept?",
						"An Inane Question",
						JOptionPane.YES_NO_OPTION);
						if (n == YES) {
						FourCases.restart();
						modelReset();
						}
			}

			/**
			 * Finds the command in the list 
			 * return the index in the command list
			 */
			private int getCommandIndex(ActionEvent e) {
				String s = e.getActionCommand();
				int i;
				for (i = 0; i < buttons.length; i++) {
					if (s.equals(buttons[i])) {
						break;
					}
				}
				return i;
			}
		};
		return actionlistener;
	}

}
