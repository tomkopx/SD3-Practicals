package MPs;

public class Main {

	public static void main(String[] args) {
		
		Conservative c = new Conservative("John Basic");
		Labour l = new Labour("Hannah Modern");
		LiberalDemocrat lb = new LiberalDemocrat("Max Gurg");
		GreenParty gp = new GreenParty("Tree Man");
		
		c.sayBelief();
		c.sayHome();
		
		l.sayBelief();
		l.sayHome();
		
		lb.sayBelief();
		lb.sayHome();
		
		gp.sayBelief();
		gp.sayHome();

	}

}
