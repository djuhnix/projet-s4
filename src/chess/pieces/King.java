package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class King extends Piece {

	/**
	 * Constructeur.
	 * @param board échiquier auquel la pièce appartient
	 * @param position position initiale de la pièce
	 * @param color couleur de la pièce
	 */
	public King(Chessboard board, Position position, Color color) 
	{
		super(board, position, color, "King", color == Color.WHITE ? Symbol.WHITE_KING : Symbol.BLACK_KING);
	}

	@Override
	public boolean isValidMove(Position destination) {

		return ( !this.getPosition().equals(destination)
				&& Math.abs(destination.getX() - this.getPosition().getX()) <= 1 
				&& Math.abs(destination.getY() - this.getPosition().getY()) <= 1 );
	}

}
