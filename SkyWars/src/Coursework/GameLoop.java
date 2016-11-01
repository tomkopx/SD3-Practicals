package Coursework;

//Main class that will do all the work
public class GameLoop {

	private static GameLoop uniqueInstance;
	
	public static synchronized GameLoop getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new GameLoop();
		}
		return uniqueInstance;
	}
	
	
	public void InitialiseGame(){
		
		MasterShip ship = new MasterShip(2);
		
	}
	
	
}
