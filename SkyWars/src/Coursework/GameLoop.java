package Coursework;

import java.awt.Point;

//Main class that will do all the work
public class GameLoop {

	private static GameLoop uniqueInstance;
	private MasterShip ship;
	
	public static synchronized GameLoop getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new GameLoop();
		}
		return uniqueInstance;
	}
	
	
	public void InitialiseGame(){
		
		Point randCoord = new Point(0,0);
		
		ship = new MasterShip(randCoord);
		
	}

	public MasterShip getShip() {
		return ship;
	}
	
}
