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
class KingTest {
	private Piece king = new King(this, new Position(3, 0), Color.WHITE);
	/**
	 * Test method for {@link chess.pieces.King#isValidMove(chess.util.Position)}.
	 */
	@Test
	void testIsValidMove() {
		private Position pos = new Position(3,1) ;
		assertEquals(true, king.isValidMove(pos)); // TODO
	}

}
