import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import ChessGame.Board;


public class KingTest {
	
	static Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board();
		board.setPiece("King", 5, 5, Color.WHITE);
	}

	@Test
	public void moveVertical() {
		assertTrue("King can move up.",board.movePiece(5, 5, 5, 4));
		assertTrue("King can move down.",board.movePiece(5, 4, 5, 5));
	}
	
	@Test
	public void moveHorizontal() {
		assertTrue("King can move left.",board.movePiece(5, 5, 4, 5));
		assertTrue("King can move right.",board.movePiece(4, 5, 5, 5));
	}
	
	@Test
	public void moveDiagonal() {
		assertTrue("King moves left-up.",board.movePiece(5, 5, 4, 4));
		assertTrue("King moves right-up.",board.movePiece(4, 4, 5, 3));
		assertTrue("King moves left-down.",board.movePiece(5, 3, 4, 4));
		assertTrue("King moves right-down.",board.movePiece(4, 4, 5, 5));
	}
	
	@Test
	public void moveMoreSpaces() {
		assertFalse("King cannot move 2 spaces diagonally.",board.movePiece(5, 5, 7, 7));
		assertFalse("King cannot move 2 spaces horizontally.",board.movePiece(7, 7, 5, 7));
		assertFalse("King cannot move 2 spaces vertically.",board.movePiece(5, 7, 5, 9));
	}
	
	@Test
	public void captureFriendly() {
		board.setPiece("Rook", 4, 4, Color.WHITE);
		assertFalse("King cannot capture a friendly piece.",board.movePiece(5, 5, 4, 4));
	}
	
	@Test
	public void captureEnemy() {
		board.setPiece("Rook", 4, 4, Color.BLACK);
		assertTrue("King captured an enemy piece.",board.movePiece(5, 5, 4, 4));
		assertSame("King moved to enemy square.",Color.WHITE,board.getPiece(4, 4).getColor());
	}
}
