import structs.FrameData;
import structs.Key;




public class ForwardState extends MovingState {

	public ForwardState(IAstageStateV2 client, String file) {
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
				inputKey.R = true;
				inputKey.L = false;
			}
			else
			{ 
				inputKey.L = true;
				inputKey.R = false;
			}
		}
		client_.setInputKeyM(inputKey);
		if (--nbFrameCurr == 0)
		{
			nextState(); 
			nbFrameCurr = nbFrameInit;
		}
	}
	
	public void printState() {
		System.out.print("Fw");
	}
}
