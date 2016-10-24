package Policies;

public class PolicyGame {

	PolicyFactory factory;
	
	public PolicyGame(){
		setFactory(new PolicyFactory());
	}
	
	public void playGame(Integer n){
		Policy policy;
		
		policy = this.factory.createPolicy(n);
		policy.announceWinner();
	}

	public void setFactory(PolicyFactory factory) {
		this.factory = factory;
	}
	
	
}
