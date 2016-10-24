package Policies;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		PolicyGame game = new PolicyGame();
		int num;
		
		Random numGenerator = new Random();

		num = numGenerator.nextInt(5);
		
		game.playGame(num);
	}

}
