package chess;

import chess.pieces.Piece;
import chess.util.Position;

public class Chessboard extends java.lang.Object
{
	private Piece[][] piece;
	
	public Chessboard()
	{
		//this.piece = p;
	}
	
	public Piece getPiece(Position pos) 
	{
		return this.piece[pos.getX()][pos.getY()];
		
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
	
}
