package Coursework;

import java.util.ArrayList;

//This class acts as a move controller for the command pattern
public class MoveController implements java.io.Serializable {

	protected ArrayList<Move> moveList = new ArrayList<Move>();
	
	public void addMove(Move move){
		moveList.add(move);
	}
	
	public void executeMoves(){
		
		for(Move move : moveList){
			move.execute();
			try {
				Thread.sleep(50);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		moveList.clear();
	}
}
