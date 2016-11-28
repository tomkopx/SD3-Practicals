package Coursework;

import java.awt.Point;

import javax.swing.ImageIcon;

//Abstract class for all the ships used
public abstract class Ship implements java.io.Serializable {

	protected String name;
	protected Point position;
	protected Point prev_position;
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

	public Point getPrev_position() {
		return prev_position;
	}

	public void setPrev_position(Point prev_position) {
		this.prev_position = prev_position;
	}
	
	
	
	
}
