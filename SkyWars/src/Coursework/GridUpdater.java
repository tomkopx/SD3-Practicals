package Coursework;

import javax.swing.JTable;

//This class waits for the gameLoop class to notify it so it can update the grid
public class GridUpdater implements Observer {

	public void updateGrid(Ship ship, JTable grid) {
		
		grid.setValueAt(ship.image, ship.position.y, ship.position.x);

	}

}
