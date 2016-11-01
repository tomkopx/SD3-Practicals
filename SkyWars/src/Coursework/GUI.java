package Coursework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class GUI {

	private JFrame frame;
	private JTable Grid;

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
		
		//Move button
		final JButton moveButton = new JButton("Move");
		moveButton.setVisible(false);
		moveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		moveButton.setBounds(571, 586, 150, 50);
		frame.getContentPane().add(moveButton);
		
		//Undo Button
		final JButton undoButton = new JButton("Undo");
		undoButton.setVisible(false);
		undoButton.setBounds(800, 586, 150, 50);
		frame.getContentPane().add(undoButton);
		
		final JButton modeButton = new JButton("Change Mode");
		modeButton.setVisible(false);
		modeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		modeButton.setBounds(330, 586, 150, 50);
		frame.getContentPane().add(modeButton);
		
		//Current Mode text
		final JTextPane currentMode = new JTextPane();
		currentMode.setVisible(false);
		currentMode.setEditable(false);
		currentMode.setText("Current Mode : Defensive");
		currentMode.setBounds(10, 616, 187, 20);
		frame.getContentPane().add(currentMode);
		
		//Start Button
		final JButton startButton = new JButton("START");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startButton.setVisible(false);
				GameLoop game = GameLoop.getInstance();
				
				game.InitialiseGame();
				
				moveButton.setVisible(true);
				undoButton.setVisible(true);
				modeButton.setVisible(true);
				currentMode.setVisible(true);
			}
		});
		startButton.setBounds(490, 530, 300, 80);
		frame.getContentPane().add(startButton);
		
		Grid = new JTable();
		Grid.setBounds(277, 272, 239, -167);
		frame.getContentPane().add(Grid);
	}
}
