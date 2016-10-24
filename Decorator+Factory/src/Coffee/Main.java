package Coffee;

public class Main {

	public static void main(String[] args) {
		
		Coffee c = new Decaf();
		c = new Milk(c);
		
		System.out.println(c.getDescription() + ": £" +c.cost());

	}

}
