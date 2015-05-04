//import java.util.Vector;

import structs.Key;


public class MysteryState extends AttackState {

	public MysteryState(IAstageStateV2 client, String file) {
		super(client, file);
	}

	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		if(client_.getDistance() <= 50) inputKey.C = true;
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.print("Mystery Attack State");		
	}
}
