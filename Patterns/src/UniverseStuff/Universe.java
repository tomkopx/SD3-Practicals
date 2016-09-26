package UniverseStuff;

public class Universe {
	private static Universe uniqueInstance;
	private String name;
	
	private Universe(String name){
		setName(name);
	}
	
	public static synchronized Universe getInstance(String name){
		if(uniqueInstance == null){
			uniqueInstance = new Universe(name);
		}
		return uniqueInstance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
