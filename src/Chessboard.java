
public class Chessboard extends java.lang.Object
{
	private Piece[][] piece;
	public Chessboard(Piece p)
	{
		this.piece=p;
	}
	public Piece[] getPiece(Position pos) 
	{
		return (this.piece[pos.getX(),pos.getY()] );
		
	}
	public void setPiece(Position pos, Piece p )
	{
		//TODO
		this.piece=p;
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
