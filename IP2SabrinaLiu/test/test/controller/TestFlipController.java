package test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.MouseEvent;

import org.junit.Test;

import sp.controller.FlipController;
import sp.controller.ResetController;
import sp.model.Location;
import sp.model.Model;
import sp.model.Tile;
import sp.view.DoubleSlidedApp;
import sp.view.PuzzleView;

public class TestFlipController {

	
	@Test
	public void testHasWonFalse() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		assertFalse(fc.hasWon());
	}
	@Test
	public void testHasWonTrue() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		//need to move tiles to winning configuration. 
		//don't need to move tile0
		Tile tile1 = model.getTileArrayElement(1);
		tile1.setLocation(new Location(2,1));
		Tile tile2 = model.getTileArrayElement(2);
		tile2.setLocation(new Location(0,2));
		Tile tile3 = model.getTileArrayElement(3);
		tile3.setLocation(new Location(1,0));
		Tile tile4 = model.getTileArrayElement(4);
		tile4.flip();
		tile4.setLocation(new Location(0,1));
		Tile tile5 = model.getTileArrayElement(5);
		tile5.setLocation(new Location(1,2));
		Tile tile6 = model.getTileArrayElement(6);
		tile6.setLocation(new Location(2,0));
		Tile tile7 = model.getTileArrayElement(7);
		tile7.flip();
		tile7.setLocation(new Location(2,2));
		assertTrue(fc.hasWon());
	}
	@Test
	public void testHasWonNotYet() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		//need to move tiles but not to winning configuration. 
		//don't need to move tile0
		Tile tile1 = model.getTileArrayElement(1);
		tile1.setLocation(new Location(1,2));
		Tile tile2 = model.getTileArrayElement(2);
		tile2.setLocation(new Location(0,2));
		Tile tile3 = model.getTileArrayElement(3);
		tile3.setLocation(new Location(1,0));
		Tile tile4 = model.getTileArrayElement(4);
		tile4.flip();
		tile4.setLocation(new Location(0,1));
		Tile tile5 = model.getTileArrayElement(5);
		tile5.setLocation(new Location(2,1));
		Tile tile6 = model.getTileArrayElement(6);
		tile6.setLocation(new Location(2,0));
		Tile tile7 = model.getTileArrayElement(7);
		tile7.flip();
		tile7.setLocation(new Location(2,2));
		assertFalse(fc.hasWon());
	}
	@Test
	public void testHasWonNotYet2() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		Tile tile0 = model.getTileArrayElement(0);
		tile0.flip();
		Tile tile1 = model.getTileArrayElement(1);
		tile1.setLocation(new Location (0,1));
		Tile tile2 = model.getTileArrayElement(2);
		tile2.setLocation(new Location(0,0));
		Tile tile4 = model.getTileArrayElement(4);
		tile4.flip();
		tile4.setLocation(new Location(0,2));
		Tile tile7 = model.getTileArrayElement(7);
		tile7.flip();
		tile7.setLocation(new Location(2,2));
		assertFalse(fc.hasWon());
	}
	
	@Test
	public void testHasWonNotYet3() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		Tile tile0 = model.getTileArrayElement(0);
		tile0.setLocation(new Location(0,1));
		assertFalse(fc.hasWon());
	}
	
	@Test
	public void testHasWonNotYet4() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		Tile tile0 = model.getTileArrayElement(0);
		tile0.setLocation(new Location(0,2));
		assertFalse(fc.hasWon());
	}
	
	@Test
	public void testHasWonNotYet5() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		Tile tile0 = model.getTileArrayElement(0);
		tile0.setLocation(new Location(2,0));
		assertFalse(fc.hasWon());
	}
	
	@Test
	public void testHasWonNotYet6() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		Tile tile0 = model.getTileArrayElement(0);
		tile0.setLocation(new Location(2,1));
		assertFalse(fc.hasWon());
	}
	
	@Test
	public void testHasWonNotYet7() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		Tile tile0 = model.getTileArrayElement(0);
		tile0.setLocation(new Location(2,2));
		assertFalse(fc.hasWon());
	}
	
	@Test
	public void testHasLost() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		//flip 2 tiles to make losing configuration
		Tile tile1 = model.getTileArrayElement(1);
		tile1.flip();
		model.updateDigitCount(1);
		Tile tile7 = model.getTileArrayElement(7);
		tile7.flip();
		model.updateDigitCount(1);
		assertTrue(model.hasLost());
	}
	
	
	
	@Test
	public void testFlipTileToEmptyCorrectLocation() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		fc.mousePressed(GUITestCase.createPressed(new PuzzleView(model), 200, 100));
		assertEquals(model.getTileArrayElement(5).getLocation().getY(), 2);
	}
	
	@Test
	public void testFlipTileToEmptyCorrectColor() {
		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		FlipController fc = new FlipController(app, model);
		fc.flipTileToEmpty(GUITestCase.createPressed(new PuzzleView(model), 200, 100));
		assertFalse(model.getTileArrayElement(5).getFlipped());
	}

	

	}

