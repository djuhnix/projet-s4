package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Queen extends Piece {

	/**
	 * Constructeur.
	 * @param board échiquier auquel la pièce appartient
	 * @param position position initiale de la pièce
	 * @param color couleur de la pièce
	 */
	public Queen(Chessboard board, Position position, Color color) 
	{
		super(board, position, color, "Queen", color == Color.WHITE ? Symbol.WHITE_QUEEN : Symbol.BLACK_QUEEN);
	}

	@Override
	public boolean isValidMove(Position destination) {
		
		return !this.getPosition().equals(destination)
				&& !this.board.isPiecePresentOnSameLineBetween(this.getPosition(), destination)
				&& !this.board.isPiecePresentOnSameColumnBetween(this.getPosition(), destination)
				&& !this.board.isPiecePresentOnSameDiagonalBetween(this.getPosition(), destination);
	}

}
