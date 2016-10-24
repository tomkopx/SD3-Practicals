package Coursework;

public class MasterShip extends Ship {

	protected int mode;
	
	public MasterShip(int position){
		
		setName("MasterShip");
		setPosition(position);
		setPrev_position(position);
		setMode(0);
		
	}

	public int getMode() {
		return mode;
	}


	public void setMode(int mode) {
		this.mode = mode;
	}
	
	
	
}
