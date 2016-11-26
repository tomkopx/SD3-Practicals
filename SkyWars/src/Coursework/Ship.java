package Coursework;

import java.awt.Point;

public abstract class Ship {

	protected String name;
	protected Point position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(int x, int y) {
		this.position.x = x;
		this.position.y = y;
	}
	
}
