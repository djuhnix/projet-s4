package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Knight extends Piece {

	/**
	 * Constructeur.
	 * @param board échiquier auquel la pièce appartient
	 * @param position position initiale de la pièce
	 * @param color couleur de la pièce
	 */
	public Knight(Chessboard board, Position position, Color color) 
	{
		super(board, position, color, "Knight", color == Color.WHITE ? Symbol.WHITE_KNIGHT : Symbol.BLACK_KNIGHT);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean res = false;
		/*
		 * Pas encore prêter attention
		if (!this.getPosition().equals(destination)) {

			int deltaX = Math.abs(this.getPosition().getX() - destination.getX());
			int deltaY = Math.abs(this.getPosition().getY() - destination.getY());
			if ((deltaX+deltaY) == 3 && deltaX !=0 && deltaY !=0)
			{return true;}
		}
		*/
		return res;
	}

}
