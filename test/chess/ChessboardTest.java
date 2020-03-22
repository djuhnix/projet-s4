package chess;
package chess.pieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess.pieces.Piece;

class ChessboardTest {
	private Piece pi= new Piece (7,WHITE, );
	@Test
	void testGetPiecePosition() {
		assertEquals("No", Chessboard.getPiece(1,1)); // TODO
	}

	@Test
	void testGetPieceIntInt() {
		assertEquals("No", Chessboard.getPiece(1,1))// TODO
	}

	@Test
	void testGetPiecePos() {
		assertEquals("Not yet implemented"); // TODO
	}

	@Test
	void testIsPiecePresentOnSameColumnBetween() {
		assertEquals("Not yet implemented"); // TODO
	}

	@Test
	void testIsPiecePresentOnSameLineBetween() {
		assertEquals("Not yet implemented"); // TODO
	}

	@Test
	void testIsPiecePresentOnSameDiagonalBetween() {
		assertEquals("Not yet implemented"); // TODO
	}

	@Test
	void testsetPiece() {
		assertEquals("Not yet implemented"); // TODO
	}

}
