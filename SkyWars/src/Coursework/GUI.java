package Coursework;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class GUI {

	private JFrame frame;
	private JTable Grid;
	protected GameLoop gameLoop = GameLoop.getInstance();

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Game Grid
		Grid = new JTable(4,4);
		Grid.setEnabled(false);
		Grid.setBounds(29, 70, 1201, 400);
		Grid.setRowHeight(100);
		frame.getContentPane().add(Grid);

		
		ImageIcon test = new ImageIcon("test.png");	
		Grid.setValueAt(test, 3, 3);
		
		//Will start the game loop class, everything happens here
		gameLoop.InitialiseGame();
		
		//Move button
		final JButton moveButton = new JButton("Move");
		moveButton.setVisible(true);
		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		moveButton.setBounds(571, 586, 150, 50);
		frame.getContentPane().add(moveButton);
		
		//Undo Button
		final JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		final JButton modeButton = new JButton("Change Mode");
		modeButton.setVisible(true);
		modeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(gameLoop.getShip().getMode() instanceof DefensiveMode){
					currentMode.setText("Current Mode : Offensive");
					gameLoop.getShip().setMode(new OffensiveMode());
				}
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
