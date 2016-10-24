package ITProblems;

public class WindowsExplorerBroken extends TechnicalIssue {

	public WindowsExplorerBroken()
	{
		priority = 2;
	}
	
	
	public WindowsExplorerBroken(Technician technician){
		this();
		setTechnician(technician);
	}
	
	public void solveIssue() {
		this.technician.solveIssue("Windows Explorer is broken");
	}

}
