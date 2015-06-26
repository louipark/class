package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import chessgame.chessboard;


public class knightTest {
	chessboard board;
	
	@Before
	public void setUp() throws Exception {
		board = new chessboard();
		board.setpiece("Knight", 4, 4, Color.WHITE);
	}

	@Test
	public void knightMove() {
		assertTrue("Knight moves up-left.",board.movechess(4, 4, 3, 2));
		assertTrue("Knight moves down-right.",board.movechess(3, 2, 4, 4));
		assertTrue("Knight moves down-left.",board.movechess(4, 4, 5, 6));
		assertTrue("Knight moves up-right.",board.movechess(5, 6, 4, 4));
		assertTrue("Knight moves left-up.",board.movechess(4, 4, 2, 3));
		assertTrue("Knight moves right-down.",board.movechess(2, 3, 4, 4));
		assertTrue("Knight moves right-up.",board.movechess(4, 4, 6, 3));
		assertTrue("Knight moves left-down.",board.movechess(6, 3, 4, 4));
	}
	
	@Test 
	public void horizontalMove() {
		assertFalse("Knight cannot move horizontally 1 space right.",board.movechess(4, 4, 5, 4));
		assertFalse("Knight cannot move horizontally 2 spaces left.",board.movechess(5, 4, 3, 4));
	}
	
	@Test
	public void verticalMove() {
		assertFalse("Knight cannot mvoe vertically 1 space up.",board.movechess(4, 4, 4, 3));
		assertFalse("Knight cannot move vertically 2 space down.",board.movechess(4, 3, 4, 5));
	}
	
	@Test
	public void diagonalMove() {
		assertFalse("Knight cannot move diagonally 1 space.",board.movechess(4, 4, 3, 3));
		assertFalse("Knight cannot move diagonally 2 spaces.",board.movechess(3, 3, 1, 5));
	}

	@Test
	public void captureFriendly() {
		board.setpiece("Rook", 3, 2, Color.WHITE);
		assertFalse("Knight cannot capture friendly pieces.",board.movechess(4, 4, 3, 2));
	}
	
	@Test
	public void captureOpponent() {
		board.setpiece("Rook", 3, 2, Color.BLACK);
		assertTrue("Knight captured enemy piece.",board.movechess(4, 4, 3, 2));
	}
	
	@Test
	public void jumpFriendly() {
		board.setpiece("Rook", 3, 4, Color.WHITE);
		board.setpiece("Rook", 3, 3, Color.WHITE);
		assertTrue("Knight can jump friendly pieces.",board.movechess(4, 4, 3, 2));
	}
	
	@Test
	public void jumpOpponent() {
		board.setpiece("Rook", 3, 4, Color.BLACK);
		board.setpiece("Rook", 3, 3, Color.BLACK);
		assertTrue("Knight can jump enemy pieces.",board.movechess(4, 4, 3, 2));		
	}
}
