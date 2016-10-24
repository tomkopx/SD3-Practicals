package Coffee;

public abstract class Coffee {
	
	private String description;
	
	public Coffee(){
		
	}
	
	public abstract double cost();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
