package Coursework;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

//Main class that will do all the work
public class GameLoop implements Observable {

	private static GameLoop uniqueInstance; 
	private ArrayList<GridUpdater> updater = new ArrayList<GridUpdater>(); //Observer item
	private MasterShip ship;
	private EnemyFactory factory = new EnemyFactory();
	private ArrayList<Ship> enemyShips = new ArrayList<Ship>(); //This array list stores enemy ships currently in the grid
	private ArrayList<Ship> undoShips = new ArrayList<Ship>(); //This array list is used to bring back removed ships when undo button is used
	private boolean gameOver = false; //Used for button availability
	private boolean undo = true;
	protected Thread t;
	
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
		//Using factory pattern to spawn player ship
		ship = (MasterShip)factory.spawnShip(3, randCoord);
		
		//render player ship on start location
		grid.setValueAt(ship.image, ship.position.y, ship.position.x);
		
	}
	
	//Function to move all ships
	public void MoveShip(Ship ship, JTable grid){
		
		int x = ship.position.x;
		int y = ship.position.y;
		undo = false;
		//Used for undo
		ship.setPrev_position(new Point(x,y));
		
		//ArrayList of possible moves the skip can make
		ArrayList<Point> possible = FindPossibleMoves(x, y);
		//Find random index value to pick a move from possible moves
		int randomPos = RandInt(0, possible.size()-1);
		
		//Remove the ship image from its previous location
		grid.setValueAt(new ImageIcon("Blank.png"), ship.position.y, ship.position.x);
		
		ship.setPosition(possible.get(randomPos));
		
		//Notify grid updater that a move has been made by a ship
		notifyObservers(ship, grid);
		
		
		
	}
	
	//Function to spawn enemy ships
	public void SpawnEnemy(JTable grid){
		int randNum = RandInt(0,2);
		
		Ship ship = factory.spawnShip(randNum, new Point(0,0));
		
		grid.setValueAt(ship.image, ship.position.y, ship.position.x);
		
		enemyShips.add(ship);
		
	}
	
	//This function is called at end of everyones movement to see whether or not the player ship survived
	public void CheckForLoss(JTable grid){
		
		undoShips.clear();
		
		int shipLimit = 2;
		int shipNum = 0;
		
		//This will change the ship limit depending on the mode player ship is using
		if(ship.mode instanceof DefensiveMode){
			shipLimit = 2;
		}
		else if (ship.mode instanceof OffensiveMode){
			shipLimit = 3;
		}
		//Checking how many ships were in conflict with player, then adding them to backup list
		for(Ship s : enemyShips){
			if(s.position.getX() == ship.position.getX() && s.position.getY() == ship.position.getY()){
				shipNum++;
				undoShips.add(s);
			}
		}
		//If the number of ships is bigger or equal than the limit allowed, the player loses and application shuts down.
		if(shipNum >= shipLimit){
			JOptionPane.showMessageDialog(null, "You got rekt kid!");
			
			gameOver = true;
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

	//Undo move function
	public void UndoMove(JTable grid){
		
		gameOver = false;
		
		//This is to add any ships that were destroyed in previous turn to the current enemy ship list
		if(!undoShips.isEmpty()){
			for(Ship s : undoShips){
				enemyShips.add(s);
			}
			
			undoShips.clear();
		}	
		
		//Display and change current position of player ship to previous position
		grid.setValueAt(new ImageIcon("Blank.png"), ship.position.y, ship.position.x);
		ship.setPosition(ship.getPrev_position());
		//Notify grid updater
		notifyObservers(ship, grid);
		
		undo = true;
		
		for(Ship s : enemyShips){
			
			//This is just in case an enemy ship just spawned, it will be removed from enemy ship list and spot 0,0 will be cleared
			if(s.getPrev_position() == null){
				grid.setValueAt(new ImageIcon("Blank.png"), s.position.y, s.position.x);
				enemyShips.remove(s);
				return;
			}
			
			//Display and change current position of enemy ship to previous position
			grid.setValueAt(new ImageIcon("Blank.png"), s.position.y, s.position.x);
			s.setPosition(s.getPrev_position());
			//Notify grid updater
			notifyObservers(s, grid);
			
		}
	}
	
	//Notify the observers
	public void notifyObservers(Ship ship, JTable grid) {
		addObservers(new GridUpdater());
		
		for(GridUpdater u : updater){
			u.updateGrid(ship, grid);
		}	
	}
	
	//Add any new observers
	public void addObservers(GridUpdater observer){
		updater.add(observer);
	}
	
	public MasterShip getShip() {
		return ship;
	}

	public EnemyFactory getFactory() {
		return factory;
	}

	public ArrayList<Ship> getEnemyShips() {
		return enemyShips;
	}

	public ArrayList<Ship> getUndoShips() {
		return undoShips;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isGameOver() {
		return gameOver;
	}
	
	public void setUndo(boolean undo) {
		this.undo = undo;
	}

	public boolean isUndo() {
		return undo;
	}

	public ArrayList<GridUpdater> getUpdater() {
		return updater;
	}

	public void setUpdater(ArrayList<GridUpdater> updater) {
		this.updater = updater;
	}

	


	
	

}
