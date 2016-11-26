package Coursework;

import java.awt.Point;

public class MasterShip extends Ship {

	protected ShipMode mode;
	
	public MasterShip(Point position){
		
		setName("MasterShip");
		setPosition(position.x, position.y);
		setMode(new DefensiveMode());
		
	}

	public ShipMode getMode() {
		return mode;
	}


	public void setMode(ShipMode mode) {
		this.mode = mode;
	}
	
	
	
}
