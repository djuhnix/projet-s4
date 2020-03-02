package chess;

import chess.pieces.Piece;
import chess.util.Position;

public class Chessboard extends java.lang.Object
{
	private Piece[][] piece;
	/**
	 * Constructeur par défaut.
	 * Initialise l'échiquier avec toutes les pièces sur leur case de départ.
	 */
	public Chessboard()
	{
		//TODO
	}
	/**
	 * 
	 * @param pos 
	 * @return
	 */
	public Piece getPiece(Position pos) 
	{
		return this.piece[pos.getX()][pos.getY()];
		
	}
	/**
	 * Retourne la pièce de la case (x,y) de l'échiquier ou null si la case est vide.
	 * 
	 * @param x abscisse de la case (0 à 7)
	 * @param y ordonnée de la case (0 à 7)
	 * @return     pièce située sur la case ou null si la case est vide
	 */
	public Piece getPiece(int x, int y) 
	{
		return this.piece[x][y];
		
	}
	
	public void setPiece(Position pos, Piece p )
	{
		this.piece[pos.getX()][pos.getY()] = p;
	}
	
	public boolean isPiecePresentOnSameColumnBetween(Position start, Position end)
	{
		//TODO
		return false;		
	}
	public boolean isPiecePresentOnSameDiagonalBetween(Position start, Position end) 
	{
		//TODO
		return false;
		
	}
	@Override
	public String toString()
	{
		//TODO
		return null;
		
	}
	
}
