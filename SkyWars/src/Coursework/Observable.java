package Coursework;

import javax.swing.JTable;

public interface Observable {

	public void notifyObservers(Ship ship, JTable grid);
	
}
