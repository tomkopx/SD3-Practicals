package KylieStuff;

public class CreatingAnotherKylieException extends Exception{

	private String name;

	public CreatingAnotherKylieException(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	private static final long serialVersionUID = 1L;

}
