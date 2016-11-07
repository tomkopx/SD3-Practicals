package Coursework;

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
		
		ship = new MasterShip(2);
		
	}

	public MasterShip getShip() {
		return ship;
	}
	
}
