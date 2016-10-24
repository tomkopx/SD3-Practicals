package Policies;

public class PolicyFactory {

	public Policy createPolicy(Integer n){
		
		Policy policy = null;
		
		switch(n){
		
		case 0:
			policy = new Brexit();
			break;
		case 1:
			policy = new NoEducation();
			break;
		case 2:
			policy = new NoImmigrants();
			break;
		case 3:
			policy = new NoReligion();
			break;
		case 4:
			policy = new BanSteven();
			break;
		default:
			System.out.println("Invalid number!");
		}
		
		return policy;
		
	}
	
}
