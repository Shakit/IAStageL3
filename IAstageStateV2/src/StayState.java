//import java.util.Vector;

import structs.Key;


public class StayState extends MovingState {

	public StayState(IAstageStateV2 client, String file) {
		super(client, file);
		//probabilities = new Vector<Integer>();
		//for(int i = 0; i < 7; ++i) probabilities.add(15);
	}

	public void doYourStuff() {
		Key inputKey = new Key();
				
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.println("Stay Moving State");		
	}
}
