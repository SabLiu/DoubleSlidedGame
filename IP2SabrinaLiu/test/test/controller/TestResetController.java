package test.controller;

import static org.junit.Assert.assertEquals;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import org.junit.Test;

import sp.controller.ResetController;
import sp.model.Location;
import sp.model.Model;
import sp.view.DoubleSlidedApp;

public class TestResetController {

	@Test
	public void didResetWork() {

		Model model = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(model);
		model.getTileArrayElement(5).setLocation(new Location(0,0));
		//now, reset and see what the location of tile5 is
		//original location of tile 5: (2,1)
		ResetController rc = new ResetController(app, model);
		rc.mousePressed(GUITestCase.createPressed(new JButton("Reset"), 200, 100));
		assertEquals(model.getTileArrayElement(5).getLocation().getX(), 2);
	}
}
