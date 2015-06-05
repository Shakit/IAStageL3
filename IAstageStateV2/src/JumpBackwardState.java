import structs.FrameData;
import structs.Key;


public class JumpBackwardState extends MovingState {

	public JumpBackwardState(IAstageStateV2 client, String file) {
		super(client, file);
	}
	public void doYourStuff() {
		Key inputKey = new Key();
		FrameData fData = client_.getFData();
		boolean myPlayerNumber = client_.getPlayerNumber();
		
		if(!fData.getEmptyFlag() && fData.getRemainingTime() > 0) 
		{ 							
			if(fData.getMyCharacter(myPlayerNumber).isFront())
			{
				inputKey.R = false;
				inputKey.L = true;
			}
			else
			{ 
				inputKey.L = false;
				inputKey.R = true;
			}
		}
		
		inputKey.U = true;
		
		client_.setInputKeyM(inputKey);
		nextState();
	}
	public void printState() {
		System.out.print("JB");
	}
}
