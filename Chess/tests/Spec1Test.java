import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import ChessGame.Board;

import org.junit.Test;


public class Spec1Test {

	static Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board();
		board.setPiece("Spec1", 0, 0, Color.WHITE);
	}
	
	@Test
	public void spec1Move() {
		assertTrue("Spec1 move successful.",board.movePiece(0, 0, 3, 3));
		assertTrue("Spec1 moves back.", board.movePiece(3, 3, 1, 1));
		assertTrue("Spec1 moves down-left.",board.movePiece(1, 1, 0, 2));
		assertTrue("Spec1 moves up-right.",board.movePiece(0, 2, 1, 1));
		assertTrue("Spec1 jump right",board.movePiece(1, 1, 2, 3));	
		assertTrue("Spec1 jump left",board.movePiece(2, 3, 0, 2 ));	
	}
	
	@Test
	public void horizontalMove() {
		assertFalse("Horizontal move fails.",board.movePiece(0, 0, 8, 0));
		assertNotNull("Piece not moved.",board.getPiece(0, 0));
	}
	
	@Test
	public void verticalMove() {
		assertFalse("Vertical move fails.",board.movePiece(0, 0, 0, 8));
	}
	
	@Test
	public void captureEnemy() {
		board.setPiece("Rook",1,1,Color.BLACK);
		assertTrue("Captured enemy piece.",board.movePiece(0, 0, 1, 1));
		assertSame("Spec1 moved to enemy square.",Color.WHITE,board.getPiece(1, 1).getColor());
	}
}
