package sp.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sp.model.Model;
import sp.view.DoubleSlidedApp;

public class ResetController extends MouseAdapter {
	DoubleSlidedApp app;
	Model model;
	public ResetController (DoubleSlidedApp app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void mousePressed(MouseEvent me) {
		//resets the tiles
		model.reset();
		//resets the labels and move counter
		app.reset();
		app.repaint();
	}
}
