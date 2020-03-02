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
	 * @return  pièce située sur la case ou null si la case est vide
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
		boolean res = false;

		if( !start.isOnSameColumnAs(end))
			throw new IllegalArgumentException("les positions start et end ne sont pas sur la même ligne");

		int dep, fin;
		
		if(start.getY() < end.getY() )
		{
			dep = start.getY();
			fin = end.getY();
		}else {
			dep = end.getY();
			fin = start.getY();	
		}
		
		while( dep + 1 <  fin && !res )
		{
			for(Piece p : this.piece[dep])
			{
				if(p != null)
					res = true;
			}
			dep++;
		}
		
		return res;	
	}
	
	/**
	 * teste la présence d'une pièce sur la ligne comprise entre les positions start et end (exclues).
	 * 
	 * @param start première extrémité
	 * @param end   seconde extrémité
	 * @return true s'il y a une pièce sur la ligne comprise entre les positions start et end (exclues), false sinon.
	 * @throws IllegalArgumentException les positions start et end ne sont pas sur la même ligne
	 */
	public boolean isPiecePresentOnSameLineBetween(Position start, Position end)
	{
		boolean res = false;

		if( !start.isOnSameLineAs(end))
			throw new IllegalArgumentException("les positions start et end ne sont pas sur la même ligne");

		int dep, fin;
		
		if(start.getX() < end.getX() )
		{
			dep = start.getX();
			fin = end.getX();
		}else {
			dep = end.getX();
			fin = start.getX();	
		}
		
		while( dep + 1 <  fin && !res )
		{
			for(Piece p : this.piece[dep])
			{
				if(p != null)
					res = true;
			}
			dep++;
		}
		
		return res;	
	}
	
	public boolean isPiecePresentOnSameDiagonalBetween(Position start, Position end) 
	{
		boolean res = false;

		if( !start.isOnSameLineAs(end))
			throw new IllegalArgumentException("les positions start et end ne sont pas sur la même ligne");

		int depX, finX, depY, finY;
		
		if(start.getX() < end.getX() )
		{
			depX = start.getX();
			finX = end.getX();
		}else {
			depX = end.getX();
			finX = start.getX();	
		}
		//TODO
		return false;

	}

	/**
	 * Retourne une chaîne de caractères représentant l'échiquier. Exemple :
	 *
	 *	      A   B   C   D   E   F   G   H
	 *	   ┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓
	 *	 8 ┃ ♝ ┃ ♞ ┃ ♟ ┃   ┃ ♚ ┃ ♝ ┃   ┃   ┃ 8
	 *	   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
	 *	 7 ┃ ♟ ┃ ♖ ┃   ┃ ♟ ┃   ┃ ♟ ┃   ┃ ♟ ┃ 7
	 *	   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
	 *	 6 ┃ ♙ ┃   ┃   ┃ ♟ ┃   ┃   ┃   ┃   ┃ 6
	 *	   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
	 *	 5 ┃ ♜ ┃   ┃   ┃ ♕ ┃   ┃ ♙ ┃   ┃   ┃ 5
	 *	   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
	 *	 4 ┃ ♗ ┃ ♙ ┃   ┃   ┃   ┃   ┃   ┃   ┃ 4
	 *	   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
	 *	 3 ┃   ┃ ♜ ┃ ♙ ┃ ♟ ┃   ┃   ┃ ♘ ┃   ┃ 3
	 *	   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
	 *	 2 ┃ ♙ ┃ ♙ ┃   ┃ ♟ ┃   ┃   ┃ ♙ ┃   ┃ 2
	 *	   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
	 *	 1 ┃ ♞ ┃ ♙ ┃ ♗ ┃ ♛ ┃ ♔ ┃   ┃ ♘ ┃ ♖ ┃ 1
	 *	   ┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛
	 *	     A   B   C   D   E   F   G   H
	 *
	 * @Override     toString in class java.lang.Object
	 */
	@Override
	public String toString()
	{
		//TODO
		return null;

	}

}
