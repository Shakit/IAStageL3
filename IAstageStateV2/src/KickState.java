//import java.util.Vector;

import structs.Key;


public class KickState extends AttackState {

	public KickState(IAstageStateV2 client, String file) {
		super(client, file);
		//probabilities = new Vector<Integer>();
		//for(int i = 0; i < 4; ++i) probabilities.add(25);
	}

	public void doYourStuff() {
		Key inputKey = new Key();
		
		inputKey.B = true;
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.println("Kick Attack State");		
	}
}
