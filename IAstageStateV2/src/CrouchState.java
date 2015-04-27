//import java.util.Vector;

import structs.Key;


public class CrouchState extends MovingState {

	public CrouchState(IAstageStateV2 client, String file) {
		super(client, file);
		//probabilities = new Vector<Integer>();
		//for(int i = 0; i < 7; ++i) probabilities.add(15);
	}
	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		inputKey.D = true;
		
		client_.setInputKeyM(inputKey);
		nextState();
	}
	public void printState() {
		System.out.print("Crouch Moving State");		
	}
}
