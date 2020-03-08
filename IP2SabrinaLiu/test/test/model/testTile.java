package test.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import sp.model.Location;
import sp.model.Tile;

public class testTile {

//	@Before
//	public void tileSetup() {
//		Tile test = new Tile(1, 4, false);
//		test.setLocation(new Location(1,2));
//	}
	@Test
	public void testTileSetAndGetLocationX() {
		Tile test = new Tile(1, 4, false);
		test.setLocation(new Location(1,2));
		Location l = test.getLocation();
		int x = l.getX(); //should return tile's column
		assertEquals(x, 1);
	}
	@Test
	public void testTileSetAndGetLocationY() {
		Tile test = new Tile(1, 4, false);
		test.setLocation(new Location(1,2));
		Location l = test.getLocation();
		int y = l.getY(); //should return tile's column
		assertEquals(y, 2);
	}
	@Test
	public void testTileGetVisibleDigit() {
		Tile test = new Tile(1, 4, false);
		assertEquals(1, test.getVisibleDigit());
	}
	@Test
	public void testTileGetFlipped() {
		Tile test = new Tile(1, 4, false);
		assertEquals(false, test.getFlipped());
	}
	@Test
	public void testTileFlipChangesFlipped() {
		Tile test = new Tile(1, 4, false);
		test.flip();
		assertEquals(true, test.getFlipped());
	}
	@Test
	public void testTileFlipChangesVisibleDigit() {
		Tile test = new Tile(1, 4, false);
		test.flip();
		assertEquals(4, test.getVisibleDigit());
	}
}
