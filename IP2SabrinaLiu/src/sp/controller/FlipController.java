package sp.controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sp.model.Location;
import sp.model.Model;
import sp.model.Tile;
import sp.view.DoubleSlidedApp;
import sp.view.PuzzleView;

public class FlipController extends MouseAdapter {
	Model model;
	DoubleSlidedApp app;

	public FlipController(DoubleSlidedApp app, Model model) {
		this.app = app;
		this.model = model;
	}

	public void mousePressed(MouseEvent me) {
		// make sure has not won
		flipTileToEmpty(me);
		
		// REFRESH DISPLAY
		app.repaint();

	}

	/* method for: figuring out which tile was pressed
				if neighboring the current empty tile + haven't lost
					see if clicked on the current tile (iterator)
						if so, update proper fields and change swap tile's and empty's location
				if have won
				if have lost
	*/
	public void flipTileToEmpty(MouseEvent me) {
		Point p = me.getPoint();
		for (int t = 0; t < 8; t++) {
			Tile tileBeingChecked = model.getTileArrayElement(t);
			// check to see if tileBeingChecked is next to the empty tile and haven't lost yet
			if ((model.neighboringEmpty(tileBeingChecked)) && (!model.hasLost())) {
				// check to see if the rectangle contains point
				int tileX = tileBeingChecked.getLocation().getX();
				int tileY = tileBeingChecked.getLocation().getY();
				Rectangle r = new Rectangle(tileX * 100, tileY * 100, 100, 100);
				if (r.contains(p)) { 
					
					app.updateMovesCounter();
					PuzzleView pv = app.getDrawingPanel();
					int newx = model.getEmpty().getX();
					int newy = model.getEmpty().getY();

					// update empty tile's location
					model.setEmpty(new Location(tileX, tileY));

					// update tile's location with where the empty was
					tileBeingChecked.setLocation(new Location(newx, newy));
					tileBeingChecked.flip();
					model.updateDigitCount(tileBeingChecked.getVisibleDigit());

				}

			} else if (model.hasLost()) {
				app.showLoseLabel();
			} else if (hasWon()) {
				app.showWinLabel();
			}
		}
	}

	// figure out if the right colors+numbers are at the right spots for winning configuration
	// returns true if user has won
	// returns false if user has not won yet
	public boolean hasWon() {

		boolean soFarSoGood = true;
		for (int i = 0; i < 8; i++) {
			Tile tile = model.getTileArrayElement(i);
			Location tLoc = tile.getLocation();
			int x = tLoc.getX();
			int y = tLoc.getY();
			if (soFarSoGood) {
				if ((x == 0)&& (y == 0)) {
					if ((tile.getVisibleDigit() != 1) || (tile.getFlipped() != false)) {
						soFarSoGood = false;
					}
				}
				else if ((x == 0)&& (y == 1)) {
					if ((tile.getVisibleDigit() != 4) || (tile.getFlipped() != true)) {
						soFarSoGood = false;
					}
				}
				else if ((x == 0)&& (y == 2)) {
					if ((tile.getVisibleDigit() != 3) || (tile.getFlipped() != true)) {
						soFarSoGood = false;
					}
				}
				else if ((x == 1)&& (y == 0)) {
					if ((tile.getVisibleDigit() != 2) || (tile.getFlipped() != false)) {
						soFarSoGood = false;
					}
				}
				else if ((x == 1) && (y == 1)) {soFarSoGood = false;}
				else if ((x == 1)&& (y == 2)) {
					if ((tile.getVisibleDigit() != 2) || (tile.getFlipped() != true)) {
						soFarSoGood = false;
					}
				}
				else if ((x == 2)&& (y == 0)) {
					if ((tile.getVisibleDigit() != 3) || (tile.getFlipped() != false)) {
						soFarSoGood = false;
					}
				}
				else if ((x == 2)&& (y == 1)) {
					if ((tile.getVisibleDigit() != 4) || (tile.getFlipped() != false)) {
						soFarSoGood = false;
					}
				}
				else if ((x == 2)&& (y == 2)) {
					if ((tile.getVisibleDigit() != 1) || (tile.getFlipped() != true)) {
						soFarSoGood = false;
					}
				}
			}
		}
		return soFarSoGood;
	}
}
