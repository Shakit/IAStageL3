import structs.FrameData;
import structs.Key;


public class MovingFState extends State {
	/**
	 * Constructor
	 * @param client, aka our IA
	 */
	public MovingFState(IAstageState client) {
		super(client);
	}

	/**
	 * Overriding State.doYourStuff.
	 * This method does the character to do a block action.
	 */
	@Override
	public void doYourStuff() {
		Key inputKey = new Key();
		FrameData fData = client_.getFData();
		boolean myPlayerNumber = client_.getPlayerNumber();
		
		if(!fData.getEmptyFlag() && fData.getRemainingTime() > 0) 
		{
			inputKey.U = (rand.nextInt(10)>4)?true : false;
			inputKey.D = false;
			inputKey.A = false;
			inputKey.B = false;
			inputKey.C = false;
			
			int distance = Math.abs(fData.getMyCharacter(myPlayerNumber).getX() 
					- fData.getOpponentCharacter(myPlayerNumber).getX());
			
			if (distance > 30)
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
			
			client_.setInputKey(inputKey);
		}
		
		//The probability has not been already chosen.
		nextState(25, 25, 25);	
	}

}
