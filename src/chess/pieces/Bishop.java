package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Bishop extends Piece {

	/**
	 * Constructeur.
	 * @param board échiquier auquel la pièce appartient
	 * @param position position initiale de la pièce
	 * @param color couleur de la pièce
	 */
	public Bishop(Chessboard board, Position position, Color color) 
	{
		super(board, position, color, "Bishop", color == Color.WHITE ? Symbol.WHITE_BISHOP : Symbol.BLACK_BISHOP);

	}

	@Override
	public boolean isValidMove(Position destination) {
		// a améliorer : la présense de pion de la même couleur sur la diagonale
		return (!this.getPosition().equals(destination) && this.getPosition().isOnSameDiagonalAs(destination));
	}

}
