package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import chessgame.chessboard;

class pawnTest {
	
	chessboard board;
	
	@Before
	public void setUp() throws Exception {
		board = new chessboard();
		board.setpiece("Pawn", 1, 1, Color.BLACK);
	}

	@Test
	public void firstMoveTwoSquares() {
		assertTrue("Pawn can move 2 squares vertically on the first move.",board.movechess(1, 1, 1, 3));
	}
	
	@Test
	public void doubleSpecialMove() {
		board.movechess(1, 1, 1, 3);
		assertFalse("Pawn cannot move 2 squares forward after the first time.",board.movechess(1, 3, 1, 5));
	}
	
	@Test
	public void moveBackwards() {
		assertFalse("Pawns can't move backwards.",board.movechess(1, 1, 1, 0));
	}
	
	@Test
	public void moveHorizontal() {
		assertFalse("Pawns cannot move left.",board.movechess(1, 1, 0, 1));
		assertFalse("Pawns cannot move right.",board.movechess(1, 1, 2, 1));
	}
	
	@Test
	public void moveDiagonal() {
		assertFalse("Pawns cannot move diagonally.",board.movechess(1, 1, 2, 2));
		assertFalse("Pawns cannot move diagonally.",board.movechess(1, 1, 0, 0));
		assertFalse("Pawns cannot move diagonally.",board.movechess(1, 1, 0, 2));
		assertFalse("Pawns cannot move diagonally.",board.movechess(1, 1, 2, 0));
	}
	
	@Test
	public void captureBackwards() {
		board.setpiece("Pawn", 0, 0, Color.WHITE);
		board.setpiece("Pawn", 2, 0, Color.WHITE);
		assertFalse("Pawns cannot capture backwards.",board.movechess(1, 1, 2, 0));
		assertFalse("Pawns cannot capture backwards.",board.movechess(1, 1, 0, 0));
	}
	
	@Test
	public void captureForwards() {
		board.setpiece("Pawn", 0, 2, Color.WHITE);
		board.setpiece("Pawn", 2, 2, Color.WHITE);
		assertTrue("Pawn captured forwards.",board.movechess(1, 1, 0, 2));
		board.setpiece("Pawn", 1, 1, Color.BLACK);
		assertTrue("Pawn captured forwards.",board.movechess(1, 1, 2, 2));
	}
}
