package ITProblems;



public class Main {

	public static void main(String[] args) {
		Technician tech = new Technician();
		ITDepartment it = new ITDepartment();
		
		TechnicalIssue firstIssue = new ComputerOnFire(tech);
		TechnicalIssue secondIssue = new WindowsExplorerBroken(tech);
		
		
		it.recieveIssue(firstIssue);
		it.recieveIssue(secondIssue);
		it.recieveIssue(firstIssue);
		it.recieveIssue(firstIssue);

		it.sendToTechnician();
	}

}
