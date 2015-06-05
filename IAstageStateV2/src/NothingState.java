import structs.Key;



public class NothingState extends AttackState {

	public NothingState(IAstageStateV2 client, String file) {
		super(client, file);
	}

	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		client_.setInputKeyA(inputKey);
		nextState();
	}
	
	public void printState() {
		System.out.print("N");		
	}
}
