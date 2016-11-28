package Coursework;

//Defensive mode for the player ship, used in strategy pattern
public class DefensiveMode implements ShipMode, java.io.Serializable {


	public void shipMode() {

		System.out.println("I am defending!");
		
	}

}
