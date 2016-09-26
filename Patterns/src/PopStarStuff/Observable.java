package PopStarStuff;

public interface Observable {
	
	public void addFan(Fan f);
	public void removeFan(Fan f);
	public void notifyFans();
}
