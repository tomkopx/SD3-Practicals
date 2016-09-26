package PersonTask;

import javax.swing.JOptionPane;

public class Student extends Person{

	private String ID;
	private String course;
	
	public Student(String name, String ID, String course) {
		super(name);
		setID(ID);
		setCourse(course);
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public void displayPerson(){
		String output = "Name: " + super.getName() + System.lineSeparator() + "ID: " + getID() + System.lineSeparator() + "Course: " + getCourse();
		JOptionPane.showMessageDialog(null, output);
	}
	
}
