package ITProblems;

public abstract class TechnicalIssue {

	protected Technician technician;
	protected int priority;
	
	public abstract void solveIssue();

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
	
}
