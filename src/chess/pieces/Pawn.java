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
		boolean res = false;
		boolean step = false;

		if ( !this.getPosition().equals(destination) ) {

			// les pions blancs avancent vers le haut
			if (this.getColor() == Color.WHITE) {
				if (this.getPosition().getX() < destination.getX()) {
					step = true;
				}
			} 
			// les pions noirs avancent vers le bas
			else {
				if (this.getPosition().getX() > destination.getX()) {
					step = true;
				}
			}

			int deltaX = Math.abs(this.getPosition().getX() - destination.getX());
			int deltaY = Math.abs(this.getPosition().getY() - destination.getY());
			
			// Mouvements normaux
			if ( step 
					&& deltaX  == 1 
					&& this.getPosition().isOnSameColumnAs(destination)) {
				res = true;
			}
			// Premier mouvement
			else if ( step 
					&& deltaX == 2
					&& this.getPosition().isOnSameColumnAs(destination)
					&& this.notMovedYet ) {
				res = true;

			}
			// Capture : mouvements en diagonales
			else if ( step 
					&& this.board.getPiece(destination).getColor() != this.getColor()
					&& this.getPosition().isOnSameDiagonalAs(destination)
					&& ( deltaY == 1 && deltaX == 1)) {
				res = true;
			}
		}

		return res;
	}

	@Override
	public void moveTo(Position destination) throws ChessMoveException
	{
		this.notMovedYet = false;
		super.moveTo(destination);
	}

}
