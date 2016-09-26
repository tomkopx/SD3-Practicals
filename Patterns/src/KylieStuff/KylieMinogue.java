package KylieStuff;

public class KylieMinogue{
	private static KylieMinogue uniqueInstance;
	private String name;
	
	private KylieMinogue(String name){
		setName(name);
	}

	
	public static synchronized KylieMinogue getInstance(String name) throws CreatingAnotherKylieException{
		if(uniqueInstance == null){
			uniqueInstance = new KylieMinogue(name);
		}
		else{
			throw new CreatingAnotherKylieException(name);
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
