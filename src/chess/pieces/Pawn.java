package chess.pieces;

import chess.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

public class Pawn extends Piece {
	/**
	 * vrai si le pion n'a pas encore été déplacé. Mis à faux dès le premier déplacement.
	 */
	private boolean notMovedYet;

	/**
	 * Constructeur.
	 * @param board échiquier auquel la pièce appartient
	 * @param position position initiale de la pièce
	 * @param color couleur de la pièce
	 */
	public Pawn(Chessboard board, Position position, Color color) 
	{
		super(board, position, color, "Pawn", color == Color.WHITE ? Symbol.WHITE_PAWN : Symbol.BLACK_PAWN);
		this.notMovedYet = true;
	}

	@Override
	public boolean isValidMove(Position destination) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void moveTo(Position destination) throws ChessMoveException
	{
		this.notMovedYet = false;
		super.moveTo(destination);
	}

}
