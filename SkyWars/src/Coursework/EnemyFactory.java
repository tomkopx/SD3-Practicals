package Coursework;

import java.awt.Point;


//This class is used to decide which enemy ship to spawn, factory pattern
public class EnemyFactory implements java.io.Serializable {

	public Ship spawnShip(int n, Point startCoord){
		
		Ship ship = null;
		
		switch(n){
		
		case 0:
			ship = new BattleStar();
			break;
		case 1:
			ship = new BattleCruiser();
			break;
		case 2:
			ship = new BattleShooter();
			break;
		case 3:
			ship = new MasterShip(startCoord);
			break;
		default:
			System.out.println("Error generating ship! Invalid number of enemy ship.");
		}
		
		return ship;
	}
	
}
