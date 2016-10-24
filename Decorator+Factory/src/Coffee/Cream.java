package Coffee;

public class Cream extends Additions {

	Coffee coffee;
	
	public Cream(Coffee c){
		setCoffee(c);
	}
	
	
	public double cost() {
		return this.coffee.cost() + 0.75;
	}

	
	public String getDescription() {
		
		return this.coffee.getDescription() + " with cream ";
	}


	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

}
