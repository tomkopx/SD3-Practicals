package Coursework;

import javax.swing.JTable;

//Observer interface for the observer pattern
public interface Observer {

	public void updateGrid(Ship ship, JTable grid);
}
