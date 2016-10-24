package ITProblems;

import java.util.*;


public class ITDepartment {

	private ArrayList<TechnicalIssue> issues = new ArrayList<TechnicalIssue>();
	
	public void recieveIssue(TechnicalIssue issue){
		this.issues.add(issue);
	}

	public void recieveIssues(ArrayList<TechnicalIssue> issue){
		for (TechnicalIssue tech : issue){
			recieveIssue(tech);
		}
	}
	
	public void sendToTechnician(){
		Collections.sort(issues, new Comparator<TechnicalIssue>(){
			
			
			public int compare(TechnicalIssue issue2, TechnicalIssue issue1){
				
				return issue2.priority - issue1.priority;
			}
			
		});
		
		for(TechnicalIssue issue : this.issues){
			issue.solveIssue();
		}
	}
	
}
