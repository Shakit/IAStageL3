import java.util.Vector;

import structs.Key;


public class PunchState extends AttackState {

	public PunchState(IAstageStateV2 client) {
		super(client);
		probabilities = new Vector<Integer>();
		for(int i = 0; i < 4; ++i) probabilities.add(25);
	}
	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		inputKey.A = true;
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.println("Punch Attack State");		
	}
}
