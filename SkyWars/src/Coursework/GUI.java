package Coursework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTable;


public class GUI {

	private JFrame frame;
	protected GameLoop gameLoop = GameLoop.getInstance(); //Creating unique game loop instance
	protected int turns = 0; //Used as score

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	//This creates a jtable that can render images in all cells
	public JTable createGrid(){
        ImageIcon blank = new ImageIcon("Blank.png"); //Blank image used for empty cells

        Object[] columnNames = {blank, blank, blank, blank};
        Object[][] data =
        {
            {blank, blank, blank, blank},
            {blank, blank, blank, blank},
            {blank, blank, blank, blank},
            {blank, blank, blank, blank}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable Grid = new JTable(model)
        {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			//  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class<? extends Object> getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        
        return Grid;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//Game Grid
		final JTable Grid = createGrid();
		Grid.setEnabled(false);
		Grid.setBounds(29, 70, 1201, 480);
		Grid.setRowHeight(120);
		frame.getContentPane().add(Grid);
		
		//Will start the game loop class, everything happens here
		gameLoop.InitialiseGame(Grid);
		
		//Number of enemies text
		final JTextPane numEnemies = new JTextPane();
		numEnemies.setVisible(true);
		numEnemies.setEditable(false);
		numEnemies.setText("Number of enemies: " + gameLoop.getEnemyShips().size());
		numEnemies.setBounds(10, 647, 187, 20);
		frame.getContentPane().add(numEnemies);
		
		//Number of turns surivived
		final JTextPane score = new JTextPane();
		score.setVisible(true);
		score.setEditable(false);
		score.setText("Number of turns survived: " + gameLoop.getEnemyShips().size());
		score.setBounds(400, 647, 200, 20);
		frame.getContentPane().add(score);
		
		//Move button
		final JButton moveButton = new JButton("Move");
		moveButton.setVisible(true);
		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If flag has been changed, don't let user move since they lost
				if(gameLoop.isGameOver() == true){
					JOptionPane.showMessageDialog(null, "You lost, click Undo button if you wanna retry your last move.");
					return;
				}
				
				//Random number for spawn chance
				int randNum = gameLoop.RandInt(1,3);
				//Move player ship first
				gameLoop.MoveShip(gameLoop.getShip(), Grid);
				
				//Then move all the enemy ships
				for(Ship s : gameLoop.getEnemyShips()){
					gameLoop.MoveShip(s, Grid);
				}
				
				
				//1 in 3 chance to spawn enemy
				if(randNum == 3){
					gameLoop.SpawnEnemy(Grid);
				}
				//check if the new square has a loss condition
				gameLoop.CheckForLoss(Grid);
				
				turns++;
				//Updating numbers
				numEnemies.setText("Number of enemies: " + gameLoop.getEnemyShips().size());
				score.setText("Number of turns survived: " + turns);
			}
		});
		moveButton.setBounds(571, 586, 150, 50);
		frame.getContentPane().add(moveButton);
		
		//Undo Button
		final JButton undoButton = new JButton("Undo Last Move");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gameLoop.isUndo() == true){
					JOptionPane.showMessageDialog(null, "Undo unavailable!");
					return;
				}
				//Call in the undo move function from game loop
				gameLoop.UndoMove(Grid);
				turns--;
				//Update numbers
				numEnemies.setText("Number of enemies: " + gameLoop.getEnemyShips().size());
				score.setText("Number of turns survived: " + turns);
			}
		});
		undoButton.setVisible(true);
		undoButton.setBounds(800, 586, 150, 50);
		frame.getContentPane().add(undoButton);
		
		//Current Mode text
		final JTextPane currentMode = new JTextPane();
		currentMode.setVisible(true);
		currentMode.setEditable(false);
		currentMode.setText("Current Mode : Defensive");
		currentMode.setBounds(10, 616, 187, 20);
		frame.getContentPane().add(currentMode);
		
		//This button changes operational mode of the player ship
		final JButton modeButton = new JButton("Change Mode");
		modeButton.setVisible(true);
		modeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If current mode is defensive mode, change to offensive
				if(gameLoop.getShip().getMode() instanceof DefensiveMode){
					currentMode.setText("Current Mode : Offensive");
					gameLoop.getShip().setMode(new OffensiveMode());
				}
				//Otherwise, change offensive mode to defensive
				else{
					currentMode.setText("Current Mode : Defensive");
					gameLoop.getShip().setMode(new DefensiveMode());
				}
				
				gameLoop.getShip().getMode().shipMode();
			}
		});
		modeButton.setBounds(330, 586, 150, 50);
		frame.getContentPane().add(modeButton);
	}
}
