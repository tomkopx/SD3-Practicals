package Coursework;

import java.awt.Point;

import javax.swing.ImageIcon;

//One of the enemy ship classes
public class BattleShooter extends Ship {

	public BattleShooter(){
		setName("BattleShooter");
		setImage(new ImageIcon("src\\Coursework\\BattleShooter.png"));
		setPosition(new Point(0,0));
		setPrev_position(null);
	}
	
}
