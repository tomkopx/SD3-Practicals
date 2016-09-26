package PopStarStuff;

public class Main {

	public static void main(String[] args) {
		PopStar p = new PopStar("Tycho");
		Fan f1 = new Fan("Jerry");
		Fan f2 = new Fan("Max");
		
		
		p.setUpdate("New Album coming out soon!");
		
		p.addFan(f1);
		p.addFan(f2);
		
		p.notifyFans();
		

	}

}
