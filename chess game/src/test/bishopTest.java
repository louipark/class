package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import chessgame.chessboard;
import chessgame.condition_check;


public class bishopTest {
	public condition_check condition;
	public chessboard board;
	
	
	
	@Before
	public void setUp() throws Exception {
		board = new chessboard();
		board.setpiece("Bishop", 0, 0, Color.WHITE);
	}

	@Test
	public void bishopMove() {
		assertTrue("Bishop move successful.",board.movechess(0, 0, 2, 2));
		assertNull("Original square empty.",board.getpiece(0, 0));
		assertNotNull("New piece placed.",board.getpiece(2, 2));
		assertTrue("Bishop moves back.", board.movechess(2, 2, 1, 1));
		assertTrue("Bishop moves down-left.",board.movechess(1, 1, 0, 2));
		assertTrue("Bishop moves up-right.",board.movechess(0, 2, 1, 1));
	}
	
	@Test
	public void horizontalMove() {
		assertFalse("Horizontal move fails.",board.movechess(0, 0, 5, 0));
		assertNotNull("Piece not moved.",board.getpiece(0, 0));
	}
	
	@Test
	public void verticalMove() {
		assertFalse("Vertical move fails.",board.movechess(0, 0, 0, 5));
	}
	
	@Test
	public void weirdMove() {
		assertFalse("L-shaped path is invalid.",board.movechess(0, 0, 4, 1));
	}
	
	@Test
	public void jumpFriendlyPieces() {
		board.setpiece("Rook",1,1,Color.WHITE);
		assertFalse("Failed to jump friendly piece.",board.movechess(0, 0, 2, 2));
	}
	
	@Test
	public void jumpEnemyPieces() {
		board.setpiece("Rook",1,1,Color.BLACK);
		assertFalse("Failed to jump enemy piece.",board.movechess(0, 0, 2, 2));
	}
	
	@Test
	public void captureFriendly() {
		board.setpiece("Rook",1,1,Color.WHITE);
		assertFalse("Failed to capture friendly piece.",board.movechess(0, 0, 1, 1));
	}
	
	@Test
	public void captureEnemy() {
		board.setpiece("Rook",1,1,Color.BLACK);
		assertTrue("Captured enemy piece.",board.movechess(0, 0, 1, 1));
		assertSame("Bishop moved to enemy square.",Color.WHITE,board.getpiece(1, 1).get_color());
	}

}

