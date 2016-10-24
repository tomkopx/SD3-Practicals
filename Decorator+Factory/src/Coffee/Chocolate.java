package Coffee;

public class Chocolate extends Additions {

	Coffee coffee;
	
	public Chocolate(Coffee c){
		setCoffee(c);
	}
	
	
	public double cost() {
		return this.coffee.cost() + 1.0;
	}

	
	public String getDescription() {
		
		return this.coffee.getDescription() + " with chocolate ";
	}


	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

}
