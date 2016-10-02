package MPs;

public class GreenParty extends MP {
	
	public GreenParty(String name){
		super(name);
		setTheirBelief(new EcoBelief());
		setTheirHome(new TreeHouse());
	}
}
