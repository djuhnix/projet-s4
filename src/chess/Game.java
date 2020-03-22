package chess;

import java.util.Scanner;

import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;
/**
 * Classe représentant une partie d'échecs.
 * @author olea0001
 *
 */
public class Game {
	private Chessboard board;
	private Color currentColor;
	private String blackPlayerName;
	private String whitePlayerName;


	/**
	 * Constructeur
	 * 
	 * @param blackPlayerName nom du joueur ayant les pièces noires
	 * @param whitePlayerName nom du joueur ayant les pièces blanches
	 */
	public Game(String blackPlayerName, String whitePlayerName) {
		this.blackPlayerName = blackPlayerName;
		this.whitePlayerName = whitePlayerName;
		this.currentColor = Color.WHITE;
		this.board = new Chessboard();
	}

	/**
	 * Retourne la couleur des pièces du joueur dont c'est le tour
	 * 
	 * @return the currentColor
	 */
	public Color getCurrentColor() {
		return this.currentColor;
	}

	/**
	 * Retourne le nom du joueur ayant les pièces noires
	 * 
	 * @return the blackPlayerName
	 */
	public String getBlackPlayerName() {
		return this.blackPlayerName;
	}

	/**
	 * Retourne le nom du joueur ayant les pièces blanches
	 * @return the whitePlayerName
	 */
	public String getWhitePlayerName() {
		return this.whitePlayerName;
	}

	/**
	 * Tour du jour courant. 
	 * Si une piece de la couleur actuelle est présente à la position start, elle est déplacer si cela est valide à la position end.
	 * 
	 * @param start
	 * @param end
	 * @throws ChessMoveException 
	 */
	public void turn(Position start, Position end) throws ChessMoveException
	{
		if(this.board.getPiece(start) == null)
			throw new ChessMoveException("Impossible de d'effectuer le déplacement, la case de départ est vide.", start, end);

		else if(this.board.getPiece(start).getColor() != this.currentColor)
			throw new ChessMoveException("Impossible de d'effectuer le déplacement, la case de départ  contient une pièce de l'adversaire.", start, end);

		else if(!this.board.getPiece(start).isValidMove(end))
			throw new ChessMoveException("Impossible de d'effectuer le déplacement, destination invalide pour cette piece.", start, end);

		//déplace la piece vers la destination (end)
		this.board.setPiece(end, this.board.getPiece(start));

		//retire la piece de son emplacement
		this.board.setPiece(start, null);

		//change de couleur
		this.currentColor = this.currentColor == Color.BLACK ? Color.WHITE
				: Color.BLACK;
	}

	/**
	 * Programme principal. Permet à deux joueurs de saisir leurs déplacements à tour de rôle, en affichant l'échiquier après chaque coup.
	 * 
	 * @param args arguments de ligne de commande, pas utilisés.
	 */
	public static void main( String [] args ) 
	{

		Game chess = new Game("Blue", "Red");		
		System.out.println(chess.board);
		System.out.println("Début du jeu");
		Scanner sc = new Scanner(System.in);
		Color beforeTurn = chess.getCurrentColor();
		do {
			System.out.print("Veuillez saisir la case de depart : ");
			String dep = sc.nextLine();

			System.out.print("Veuillez saisir la case de destination ");
			String fin = sc.nextLine();
			if(Position.isAlgebraicNotation(dep) && Position.isAlgebraicNotation(fin)) {
				try {
					chess.turn(new Position(dep), new Position(fin));
					System.out.println(chess.board);
				} catch (ChessMoveException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}while(beforeTurn == chess.getCurrentColor());

	}

}
