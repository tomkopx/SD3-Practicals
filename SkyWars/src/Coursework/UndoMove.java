package Coursework;

import javax.swing.JTable;

//This class will execute the undo move method
public class UndoMove implements Move {

	protected GameLoop gameLoop = GameLoop.getInstance();
	protected JTable grid;
	
	public UndoMove(JTable grid){
		this.grid = grid;
	}
	
	public void execute() {
		gameLoop.UndoMove(grid);

	}

}
