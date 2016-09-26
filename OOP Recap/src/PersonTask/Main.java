package PersonTask;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student("Sarah Cummings", "123456789", "Hairdressing for Dummies");
		Student s2 = new Student("Mark Not", "123456788", "Female Studies");
		
		Staff t1 = new Staff("Harry Onion", "Janitor");

		
		s1.displayPerson();
		s2.displayPerson();
		t1.displayPerson();
	}

}
