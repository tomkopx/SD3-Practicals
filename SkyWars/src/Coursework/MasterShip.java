package Coursework;

import java.awt.Point;

import javax.swing.ImageIcon;

public class MasterShip extends Ship {

	protected ShipMode mode;
	
	public MasterShip(Point position){
		
		setName("MasterShip");
		setImage(new ImageIcon("src\\Coursework\\MasterShip.png"));
		setPosition(position);
		setMode(new DefensiveMode());
		
	}

	public ShipMode getMode() {
		return mode;
	}


	public void setMode(ShipMode mode) {
		this.mode = mode;
	}
	
	
	
}
