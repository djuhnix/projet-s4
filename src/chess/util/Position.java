package chess.util;

public class Position {
	
	private int x, y;
	
	/**
	 * Constructeur par défaut
	 */
	public Position() 
	{
		this.x = 0;
		this.y = 0;
	}
	/**
	 * Constructeur avec paramètres
	 * @param x
	 * @param y
	 * @exception IllegalArgumentException : La position n'est pas valide 
	 */
	public Position(int x, int y) 
	{
		if (x < 0 || x > 7 || y < 0 || y > 7)
			throw new IllegalArgumentException("Position invalide : " + x + "," + y);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Vérifie que la chîne passé en paramètre est bien une notation algébrique
	 * @param algebraicNotation
	 * @return boolean res  vrai selon que la conditions vérifiées
	 */
	public static boolean isAlgebraicNotation(String algebraicNotation ) 
	{
		boolean res = false;
		if (algebraicNotation.length() == 2)
		{
			char first = algebraicNotation.charAt(0), 
					second = algebraicNotation.charAt(1);
			if ( (first >= 'A' && first <= 'H') 
					&& (second >= '1' && second <= '8'))
			{
				res = true;
			}
		}
		return res;
	}
	
	/**
	 * Vérifie la position 
	 * @param algebraicNotation
	 */
	public Position(String algebraicNotation) 
	{
		if (!Position.isAlgebraicNotation(algebraicNotation))
			throw new IllegalArgumentException("Notation algébrique incorrecte");
		
		this.y = Character.getNumericValue(algebraicNotation.charAt(1));
		
		char letter = 'A';
		char first = algebraicNotation.charAt(0);
		
		for(int i = 1; i <= 8; i++)
		{
			if(first == letter)
			{
				this.x = i;
			}
			letter++;
		}
	}
	
	/**
	 * Retourne une chaîne de 2 caractères contenant la notation algébrique de la position courante
	 * @param algebraicNotation
	 * @return la chaîne
	 */
	public String toAlgebraicNotation() 
	{
		char letter = 'A', first = ' ';
		for(int i = 1; i <= 8; i++)
		{
			if(i == this.x)
			{
				first = letter;
			}
			letter++;
		}
		return first + "" + this.y;
	}
	
	/**
	 * Vérifie que la position passée en paramètre est sur la même ligne que l'objet actuel
	 * 
	 * @param pos
	 * @return res 
	 */
	public boolean isOnSameLineAs(Position pos) 
	{
		return (pos.y == this.y);
	}
	/**
	 * Vérifie que la position passée en paramètre est sur la même colonne que l'objet actuel
	 * @param pos
	 * @return res 
	 */
	public boolean isOnSameColumnAs(Position pos) 
	{
		return (pos.x == this.x);
	}
	/**
	 * Vérifie que la position passée en paramètre est sur la même diagonale que l'objet actuel
	 * @param pos
	 * @return res
	 */
	public boolean isOnSameDiagonalAs(Position pos) 
	{
		return ( (pos.x - this.x) == (pos.y - this.y) 
				|| (pos.x - this.x) == (this.y - pos.y));
	}
	/**
	 * Donne l'accès à la distance entre l'objet Manahattan et l'objet actuel 
	 * @param pos
	 * @return
	 */
	public int getManhattanDistance(Position pos) 
	{
		return Math.abs(pos.x - this.x) + Math.abs(pos.y - this.y);		
	}
	
	public int getX() 
	{
		return this.x;
	}
	
	public int getY() 
	{
		return this.y;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public void setY(int y) 
	{
		this.y = y;
	}
	
	@Override
	public String toString() 
	{
		return "(" + this.x + "," + this.y + ")";
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;

	}


}
