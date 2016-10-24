package Coursework;

public abstract class Ship {

	protected String name;
	protected int position;
	protected int prev_position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPrev_position() {
		return prev_position;
	}

	public void setPrev_position(int prev_position) {
		this.prev_position = prev_position;
	}
	
	
}
