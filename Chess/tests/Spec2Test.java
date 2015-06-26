import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import ChessGame.Board;







import org.junit.Test;


public class Spec2Test {

	static Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board();
		board.setPiece("Spec2", 0, 0, Color.WHITE);
	}
	
	@Test
	public void spec2Move() {
		assertTrue("Move completed.",board.movePiece(0, 0, 6, 0));
		assertNull("Original piece deleted.",board.getPiece(0, 0));
		assertNotNull("New piece placed.",board.getPiece(6, 0));
		assertTrue("jump right",board.movePiece(6, 0, 7, 2));
		assertTrue("jump left",board.movePiece(7, 2, 5, 1));
	}
	
	@Test
	public void outOfBoundsMove() {
		assertFalse("Move did not complete.",board.movePiece(0, 0, -1, -1));
		assertFalse("Move did not complete.",board.movePiece(0, 0, 11, 11));
	}
	
	@Test
	public void diagonalMove() {
		assertFalse("Move failed.",board.movePiece(0, 0, 8, 8));
	}
	
	
	@Test
	public void captureOpponent() {
		board.setPiece("Rook", 1, 0, Color.BLACK);
		assertTrue("Capture succeeded.",board.movePiece(0, 0, 1, 0));
	}

}
