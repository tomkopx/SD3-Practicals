package ITProblems;

public class ComputerOnFire extends TechnicalIssue {


	public ComputerOnFire()
	{
		priority = 1;
	}
	
	public ComputerOnFire(Technician technician){
		this();
		setTechnician(technician);
	}
	
	
	public void solveIssue() {
		this.technician.solveIssue("Computer is on fire");
	}

}
