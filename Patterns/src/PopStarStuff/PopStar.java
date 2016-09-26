package PopStarStuff;

import java.util.ArrayList;

public class PopStar implements Observable {

	private String update;
	private String name;
	private ArrayList<Fan> myFans = new ArrayList<Fan>();
	
	
	public PopStar(String name){
		setName(name);
	}
	
	
	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void addFan(Fan f) {
		this.myFans.add(f);
		
	}

	
	public void removeFan(Fan f) {
		this.myFans.remove(f);
		
	}

	
	public void notifyFans() {
		for(Fan temp : this.myFans){
			temp.update(update);
		}
		
	}

}
