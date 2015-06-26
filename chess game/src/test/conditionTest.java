package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import chessgame.chessboard;
import chessgame.condition_check;


public class conditionTest {
	public condition_check condition;
	public chessboard board;
	
	@Before
	public void setUp() {
		 condition = new condition_check();
		 board = new chessboard();
	}
	
	@Test
	public void notincheck() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("King", 7, 7, Color.BLACK);
		assertFalse("White is not in check.",condition.incheck(Color.WHITE));
		assertFalse("Black is not in check.",condition.incheck(Color.BLACK));
	}
	
	@Test
	public void notInFriendlyCheck() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 0, 1, Color.WHITE);
		assertFalse("Not in check with friendly piece.",condition.incheck(Color.WHITE));
	}
	
	@Test
	public void opponentincheck() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 0, 1, Color.BLACK);
		assertTrue("White is in check.",condition.incheck(Color.WHITE));
	}
	
	@Test
	public void otherPieceincheck() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 0, 1, Color.BLACK);
		board.setpiece("Rook", 8, 8, Color.WHITE);
		assertTrue("White in check.",condition.incheck(Color.WHITE));
		assertFalse("Need to move king out of check.",board.movechess(8, 8, 8, 7));
	}
	
	@Test
	public void captureOutofCheck() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 0, 1, Color.BLACK);
		board.setpiece("Rook", 1, 1, Color.WHITE);
		assertTrue("White is in check.",condition.incheck(Color.WHITE));
		assertTrue("Captured out of check.",board.movechess(1,1,0,1));
		assertFalse("White is no longer in check.",condition.incheck(Color.WHITE));
	}
	
	@Test
	public void notInFriendlyCheckmate() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 0, 2, Color.WHITE);
		board.setpiece("Rook", 1, 2, Color.WHITE);
		assertFalse("Not in checkmate with friendly pieces.",condition.inCheckmate(Color.WHITE));
	}

	@Test
	public void opponentincheckmate() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 0, 2, Color.BLACK);
		board.setpiece("Rook", 1, 2, Color.BLACK);
		assertTrue("White is in check.",condition.incheck(Color.WHITE));
		assertTrue("White in checkmate.",condition.inCheckmate(Color.WHITE));
	}
	
	@Test
	public void notincheckOrCheckMate() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("King", 7, 7, Color.BLACK);
		assertFalse("White is not in checkmate.",condition.inCheckmate(Color.WHITE));
		assertFalse("Black is not in checkmate.",condition.inCheckmate(Color.BLACK));
	}
	
	@Test
	public void notincheckMate() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("Rook", 5, 0, Color.BLACK);
		assertTrue("White is in check.",condition.incheck(Color.WHITE));
		assertFalse("White is not in checkmate.",condition.inCheckmate(Color.WHITE));
	}
	
	@Test
	public void inStalemate() {
		board.setpiece("King", 0, 0, Color.WHITE);
		board.setpiece("King", 1, 2, Color.BLACK);
		board.setpiece("Queen", 2, 1, Color.BLACK);
		assertTrue("White is in a stalemate.",condition.instalemate(Color.WHITE));
	}
	

}
