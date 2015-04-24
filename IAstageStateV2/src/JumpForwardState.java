//import java.util.Vector;

import structs.FrameData;
import structs.Key;


public class JumpForwardState extends MovingState {

	public JumpForwardState(IAstageStateV2 client, String file) {
		super(client, file);
		//probabilities = new Vector<Integer>();
		//for(int i = 0; i < 7; ++i) probabilities.add(15);
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
		System.out.println("Jump Forward Moving State");
	}
}
