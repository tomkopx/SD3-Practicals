package Coffee;

public class Milk extends Additions {

	Coffee coffee;
	
	public Milk(Coffee c){
		setCoffee(c);
	}
	
	
	public double cost() {
		return this.coffee.cost() + 0.50;
	}

	
	public String getDescription() {
		
		return this.coffee.getDescription() + " with milk ";
	}


	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
	
	

}
