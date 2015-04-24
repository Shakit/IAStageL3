//import java.util.Vector;

import structs.Key;


public class NothingState extends AttackState {

	public NothingState(IAstageStateV2 client, String file) {
		super(client, file);
		//probabilities = new Vector<Integer>();
		//for(int i = 0; i < 4; ++i) probabilities.add(25);
	}

	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.println("Nothing Attack State");		
	}
}
