package MPs;

public class Labour extends MP {

	public Labour(String name){
		super(name);
		setTheirBelief(new JobEqualityBelief());
		setTheirHome(new ModestHouse());
	}
}
