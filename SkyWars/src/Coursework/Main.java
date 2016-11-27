package Coursework;

import java.awt.Point;

//TEST CLASS REMOVE LATER
public class Main {

	public static void main(String[] args) {
		
		MasterShip ship = new MasterShip(new Point(0,0));
		
		ship.getMode().shipMode();
		
		ShipMode mode = new OffensiveMode();
		
		ship.setMode(mode);
		
		ship.getMode().shipMode();

	}

}
