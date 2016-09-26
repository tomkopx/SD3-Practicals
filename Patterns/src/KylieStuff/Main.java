package KylieStuff;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String output;
		
		try{
			KylieMinogue k1 = KylieMinogue.getInstance("Winner");
			//KylieMinogue k2 = KylieMinogue.getInstance("Loser");
			
			output = "Name of k1 is: " + k1.getName();
			
			JOptionPane.showMessageDialog(null, output);
			
			//output = "Name of the k2 is: " + k2.getName();
			
			//JOptionPane.showMessageDialog(null, output);
			
		}catch(CreatingAnotherKylieException e){
			System.out.println("Another KylieMinogue already exists! Returning existing object.");
			e.printStackTrace();
		}
	}

}
