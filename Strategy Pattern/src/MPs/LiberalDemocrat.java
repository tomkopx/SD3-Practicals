package MPs;

public class LiberalDemocrat extends MP {

	public LiberalDemocrat(String name){
		super(name);
		setTheirBelief(new StupidPublicBelief());
		setTheirHome(new CuckooLand());
	}
}
