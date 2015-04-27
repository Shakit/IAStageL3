//import java.util.Vector;

import structs.Key;


public class PunchState extends AttackState {

	public PunchState(IAstageStateV2 client, String file) {
		super(client, file);
		//probabilities = new Vector<Integer>();
		//for(int i = 0; i < 4; ++i) probabilities.add(25);
	}
	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		if(client_.getDistance() <= 50) inputKey.A = true;
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.print("Punch Attack State");		
	}
}
