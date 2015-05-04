//import java.util.Vector;

import structs.FrameData;
import structs.Key;


public class JumpForwardState extends MovingState {

	public JumpForwardState(IAstageStateV2 client, String file) {
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
		
		inputKey.U = true;
		
		client_.setInputKeyM(inputKey);
		nextState();
	}
	public void printState() {
		System.out.print("Jump Forward Moving State");
	}
}
