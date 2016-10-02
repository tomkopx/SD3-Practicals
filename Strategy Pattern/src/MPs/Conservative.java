package MPs;

public class Conservative extends MP {
	
	public Conservative(String name){
		super(name);
		setTheirBelief(new EgoBelief());
		setTheirHome(new DetachedHouse());
	}

}
