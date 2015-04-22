import structs.FrameData;
import structs.GameData;
import structs.Key;
import gameInterface.AIInterface;
import java.lang.Math;
import java.util.Random;


public class IAstageG implements AIInterface 
{

	private Key inputKey;
	private FrameData fData;
	private boolean myPlayerNumber;
	private Random rnd;
	
	
	@Override
	public void close() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getCharacter() 
	{
		// TODO Auto-generated method stub
		return CHARACTER_ZEN;
	}

	@Override
	public void getInformation(FrameData arg0)
	{
		// TODO Auto-generated method stub
		fData = arg0;
	}

	@Override
	public int initialize(GameData arg0, boolean arg1) 
	{
		// TODO Auto-generated method stub
		inputKey = new Key();
		fData = new FrameData();
		myPlayerNumber = arg1;
		rnd = new Random();
		
		return 0;
	}

	@Override
	public Key input() 
	{
		// TODO Auto-generated method stub
		return inputKey;
	}

	@Override
	public void processing() 
	{
		// TODO Auto-generated method stub
		if(!fData.getEmptyFlag()) 
		{ 			
			if(fData.getRemainingTime() > 0) 
			{
				int distance = Math.abs(fData.getMyCharacter(myPlayerNumber).getX() 
							- fData.getOpponentCharacter(myPlayerNumber).getX());
				
				inputKey.A = false;
				inputKey.B = false;
				inputKey.C = false;
				inputKey.U = false;
				inputKey.D = false;
				inputKey.R = false;
				inputKey.L = false;
				
				if (distance > 40)
					{
						inputKey.A = false;
						inputKey.B = false;
						inputKey.C = false;					
						
																
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
				else 
				{
					if(fData.getRemainingTime()%2 != 0)
					{
						inputKey.R = false;
						inputKey.L = false;
						
						inputKey.A = (rnd.nextInt(10) > 4) ? true : false;
						inputKey.B = (rnd.nextInt(10) > 4) ? true : false;
						inputKey.C = (rnd.nextInt(10) > 4) ? true : false;
					}
					else
					{
						inputKey.R = false;
						inputKey.L = false;
					}
				}
			}
		}
	}
		
}

	


