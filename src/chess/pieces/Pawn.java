package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Pawn extends Piece {

	/**
	 * Constructeur.
	 * @param board échiquier auquel la pièce appartient
	 * @param position position initiale de la pièce
	 * @param color couleur de la pièce
	 */
	public Pawn(Chessboard board, Position position, Color color) 
	{
		super(board, position, color, "Pawn", color == Color.WHITE ? Symbol.WHITE_PAWN : Symbol.BLACK_PAWN);
	}

	@Override
	public boolean isValidMove(Position destination) {
		// TODO Auto-generated method stub
		return false;
	}

}
