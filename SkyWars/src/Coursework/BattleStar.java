package Coursework;

import java.awt.Point;

import javax.swing.ImageIcon;

//One of the enemy ship classes
public class BattleStar extends Ship implements java.io.Serializable {

	public BattleStar(){
		setName("BattleStar");
		setImage(new ImageIcon("src\\Coursework\\BattleStar.png"));
		setPosition(new Point(0,0));
		setPrev_position(null);
	}
	
}
