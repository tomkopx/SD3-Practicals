package Coursework;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

//Main class that will do all the work
public class GameLoop {

	private static GameLoop uniqueInstance;
	private MasterShip ship;
	private ArrayList<Ship> enemyShips = new ArrayList<Ship>();
	private ArrayList<Ship> undoShips = new ArrayList<Ship>(); //This array list is used to bring back removed ships when undo button is used
	
	public static synchronized GameLoop getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new GameLoop();
		}
		return uniqueInstance;
	}
	
	//Function used to get the random numbers used in ship generation, moving the ships etc.
	public int RandInt(int min, int max) {

	    Random rand = new Random();

	    //This will make sure that the max number will be included in the randomisation
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	//Function that will find all possible moves and add them to array list
	public ArrayList<Point> FindPossibleMoves(int x, int y){
		
		ArrayList<Point> possible = new ArrayList<Point>();
		
		//North
		if(y - 1 >= 0){
			possible.add(new Point(x, y - 1));
		}
		
		//North-East
		if(x + 1 < 4 && y - 1 >= 0){
			possible.add(new Point(x + 1, y - 1));
		}
		
		//East
		if(x + 1 < 4){
			possible.add(new Point(x + 1, y));
		}
		//South-East
		if(x + 1 < 4 && y + 1 < 4){
			possible.add(new Point(x + 1, y + 1));
		}
		//South
		if(y + 1 < 4){
			possible.add(new Point(x, y + 1));
		}
		//South-West
		if(x - 1 >= 0 && y + 1 < 4){
			possible.add(new Point(x - 1, y + 1));
		}
		//West
		if(x - 1 >= 0){
			possible.add(new Point(x - 1, y));
		}
		//North-West
		if(x - 1 >= 0 && y - 1 >= 0){
			possible.add(new Point(x - 1, y - 1));
		}
		return possible;
	}
	
	//This will initialise all the things the game requires
	public void InitialiseGame(JTable grid){
		
		//This will spawn the player ship at a random location
		Point randCoord = new Point(RandInt(0,3), RandInt(0,3));
		
		//If it ever does spawn at 0,0 just move it by 1 on the x axis
		if(randCoord.getX() == 0 && randCoord.getY() == 0){
			randCoord.x++;
		}
		
		ship = new MasterShip(randCoord);
		
		//render player ship on start location
		grid.setValueAt(ship.image, ship.position.y, ship.position.x);
		
	}
	
	//Function to move all ships
	public void MoveShip(Ship ship, JTable grid){
		int x = ship.position.x;
		int y = ship.position.y;
		//ArrayList of possible moves the skip can make
		ArrayList<Point> possible = FindPossibleMoves(x, y);
		//Find random index value to pick a move from possible moves
		int randomPos = RandInt(0, possible.size()-1);
		
		//Remove the ship image from its previous location
		grid.setValueAt(new ImageIcon("Blank.png"), ship.position.y, ship.position.x);
		
		ship.setPosition(possible.get(randomPos));
		
		//Render player ship on new position
		grid.setValueAt(ship.image, ship.position.y, ship.position.x);
		
	}
	
	//Function to spawn enemy ships
	public void SpawnEnemy(JTable grid){
		EnemyFactory factory = new EnemyFactory();
		int randNum = RandInt(0,2);
		
		Ship ship = factory.spawnShip(randNum);
		
		grid.setValueAt(ship.image, ship.position.y, ship.position.x);
		
		enemyShips.add(ship);
		
	}
	
	public void CheckForLoss(JTable grid){
		
		int shipLimit = 2;
		int shipNum = 0;
		
		//This will change the ship limit depending on the mode player ship is using
		if(ship.mode instanceof DefensiveMode){
			shipLimit = 2;
		}
		else if (ship.mode instanceof OffensiveMode){
			shipLimit = 3;
		}
		
		for(Ship s : enemyShips){
			if(s.position.getX() == ship.position.getX() && s.position.getY() == ship.position.getY()){
				shipNum++;
				undoShips.add(s);
			}
		}
		//If the number of ships is bigger or equal than the limit allowed, the player loses and application shuts down.
		if(shipNum >= shipLimit){
			JOptionPane.showMessageDialog(null, "You got rekt kid!");
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.exit(0);
		}
		//If number of ships is lower than the limit, the enemy ships are removed from the game
		else{
			for(Ship s : undoShips){
				if(enemyShips.contains(s)){
					enemyShips.remove(s);
				}
			}
			//This will make sure player ship is rendered after enemies are destroyed
			grid.setValueAt(ship.image, ship.position.y, ship.position.x);
		}
	}

	
	public void UndoMove(){
		
	}
	
	public MasterShip getShip() {
		return ship;
	}

	public ArrayList<Ship> getEnemyShips() {
		return enemyShips;
	}

	public ArrayList<Ship> getUndoShips() {
		return undoShips;
	}

	
}
