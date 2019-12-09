package sp.model;

public class Model {
	Tile[] tileArray;
	Location empty;
	
	//to make sure not more than 4 instances of each digit are visible simultaneously
	int num1 = 2;
	int num2 = 2;
	int num3 = 2;
	int num4 = 2;
	
	public Model() {
		reset();
	}
	
	
 
	public Tile getTileArrayElement(int index) {
		return tileArray[index];
	}
	
	// if the sum of absolute values of (delta between (tileRow - emptyRow) + delta between (tileCol - emptyCol) ) < 1
	// then tile is neighboring empty tile
	public boolean neighboringEmpty(Tile t) {
		int delta = 0;
		delta = (java.lang.Math.abs(t.location.row - getEmpty().row)) + (java.lang.Math.abs(t.location.col - getEmpty().col));
		if (delta > 1) {return false;} else {return true;}
	}

	public Location getEmpty() {
		return empty;
	}
	
	public void setEmpty(Location newLoc) {
		this.empty = newLoc;
	}
	
	//update the counts properly depending on numbers on flipped tile
	public void updateDigitCount(int newlyVisible) {
		if (newlyVisible == 1) {
			num1++;
			num4--;
		}
		else if (newlyVisible == 2) {
			num2++;
			num3--;
		}
		else if (newlyVisible == 3) {
			num3++;
			num2--;
		}
		else {
			num4++;
			num1--;
		}
	}
	
	public boolean hasLost() {
		//check if any are more than 3. 
		//return true if lost
		if ((num1 > 3)||(num2 > 3)||(num3 > 3)||(num4 > 3)) {
			return true; 
		}
		else {return false;}
	}
	
	//use at constructor and to reset to starting state of system
	// initializes num1-4 and creates tileArray with tiles and set locations
	public void reset() {
		Location empty = new Location(2, 2);
		this.empty = empty;
		
		this.num1 = 2;
		this.num2 = 2;
		this.num3 = 2;
		this.num4 = 2;
		
		
		// flipped: gray color, "up" is visible
		// not flipped: black tile, "down" is visible
		Tile tile0 = new Tile(1, 4, false);
		Tile tile1 = new Tile(4, 1, false);
		Tile tile2 = new Tile(2, 3, true);
		Tile tile3 = new Tile(2, 3, false);
		Tile tile4 = new Tile(1, 4, false);
		Tile tile5 = new Tile(3, 2, true);
		Tile tile6 = new Tile(3, 2, false);
		Tile tile7 = new Tile(4, 1, false);

		this.tileArray = new Tile[] {tile0, tile1, tile2, tile3, tile4, tile5, tile6, tile7};
		
		tileArray[0].setLocation(new Location(0, 0));
		tileArray[1].setLocation(new Location(1, 0));
		tileArray[2].setLocation(new Location(2, 0));
		tileArray[3].setLocation(new Location(0, 1));
		tileArray[4].setLocation(new Location(1, 1));
		tileArray[5].setLocation(new Location(2, 1));
		tileArray[6].setLocation(new Location(0, 2));
		tileArray[7].setLocation(new Location(1, 2));
		
	}

}
