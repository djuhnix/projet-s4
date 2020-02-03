
public class Position {
	  private int x, y;
	  
	  public Position(int x, int y) 
	  {    
		  this.x = x;
		  this.y = y;  
	  }
	  public void Positio(String g) 
	  {    
		  this.x = g.x;
		  this.y = g.y;  
	  }
	  @Override  
	  public boolean equals(Object o) 
	  {    
		  if (this == o)      
			  return true;    
		  if (o == null || getClass() != o.getClass())      
			  return false;    
		  Position position = (Position) o;
		  if (x != position.x)      
			  return false;    
		  return y == position.y;  
	  }
	  public int getX() 
	  {
		  return this.x;
	  }
	  public int getY() 
	  {
		  return this.Y;
	  }
}
