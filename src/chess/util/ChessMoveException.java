package chess.util;
/**
 * Lancée lorsqu'un déplacement est invalide.
 * 
 * @author olea0001
 *
 */
public class ChessMoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur.
	 * 
	 * @param message 			détails de l'exception
	 * @param startingPosition 	position de la case de départ du déplacement
	 * @param destination 		position de la case de destination du déplacement
	 */
	public ChessMoveException(String message, Position startingPosition, Position destination)
	{
		super("Erreur de déplacement de pièce : " + message + " de " + startingPosition + " à " + destination);
	}

}
