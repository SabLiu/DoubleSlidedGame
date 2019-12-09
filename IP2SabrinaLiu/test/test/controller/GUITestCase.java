package test.controller;
import java.awt.Component;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;

public abstract class GUITestCase extends TestCase {
	public static MouseEvent createPressed(Component component, int x, int y) {
			return new MouseEvent(component, MouseEvent.MOUSE_PRESSED,
					System.currentTimeMillis(), 0,x,y, 0, false);
			
		}
}
