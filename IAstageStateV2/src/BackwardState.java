//import java.util.Vector;

import structs.FrameData;
import structs.Key;


public class BackwardState extends MovingState {

	public BackwardState(IAstageStateV2 client, String file) {
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
		
		client_.setInputKeyM(inputKey);
		if (--nbFrameCurr == 0)
		{
			nextState(); 
			nbFrameCurr = nbFrameInit;
		}
	}
	
	public void printState() {
		System.out.print("Backward Moving State");
	}
}
