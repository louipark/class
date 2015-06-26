package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import chessgame.chessboard;

public class boardtest {
	static chessboard board;
	
	@Before
	public void setUp() {
		 board = new chessboard();
	}
	
	@Test 
	public void Badsetpiece() {
		assertFalse(board.setpiece("Rook",-1,-1,Color.WHITE));
	}
	
	@Test
	public void validsetpiece() {
		assertTrue(board.setpiece("Rook", 0, 0, Color.WHITE));
		assertNotNull(board.getpiece(0,0));
	}
	
	
	@Test
	public void Doublesetpiece() {
		board.setpiece("Rook", 0, 0, Color.WHITE);
		assertFalse("Double set failed",board.setpiece("Rook", 0, 0, Color.WHITE));
	}
	
	@Test 
	public void EmptyMove() {
		assertFalse("Both squares empty.",board.movechess(0,0,1,1));
	}
	
	@Test
	public void BadMove() {
		assertFalse("Invalid move failed.",board.movechess(-1,0,0,0));
	}
	

	@Test
	public void moveIntoCheck() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 1, 1, Color.BLACK);
		assertFalse("Can't move into check.",board.movechess(0, 0, 1, 0));
	}
	

	
	@Test
	public void captureIntoCheck() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 1, 0, Color.BLACK);
		board.setpiece("Rook", 1, 1, Color.BLACK);
		assertFalse("Can't capture into check.",board.movechess(0, 0, 1, 0));	
	}
	

}

