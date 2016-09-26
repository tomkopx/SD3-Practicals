package UniverseStuff;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Universe u1 = Universe.getInstance("ShitHole");
		Universe u2 = Universe.getInstance("GreatHole");
		String output;
		
		output = "Name of the u1 is: " + u1.getName();
		
		JOptionPane.showMessageDialog(null, output);
		
		output = "Name of the u2 is: " + u2.getName();
		
		JOptionPane.showMessageDialog(null, output);
	}

}
