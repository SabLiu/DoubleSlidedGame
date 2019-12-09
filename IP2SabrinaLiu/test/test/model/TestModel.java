package test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sp.model.Location;
import sp.model.Model;
import sp.model.Tile;

public class TestModel {

	
	@Test
	public void testGetElementFlipped() {
		Model model = new Model();
		Tile modelTile = model.getTileArrayElement(3);
		//3rd element should be tile: 
		Tile tile3 = new Tile(2,3,false);
		assertEquals(tile3.getFlipped(), modelTile.getFlipped());
	}
	@Test
	public void testGetElementDigit() {
		Model model = new Model();
		Tile modelTile = model.getTileArrayElement(3);
		//3rd element should be tile: 
		Tile tile3 = new Tile(2,3,false);
		assertEquals(tile3.getVisibleDigit(), modelTile.getVisibleDigit());
	}
	@Test
	public void testGetElementLocation() {
		Model model = new Model();
		Tile modelTile = model.getTileArrayElement(3);
		//3rd element should be tile: 
		Tile tile3 = new Tile(2,3,false);
		tile3.setLocation(new Location(0,1));
		assertEquals(tile3.getLocation().getX(), modelTile.getLocation().getX());
	}
	@Test
	public void testGetEmpty() {
		Model model = new Model();
		//empty tile is always at (2,2)
		assertEquals(model.getEmpty().getX(), 2);
	}
	@Test 
	public void testSetEmpty() {
		Model model = new Model();
		model.setEmpty(new Location(2,1));
		assertEquals(model.getEmpty().getY(), 1);
	}
	@Test 
	public void testNeighboringEmptyTileTrue () {
		Model model = new Model();
		Tile neighboringTile = new Tile (1, 4, false);
		//default empty location is (2, 2)
		neighboringTile.setLocation(new Location(2,1));
		assertTrue(model.neighboringEmpty(neighboringTile));
	}
	@Test 
	public void testNeighboringEmptyTileFalse () {
		Model model = new Model();
		Tile notNeighboringTile = new Tile (1, 4, false);
		//default empty location is (2, 2)
		notNeighboringTile.setLocation(new Location(0,0));
		assertFalse(model.neighboringEmpty(notNeighboringTile));
	}
	@Test
	public void testUpdateDigitCountAndHasLost() {
		Model model = new Model();
		model.updateDigitCount(1);
		model.updateDigitCount(1);
		assertTrue(model.hasLost());
	}
	@Test
	public void testUpdateDigitCountAndHasLostNum4() {
		Model model = new Model();
		model.updateDigitCount(4);
		model.updateDigitCount(4);
		assertTrue(model.hasLost());
	}
	@Test
	public void testUpdateDigitCountAndHasNotLost() {
		Model model = new Model();
		model.updateDigitCount(2);
		assertFalse(model.hasLost());
	}
	@Test
	public void testUpdateDigitCountAndHasNotLost2() {
		Model model = new Model();
		model.updateDigitCount(3);
		assertFalse(model.hasLost());
	}
}
