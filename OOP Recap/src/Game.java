import java.util.Random;

import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args) {
		
		String output = "";
		int num;
		Random numGenerator = new Random();
		
		num = numGenerator.nextInt(2);
		
		if(num == 0){
			Ball winner = new WhiteBall();
			output = "The winning ball is: " + winner.getColour();
		}
		else{
			Ball winner = new BlackBall();
			output = "The winning ball is: " + winner.getColour();
		}
		
		
		JOptionPane.showMessageDialog(null, output);
	}
}
