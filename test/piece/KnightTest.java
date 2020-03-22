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
class KnightTest {
	private Piece Knight = new Knight(this, new Position(1, 0), Color.WHITE);
	/**
	 * Test method for {@link chess.pieces.Knight#isValidMove(chess.util.Position)}.
	 */
	@Test
	void testIsValidMove() {
		private Position pos = new Position(2,2);
		assertEquals(true, Knight.isValidMove(pos));
	}

