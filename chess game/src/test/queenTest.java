package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import chessgame.chessboard;

public class queenTest {
	
	chessboard board;

	@Before
	public void setUp() throws Exception {
		board = new chessboard();
		board.setpiece("Queen", 0, 0, Color.WHITE);
	}
	
	@Test
	public void diagonalMove() {
		assertTrue("Queen can move diagonally.",board.movechess(0,0,4,4));
	}
	
	@Test
	public void horizontalMove() {
		assertTrue("Queen can move horizontally.",board.movechess(0,0,4,0));
	}
	
	@Test
	public void verticalMove() {
		assertTrue("Queen can move vertically.",board.movechess(0,0,4,4));
	}
	
	@Test
	public void wierdMove() {
		assertFalse("Queen cannot move in an L-shape.",board.movechess(0,0,4,1));
	}

	@Test
	public void captureFriendly() {
		board.setpiece("Rook",1,1,Color.WHITE);
		assertFalse("Queen cannot capture friendly pieces.",board.movechess(0,0,1,1));
	}
	
	@Test
	public void captureOpponent() {
		board.setpiece("Rook",1,1,Color.BLACK);
		assertTrue("Queen captured enemy piece.",board.movechess(0,0,1,1));
		assertSame("Queen moved to enemy square.",Color.WHITE,board.getpiece(1, 1).get_color());
	}
	
	@Test
	public void jumpFriendly() {
		board.setpiece("Rook",1,1,Color.WHITE);
		assertFalse("Queen cannot jump friendly pieces.",board.movechess(0,0,2,2));
	}
	
	@Test
	public void jumpEnemy() {
		board.setpiece("Rook", 2, 2, Color.BLACK);
		assertFalse("Queen cannot jump enemy pieces.",board.movechess(0,0,4,4));
	}
}
