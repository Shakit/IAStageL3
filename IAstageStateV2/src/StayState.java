//import java.util.Vector;

import structs.Key;


public class StayState extends MovingState {

	public StayState(IAstageStateV2 client, String file) {
		super(client, file);
	}

	public void doYourStuff() {
		Key inputKey = new Key();
				
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.print("Stay Moving State");		
	}
}
