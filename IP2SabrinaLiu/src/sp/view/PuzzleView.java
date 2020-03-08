package sp.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import sp.model.Model;
import sp.model.Tile;
import sp.model.Location;

public class PuzzleView extends JPanel {
	Model model;

	public PuzzleView(Model model) {
		this.model = model;
	}


	@Override
	public void paintComponent(Graphics g) {
		if (model == null) { return ; }
		
		g.setFont(new Font("Calibri", Font.BOLD, 60));
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		for (int t = 0; t < 8; t++) {
			Tile tile = model.getTileArrayElement(t);
			int dig = tile.getVisibleDigit();
			Location loc = tile.getLocation();
			// translate loc row column to x and y coordinates
			int x = (loc.getX() *100 + 5); 
			int y = (loc.getY() * 100) + 5;
			if (tile.getFlipped() == false) {
				// tile color is gray, text color is black
				drawTile(g, Color.gray, x, y);
				g.setColor(Color.black);
				g.drawString(" " + dig, x + 25, y + 75);
			} else {
				// tile color is black, text color is white
				drawTile(g, Color.black, x, y);
				g.setColor(Color.white);
				g.drawString(" " + dig, x + 25, y + 75);
			}
 
			// draw all tile outlines
			g.setColor(Color.DARK_GRAY);
			g.drawRect(x, y, 100, 100);
			// draw outline around empty tile
			g.drawRect(model.getEmpty().getX() * 100 + 5, model.getEmpty().getY() * 100 + 5, 100, 100);

		}
		// draw a different rectangle at the empty location
		g.setColor(Color.orange);
		g.fillRect(model.getEmpty().getX() * 100 + 8, model.getEmpty().getY() * 100 + 8, 95, 95);

	}

	public void drawTile(Graphics g, Color tileColor, int x, int y) {
		g.setColor(tileColor);
		g.fillRect(x, y, 100, 100);
	}

}
