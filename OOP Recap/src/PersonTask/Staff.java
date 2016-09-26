package PersonTask;

import javax.swing.JOptionPane;

public class Staff extends Person{

	private String job;
	
	
	public Staff(String name, String job) {
		super(name);
		setJob(job);
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}

	public void displayPerson(){
		String output = "Name: " + super.getName() + System.lineSeparator() + "Job: " + getJob();
		JOptionPane.showMessageDialog(null, output);
	}
	
}
