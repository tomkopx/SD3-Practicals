package Coursework;

import java.awt.Point;

import javax.swing.ImageIcon;

//Player ship class
public class MasterShip extends Ship implements java.io.Serializable {

	protected ShipMode mode;
	
	public MasterShip(Point position){
		
		setName("MasterShip");
		setImage(new ImageIcon("src\\Coursework\\MasterShip.png"));
		setPosition(position);
		setPrev_position(null);
		setMode(new DefensiveMode());
		
	}

	public ShipMode getMode() {
		return mode;
	}


	public void setMode(ShipMode mode) {
		this.mode = mode;
	}
	
	
	
}
