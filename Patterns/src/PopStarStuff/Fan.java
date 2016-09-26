package PopStarStuff;

import javax.swing.JOptionPane;

public class Fan implements Observer, Display {

	private String name;
	String updates;

	
	public Fan(String name){
		setName(name);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public void display() {
		String news = "News for: " + getName() + System.lineSeparator();
		news += this.updates;	
		
		JOptionPane.showMessageDialog(null, news, "", JOptionPane.INFORMATION_MESSAGE);

	}


	public void update(String Update) {
		this.updates = Update;
		display();

	}
	

}
