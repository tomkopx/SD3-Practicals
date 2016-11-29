package Coursework;

import java.awt.Point;

import javax.swing.ImageIcon;

//One of the enemy ship classes
public class BattleShooter extends Ship implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BattleShooter(){
		setName("BattleShooter");
		setImage(new ImageIcon("src\\Coursework\\BattleShooter.png"));
		setPosition(new Point(0,0));
		setPrev_position(null);
	}
	
}
