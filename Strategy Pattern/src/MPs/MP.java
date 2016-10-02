package MPs;

public abstract class MP {

	private String Name;
	
	protected Belief theirBelief;
	protected Home theirHome;
	
	
	protected MP(String name){
		setName(name);
	}
	
	public void sayBelief(){
		this.theirBelief.belief();
	}
	
	public void sayHome(){
		this.theirHome.home();
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public Belief getTheirBelief() {
		return theirBelief;
	}
	
	public void setTheirBelief(Belief theirBelief) {
		this.theirBelief = theirBelief;
	}
	
	public Home getTheirHome() {
		return theirHome;
	}
	
	public void setTheirHome(Home theirHome) {
		this.theirHome = theirHome;
	}
}
