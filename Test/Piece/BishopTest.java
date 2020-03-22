package chess.pieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess.util.Color;
import chess.util.Position;

class BishopTest {
	private Piece bis = new Bishop(this, new Position(2, 0), Color.WHITE);
	@Test
	void testIsValidMove() {
		private Position pos = new Position(2,5);
		assertEquals(true, bis.isValidMove(pos)); // E2 en partant de D3 
	}

}
