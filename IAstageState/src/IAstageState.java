import structs.FrameData;
import structs.GameData;
import structs.Key;
import gameInterface.AIInterface;


public class IAstageState implements AIInterface {
	/*=============================================*/
	/*===============    MEMBERS    ===============*/
	private Key inputKey;
	private FrameData fData;
	private boolean myPlayerNumber;
	private State currentState;
	private State attackState;
	private State defenseState;
	private State movingFState;
	private State movingBState;
	
	
	/*=============================================*/
	/*===============    GETTERS    ===============*/
	/**
	 * Getter for current frame data.
	 * @return fData, a FrameData
	 */
	public FrameData getFData()
	{
		return fData;
	}
	
	/**
	 * Getter for the player number, which is actually a boolean.
	 * @return a boolean as the player number
	 */
	public boolean getPlayerNumber()
	{
		return myPlayerNumber;
	}
	
	/**
	 * Getters for the current State of the bot
	 * @return current stage of the bot
	 */
	public State getCurrentState()
	{
		return currentState;
	}
	
	/**
	 * Getter for the attack State of the bot, which is useful for State Pattern
	 * @return attack state for the bot
	 */
	public State getAttackState() {
		return attackState;
	}

	/**
	 * Getter for the defense State of the bot, which is useful for State Pattern
	 * @return defense state for the bot
	 */
	public State getDefenseState() {
		return defenseState;
	}
	
	/**
	 * Getter for the moving forward State of the bot, which is useful for State Pattern
	 * @return moving forward state for the bot
	 */
	public State getMovingFState() {
		return movingFState;
	}

	/**
	 * Getter for the moving backward State of the bot, which is useful for State Pattern
	 * @return moving backward state for the bot
	 */
	public State getMovingBState() {
		return movingBState;
	}

	/*=============================================*/
	/*===============    SETTERS    ===============*/
	public void setCurrentState(State newState)
	{
		currentState = newState;
	}
	
	public void setInputKey(Key input)
	{
		inputKey = input;
	}
		
	/*=============================================*/
	/*============    OTHER METHODS    ============*/
	
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCharacter() {
		// TODO Auto-generated method stub
		return CHARACTER_ZEN;
	}

	@Override
	public void getInformation(FrameData arg0) {
		// TODO Auto-generated method stub
		fData = arg0;
	}

	@Override
	public int initialize(GameData arg0, boolean arg1) {
		inputKey = new Key();
		fData = new FrameData();
		myPlayerNumber = arg1;
				
		attackState = new AttackState(this);
		defenseState = new DefenseState(this);
		movingFState = new MovingFState(this);
		movingBState = new MovingBState(this);
		
		currentState = attackState;
		currentState.nextState(25, 25, 25);
		
		return 0;
	}

	@Override
	public Key input() {
		// TODO Auto-generated method stub
		return inputKey;
	}

	@Override
	public void processing() {
		currentState.doYourStuff();
	}

}
