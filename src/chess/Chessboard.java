package chess;

import chess.pieces.*;
import chess.util.Color;
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
		piece = new Piece[8][8];
		// PAWN
		for(int i = 0; i < 8; i++)
		{
			piece[1][i] = new Pawn(this, new Position(i, 2), Color.WHITE);
			piece[6][i] = new Pawn(this, new Position(i, 7), Color.BLACK);
		}
		//ROOK
		piece[0][0] = new Rook(this, new Position(0, 0), Color.WHITE);
		piece[7][0] = new Rook(this, new Position(0, 7), Color.BLACK);
		piece[0][7] = new Rook(this, new Position(7, 0), Color.WHITE);
		piece[7][7] = new Rook(this, new Position(7, 7), Color.BLACK);

		//KNIGHT
		piece[0][1] = new Knight(this, new Position(1, 0), Color.WHITE);
		piece[7][1] = new Knight(this, new Position(1, 7), Color.BLACK);
		piece[0][6] = new Knight(this, new Position(6, 0), Color.WHITE);
		piece[7][6] = new Knight(this, new Position(6, 7), Color.BLACK);

		//BISHOP
		piece[0][2] = new Bishop(this, new Position(2, 0), Color.WHITE);
		piece[7][2] = new Bishop(this, new Position(2, 7), Color.BLACK);
		piece[0][5] = new Bishop(this, new Position(5, 0), Color.WHITE);
		piece[7][5] = new Bishop(this, new Position(5, 7), Color.BLACK);

		//QUEEN
		piece[7][3] = new Queen(this, new Position(3, 7), Color.BLACK);
		piece[0][3] = new Queen(this, new Position(3, 0), Color.WHITE);

		//KING
		piece[7][4] = new King(this, new Position(3, 7), Color.BLACK);
		piece[0][4] = new King(this, new Position(3, 0), Color.WHITE);

	}

	/**
	 * @param pos 
	 * @return
	 */
	public Piece getPiece(Position pos) 
	{
		return this.piece[pos.getY()][pos.getX()];		
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
		return this.piece[y][x];

	}

	public void setPiece(Position destination, Piece piece )
	{
		if( this.piece[destination.getY()][destination.getX()].getColor() != piece.getColor())
			this.piece[destination.getY()][destination.getX()] = piece;
	}

	public boolean isPiecePresentOnSameColumnBetween(Position start, Position end)
	{
		boolean res = false;

		if( !start.isOnSameColumnAs(end))
			throw new IllegalArgumentException("les positions start et end ne sont pas sur la même ligne");

		int dep, fin, fix = start.getX();

		if(start.getY() < end.getY() )
		{
			dep = start.getY();
			fin = end.getY();
		}else {
			dep = end.getY();
			fin = start.getY();	
		}

		while( (dep + 1 <  fin) && !res )
		{
			if(this.piece[dep][fix] != null)
				res = true;

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

		int dep, fin, fix = start.getY();

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
			if(this.piece[fix][dep] != null)
				res = true;

			dep++;
		}
		return res;
	}

	public boolean isPiecePresentOnSameDiagonalBetween(Position start, Position end) 
	{
		boolean res = false;

		if( !start.isOnSameDiagonalAs(end))
			throw new IllegalArgumentException("les positions start et end ne sont pas sur la même diagonale");

		int depX, finX, depY, finY;

		if(start.getX() < end.getX() )
		{
			depX = start.getX();
			finX = end.getX();
		}else {
			depX = end.getX();
			finX = start.getX();	
		}

		if(start.getY() < end.getY() )
		{
			depY = start.getY();
			finY = end.getY();
		}else {
			depY = end.getY();
			finY = start.getY();	
		}
		while( (depX + 1 < finX) 
				&& (depY + 1 < finY) 
				&& !res )
		{
			if(this.piece[depY][depX] != null)
				res = true;

			depX++;
			depY++;
		}
		return res;

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
		StringBuilder builder = new StringBuilder("     A   B   C   D   E   F   G   H\n" + 
				"   ┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓\n");
		for( int row = 7; row >= 0; row-- ) 
		{
			builder.append(row + 1 + "  ┃");
			for( int column = 0; column < 8; column++ )
			{
				char piece = this.piece[row][column] == null ? ' ' : this.piece[row][column].getSymbol();
				builder.append(" " + piece + " ┃");
			}
			builder.append(" " + (row + 1) + "\n");
			if(row != 0)
				builder.append	("   ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫\n");
		}
		builder.append		    ("   ┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛\n" + 
				"     A   B   C   D   E   F   G   H");
		return builder.toString();

	}

}
