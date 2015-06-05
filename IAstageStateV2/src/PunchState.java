import structs.Key;



public class PunchState extends AttackState {

	public PunchState(IAstageStateV2 client, String file) {
		super(client, file);
	}
	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		if(client_.getDistance() <= 50) inputKey.A = true;
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.print("P");		
	}
}
