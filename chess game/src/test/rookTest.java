package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import chessgame.chessboard;

public class rookTest {

	chessboard board;
		
	@Before
	public void setUp() throws Exception {
		board = new chessboard();
		board.setpiece("Rook",0,0,Color.WHITE);
	}
	
	@Test
	public void rookMove() {
		assertTrue("Move completed.",board.movechess(0, 0, 6, 0));
		assertNull("Original piece deleted.",board.getpiece(0, 0));
		assertNotNull("New piece placed.",board.getpiece(6, 0));
	}
	
	@Test
	public void outOfBoundsMove() {
		assertFalse("Move did not complete.",board.movechess(0, 0, -1, -1));
		assertFalse("Move did not complete.",board.movechess(0, 0, 9, 9));
	}
	
	@Test
	public void diagonalMove() {
		assertFalse("Move failed.",board.movechess(0, 0, 6, 6));
	}
	
	@Test
	public void weirdMove() {
		assertFalse("L-shaped path is invalid.",board.movechess(0, 0, 4, 1));
	}
	
	@Test
	public void captureFriendly() {
		board.setpiece("Rook", 1, 0, Color.WHITE);
		assertFalse("Capture failed.",board.movechess(0, 0, 1, 0));
	}
	
	@Test
	public void captureOpponent() {
		board.setpiece("Rook", 1, 0, Color.BLACK);
		assertTrue("Capture succeeded.",board.movechess(0, 0, 1, 0));
	}
	
	@Test
	public void jumpFriendlyPieces() {
		board.setpiece("Rook", 1, 0, Color.WHITE);
		assertFalse("Jumping failed.",board.movechess(0, 0, 2, 0));
	}
	
	@Test
	public void jumpEnemyPiece() {
		board.setpiece("Rook", 1, 0, Color.BLACK);
		board.setpiece("Rook", 2, 0, Color.BLACK);
		assertFalse("Jump failed.",board.movechess(0, 0, 2, 0));
	}
}
