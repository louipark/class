import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import ChessGame.Board;


public class QueenTest {
	Board board;

	@Before
	public void setUp() throws Exception {
		board = new Board();
		board.setPiece("Queen", 0, 0, Color.WHITE);
	}
	
	@Test
	public void diagonalMove() {
		assertTrue("Queen can move diagonally.",board.movePiece(0,0,5,5));
	}
	
	@Test
	public void verticalMove() {
		assertTrue("Queen can move vertically.",board.movePiece(0,0,5,5));
	}
	
	@Test
	public void horizontalMove() {
		assertTrue("Queen can move horizontally.",board.movePiece(0,0,5,0));
	}
	
	
	@Test
	public void wierdMove() {
		assertFalse("Queen cannot move in an L-shape.",board.movePiece(0,0,4,1));
	}

	@Test
	public void captureFriendly() {
		board.setPiece("Rook",1,1,Color.WHITE);
		assertFalse("Queen cannot capture friendly pieces.",board.movePiece(0,0,1,1));
	}
	
	@Test
	public void captureOpponent() {
		board.setPiece("Rook",1,1,Color.BLACK);
		assertTrue("Queen captured enemy piece.",board.movePiece(0,0,1,1));
		assertSame("Queen moved to enemy square.",Color.WHITE,board.getPiece(1, 1).getColor());
	}
	
}
