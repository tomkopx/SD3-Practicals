package PersonTask;

import javax.swing.JOptionPane;

public abstract class Person {
	private String name;

	public Person(String name){
		setName(name);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void displayPerson(){
		String output = "Name: " + this.name;
		JOptionPane.showMessageDialog(null, output);
	}
	
	
}
