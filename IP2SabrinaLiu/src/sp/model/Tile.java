package sp.model;

import java.awt.Rectangle;

public class Tile {
	
	final int up;
	final int down;
	boolean flipped;
	Location location;
	
	public Tile (int up, int down, boolean flipped) {
		this.up = up;
		this.down = down; 
		this.flipped = flipped;
	}
	
	public void setLocation (Location loc) {
		location = loc;
	}
	public Location getLocation() {return location;}
	
	public int getVisibleDigit() {
		if (!flipped) { return up; } else {return down;}
	}
	
	public void flip() {
		flipped = !flipped; 
	}

	// flipped: gray color, "up" is visible
	// not flipped: black tile, "down" is visible
	public boolean getFlipped() { return this.flipped;}
}
