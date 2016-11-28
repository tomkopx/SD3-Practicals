package Coursework;

import javax.swing.JTable;

//Observable interface for observer pattern
public interface Observable {

	public void notifyObservers(Ship ship, JTable grid);
	public void addObservers(GridUpdater observer);
	
}
