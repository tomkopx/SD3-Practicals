package Coursework;


//TEST CLASS REMOVE LATER
public class Main {

	public static void main(String[] args) {
		
		MasterShip ship = new MasterShip(1);
		
		ship.getMode().shipMode();
		
		ShipMode mode = new OffensiveMode();
		
		ship.setMode(mode);
		
		ship.getMode().shipMode();

	}

}
