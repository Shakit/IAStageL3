import structs.FrameData;
import structs.GameData;
import structs.Key;
import gameInterface.AIInterface;


public class IAtest implements AIInterface {

	private FrameData fD;
	private boolean myPlayer;
	private Key inputKey;
	private int b; 
	
	public void close() {
		// TODO Auto-generated method stub

	}

	public String getCharacter() {
		// TODO Auto-generated method stub
		return CHARACTER_ZEN;
	}

	public void getInformation(FrameData arg0) {
		fD = arg0;
	}

	public int initialize(GameData arg0, boolean arg1) {
		myPlayer = arg1;
		b = arg0.getStageYMax();
		return 0;
	}

	public Key input() {
		// TODO Auto-generated method stub
		return inputKey;
	}

	public void processing() {
		inputKey = new Key();
		
		if (!fD.getEmptyFlag() && fD.getRemainingTime() > 0)
		{
			int a = fD.getOpponentCharacter(myPlayer).getBottom();
			System.out.println(a + " - " + b + " = " + (a-b));
		}

	}

}
