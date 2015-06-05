import structs.Key;


public class KickState extends AttackState {

	public KickState(IAstageStateV2 client, String file) {
		super(client, file);
	}

	public void doYourStuff() {
		Key inputKey = new Key();
		
		if(client_.getDistance() <= 50) inputKey.B = true;
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.print("K");		
	}
}
