package Coursework;

import javax.swing.JTable;

//This class will execute the move method
public class ForwardMove implements Move {

	protected GameLoop gameLoop = GameLoop.getInstance();
	protected JTable grid;
	protected Ship ship;
	
	public ForwardMove(Ship ship, JTable grid){
		this.ship = ship;
		this.grid = grid;
	}
	
	public void execute() {
		gameLoop.MoveShip(ship, grid);
	}

}
