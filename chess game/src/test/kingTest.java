package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import chessgame.chessboard;

public class kingTest {

	static chessboard board;
	
	@Before
	public void setUp() throws Exception {
		board = new chessboard();
		board.setpiece("King", 4, 4, Color.WHITE);
	}

	@Test
	public void moveVertical() {
		assertTrue("King can move up.",board.movechess(4, 4, 4, 3));
		assertTrue("King can move down.",board.movechess(4, 3, 4, 4));
	}
	
	@Test
	public void moveHorizontal() {
		assertTrue("King can move left.",board.movechess(4, 4, 3, 4));
		assertTrue("King can move right.",board.movechess(3, 4, 4, 4));
	}
	
	@Test
	public void moveDiagonal() {
		assertTrue("King moves left-up.",board.movechess(4, 4, 3, 3));
		assertTrue("King moves right-up.",board.movechess(3, 3, 4, 2));
		assertTrue("King moves left-down.",board.movechess(4, 2, 3, 3));
		assertTrue("King moves right-down.",board.movechess(3, 3, 4, 4));
	}
	
	@Test
	public void moveMoreSpaces() {
		assertFalse("King cannot move 2 spaces diagonally.",board.movechess(4, 4, 6, 6));
		assertFalse("King cannot move 2 spaces horizontally.",board.movechess(6, 6, 4, 6));
		assertFalse("King cannot move 2 spaces vertically.",board.movechess(4, 6, 4, 8));
	}
	
	@Test
	public void captureFriendly() {
		board.setpiece("Rook", 3, 3, Color.WHITE);
		assertFalse("King cannot capture a friendly piece.",board.movechess(4, 4, 3, 3));
	}
	
	@Test
	public void captureEnemy() {
		board.setpiece("Rook", 3, 3, Color.BLACK);
		assertTrue("King captured an enemy piece.",board.movechess(4, 4, 3, 3));
		assertSame("King moved to enemy square.",Color.WHITE,board.getpiece(3, 3).get_color());
	}
}
