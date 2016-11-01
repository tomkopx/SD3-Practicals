package Coursework;

public class MasterShip extends Ship {

	protected ShipMode mode;
	
	public MasterShip(int position){
		
		setName("MasterShip");
		setPosition(position);
		setPrev_position(position);
		setMode(new DefensiveMode());
		
	}

	public ShipMode getMode() {
		return mode;
	}


	public void setMode(ShipMode mode) {
		this.mode = mode;
	}
	
	
	
}
