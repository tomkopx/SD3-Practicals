package Coffee;

public class Syrup extends Additions {
	
	Coffee coffee;
	
	public Syrup(Coffee c){
		setCoffee(c);
	}
	
	
	public double cost() {
		return this.coffee.cost() + 1.25;
	}

	
	public String getDescription() {
		
		return this.coffee.getDescription() + " with syrup ";
	}


	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
}
