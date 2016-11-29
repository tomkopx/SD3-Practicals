package Coursework;

//Defensive mode for the player ship, used in strategy pattern
public class DefensiveMode implements ShipMode, java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void shipMode() {

		System.out.println("I am defending!");
		
	}

}
