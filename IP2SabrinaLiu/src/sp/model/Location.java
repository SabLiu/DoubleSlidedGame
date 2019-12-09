package sp.model;

public class Location {
	public final int row; 
	public final int col;
	public Location(int x, int y) {
		this.col = x;		
		this.row = y;
	}
	
	public int getX() {
		return this.col;
	}
	public int getY() {
		return this.row; 
	}
}
