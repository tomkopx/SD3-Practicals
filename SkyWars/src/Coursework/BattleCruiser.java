package Coursework;

import java.awt.Point;

import javax.swing.ImageIcon;

//One of the enemy ship classes
public class BattleCruiser extends Ship implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BattleCruiser(){
		setName("BattleCruiser");
		setImage(new ImageIcon("src\\Coursework\\BattleCruiser.png"));
		setPosition(new Point(0,0));
		setPrev_position(null);
	}
	
}
