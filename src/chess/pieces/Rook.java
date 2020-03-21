package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Rook extends Piece {

	/**
	 * Constructeur.
	 * @param board échiquier auquel la pièce appartient
	 * @param position position initiale de la pièce
	 * @param color couleur de la pièce
	 */
	public Rook(Chessboard board, Position position, Color color) 
	{
		super(board, position, color, "Rook", color == Color.WHITE ? Symbol.WHITE_ROOK : Symbol.BLACK_ROOK);
	}

	@Override
	public boolean isValidMove(Position destination) {
		// A pofiner
		return (!this.getPosition().equals(destination)
				&& (this.getPosition().isOnSameColumnAs(destination) 
				|| this.getPosition().isOnSameLineAs(destination) ));
	}

}
