package Coursework;

//Offensive mode for player ship, used in strategy pattern
public class OffensiveMode implements ShipMode, java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void shipMode() {
		
		System.out.println("I am attacking!");

	}

}

