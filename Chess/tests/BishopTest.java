import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

import ChessGame.Board;


public class BishopTest {
	static Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board();
		board.setPiece("Bishop", 0, 0, Color.WHITE);
	}

	@Test
	public void bishopMove() {
		assertTrue("Bishop move successful.",board.movePiece(0, 0, 3, 3));
		assertTrue("Bishop moves back.", board.movePiece(3, 3, 1, 1));
		assertTrue("Bishop moves down-left.",board.movePiece(1, 1, 0, 2));
		assertTrue("Bishop moves up-right.",board.movePiece(0, 2, 1, 1));
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
	public void weirdMove() {
		assertFalse("L-shaped path is invalid.",board.movePiece(0, 0, 8, 1));
	}
	
	@Test
	public void jumpFriendlyPieces() {
		board.setPiece("Rook",1,1,Color.WHITE);
		assertFalse("Failed to jump friendly piece.",board.movePiece(0, 0, 2, 2));
	}
	
	@Test
	public void jumpEnemyPieces() {
		board.setPiece("Rook",1,1,Color.BLACK);
		assertFalse("Failed to jump enemy piece.",board.movePiece(0, 0, 2, 2));
	}
	
	@Test
	public void captureFriendly() {
		board.setPiece("Rook",1,1,Color.WHITE);
		assertFalse("Failed to capture friendly piece.",board.movePiece(0, 0, 1, 1));
	}
	
	@Test
	public void captureEnemy() {
		board.setPiece("Rook",1,1,Color.BLACK);
		assertTrue("Captured enemy piece.",board.movePiece(0, 0, 1, 1));
		assertSame("Bishop moved to enemy square.",Color.WHITE,board.getPiece(1, 1).getColor());
	}

}
