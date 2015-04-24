//import java.util.Vector;

import structs.Key;


public class MysteryState extends AttackState {

	public MysteryState(IAstageStateV2 client, String file) {
		super(client, file);
		//probabilities = new Vector<Integer>();
		//for(int i = 0; i < 4; ++i) probabilities.add(25);
	}

	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		inputKey.C = true;
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.println("Mystery Attack State");		
	}
}
