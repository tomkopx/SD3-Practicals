package Coursework;

public class EnemyFactory {

	public Ship spawnShip(int n){
		
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
		default:
			System.out.println("Error generating ship! Invalid number of enemy ship.");
		}
		
		return ship;
	}
	
}
