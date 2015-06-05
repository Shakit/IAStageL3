import structs.Key;



public class CrouchState extends MovingState {

	public CrouchState(IAstageStateV2 client, String file) {
		super(client, file);
	}
	
	public void doYourStuff() {
		Key inputKey = new Key();
		
		inputKey.D = true;
		
		client_.setInputKeyM(inputKey);
		if (--nbFrameCurr == 0)
		{
			nextState(); 
			nbFrameCurr = nbFrameInit;
		}
	}
	
	public void printState() {
		System.out.print("Cr");		
	}
}
