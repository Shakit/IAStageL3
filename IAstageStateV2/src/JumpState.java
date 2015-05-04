//import java.util.Vector;

import structs.Key;


public class JumpState extends MovingState {

	public JumpState(IAstageStateV2 client, String file) {
		super(client, file);
	}

	public void doYourStuff() {
		Key inputKey = new Key();
		inputKey.U = true;
		
		client_.setInputKeyM(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.print("Jump Moving State");
	}
}
