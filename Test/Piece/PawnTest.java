/**
 * 
 */
package chess.pieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess.util.Color;
import chess.util.Position;

/**
 * @author Zermani Rayan
 *
 */
class PawnTest {
	private Piece paw = new Pawn(this, new Position(1, 2), Color.WHITE);


	/**
	 * Test method for {@link chess.pieces.Pawn#isValidMove(chess.util.Position)}.
	 */
	@Test
	void testIsValidMove() {
		assertEquals(true, paw.isValidMove((1,3)); // TODO
	}
	/**
	 * Test method for {@link chess.pieces.Pawn#moveTo(chess.util.Position)}.
	 */
	@Test
	void testMoveTo() {
		assertEquals("Not yet implemented"); // TODO
	}
}
