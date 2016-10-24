package Policies;

public abstract class Policy {
	
	protected String description;
	
	public void announceWinner(){
		System.out.println("The winner is " + getDescription());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
