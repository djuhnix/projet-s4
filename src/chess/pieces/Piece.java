package chess.pieces;

import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;
import chess.Chessboard;

/**
 * Classe de base représentant une pièce du jeu d'échecs
 * 
 * @author olea0001
 *
 */
public abstract class Piece 
{
	/**
	 * Echiquier auquel la pièce appartient
	 */
	protected 	Chessboard 	board;
	/**
	 * Couleur de la pièce (Color.WHITE ou Color.BLACK)
	 */
	private 	Color 		color;
	/**
	 * Nom de la pièce (Roi, Reine, ...)
	 */
	private 	String 		name;
	/**
	 * Position de la pièce sur l'échiquier
	 */
	private 	Position 	position;
	/**
	 * Symbole de la pièce
	 */
	private 	char 	symbol;
	/**
	 * Constructeur
	 * @param chessboard 	échiquier auquel la pièce appartient
	 * @param position 		position initiale de la pièce
	 * @param color 		couleur de la pièce
	 * @param name 			nom de la pièce
	 * @param symbol 		symbole de la pièce
	 */
	public Piece(
			Chessboard 	chessboard,
            Position 	position,
            Color 		color,
            String 		name,
            char 		symbol
            ) 
	{
		this.board 		= chessboard;
		this.position 	= position;
		this.color 		= color;
		this.name		= name;
		this.symbol 	= symbol;
	}
	
	/**
	 * Retourne la couleur de la pièce
	 * @return la couleur de la pièce
	 */
	public Color getColor() 
	{
		return this.color;
	}
	
	/**
	 * Retourne le nom de la pièce.
	 * @return le nom de la pièce.
	 */
	public String getName() 
	{
		return this.name;
	}
	
	/**
	 * Retourne la position de la pièce sur l'échiquier.
	 * @return la position de la pièce sur l'échiquier
	 */
	public Position getPosition() 
	{
		return this.position;
	}
	
	/**
	 * Retourne le symbole de la pièce.
	 * @return le symbole de la pièce.
	 */
	public char getSymbol() 
	{
		return this.symbol;
	}
	/**
	 * teste la couleur de la pièce.
	 * @return true si la pièce est noire, false sinon.
	 */
	public boolean isBlack() 
	{
		return this.color == Color.BLACK;		
	}
	/**
	 * teste la couleur de la pièce.
	 * @return true si la pièce est blanche, false sinon
	 */
	public boolean isWhite() 
	{
		return this.color == Color.WHITE;
	}
	
	/**
	 * deplace la pièce sur la case indiquée.
	 * @param destination position de la case de destination du déplacement.
	 * @throws ChessMoveException si le mouvement n'est pas possible.
	 */
	public void moveTo(Position destination) throws ChessMoveException 
	{
		if(!this.isValidMove(destination))
			throw new ChessMoveException("Impossible de déplacer la pièce vers la destination donnée", this.position, destination);
		
		this.position = destination;
		this.board.setPiece(destination, this);
	}
	/**
	 * teste la validité d'un déplacement
	 * 
	 * @param destination position de la case de destination du déplacement.
	 * @return true si le mouvement est possible, false sinon.
	 */
	public abstract boolean  isValidMove(Position destination);
	
	
}
