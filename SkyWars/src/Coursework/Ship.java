package Coursework;

import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class Ship {

	protected String name;
	protected Point position;
	protected ImageIcon image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;

	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	
}
