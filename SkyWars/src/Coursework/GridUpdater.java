package Coursework;

import javax.swing.JTable;

public class GridUpdater implements Observer {

	public void updateGrid(Ship ship, JTable grid) {
		
		grid.setValueAt(ship.image, ship.position.y, ship.position.x);

	}

}
