import structs.FrameData;
import structs.GameData;
import structs.Key;
import gameInterface.AIInterface;

public class IAstageStateV2 implements AIInterface 
{
	/*=============================================*/
	/*=============== MEMBERS ===============*/
	private Key inputKeyM;
	private Key inputKeyA;
	private FrameData fData;
	private boolean myPlayerNumber;
	
	private AttackState currentAttackState;
	private MovingState currentMovingState;
	
	private AttackState punchState;
	private AttackState kickState;
	private AttackState mysteryState;
	private AttackState nothingState;
	
	private MovingState forwardState;
	private MovingState backwardState;
	private MovingState crouchState;
	private MovingState jumpState;
	private MovingState jumpForwardState;
	private MovingState jumpBackwardState;
	private MovingState stayState;
	
	
	/*=============================================*/
	/*=============== GETTERS ===============*/
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
				
	//attack states
	public AttackState getPunchState() {
		return punchState;
	}

	public AttackState getKickState() {
		return kickState;
	}

	public AttackState getMysteryState() {
		return mysteryState;
	}

	public AttackState getNothingState() {
		return nothingState;
	}

	//moving states
	public MovingState getForwardState() {
		return forwardState;
	}

	public MovingState getBackwardState() {
		return backwardState;
	}

	public MovingState getCrouchState() {
		return crouchState;
	}

	public MovingState getJumpState() {
		return jumpState;
	}

	public MovingState getJumpForwardState() {
		return jumpForwardState;
	}

	public MovingState getJumpBackwardState() {
		return jumpBackwardState;
	}

	public MovingState getStayState() {
		return stayState;
	}
	
	/*=============================================*/
	/*=============== SETTERS ===============*/
	public void setCurrentAttackState(AttackState currentAttackState)
	{
		this.currentAttackState = currentAttackState;
	}

	public void setCurrentMovingState(MovingState currentMovingState) {
		this.currentMovingState = currentMovingState;
	}
	
	public void setInputKeyA(Key input)
	{
		inputKeyA = input;
	}
	
	public void setInputKeyM(Key input)
	{
		inputKeyM = input;
	}
	
	/*=============================================*/
	/*============ OTHER METHODS ============*/

	public void close() 
	{
		// TODO Auto-generated method stub
	}

	public String getCharacter() 
	{
	// TODO Auto-generated method stub
		return CHARACTER_ZEN;
	}

	public void getInformation(FrameData arg0)
	{
		// TODO Auto-generated method stub
		fData = arg0;
	}

	public int initialize(GameData arg0, boolean arg1) 
	{
		inputKeyA = new Key();
		inputKeyM = new Key();
		fData = new FrameData();
		myPlayerNumber = arg1;
		
		punchState = new PunchState(this, "data/aiData/IAstageStateV2/punch");
		kickState = new KickState(this, "data/aiData/IAstageStateV2/kick");
		mysteryState = new MysteryState(this, "data/aiData/IAstageStateV2/mystery");
		nothingState = new NothingState(this, "data/aiData/IAstageStateV2/nothing");
		
		forwardState = new ForwardState(this, "data/aiData/IAstageStateV2/forward");
		backwardState = new BackwardState(this, "data/aiData/IAstageStateV2/backward");
		crouchState = new CrouchState(this, "data/aiData/IAstageStateV2/crouch");
		jumpState = new JumpState(this, "data/aiData/IAstageStateV2/jump");
		jumpForwardState = new JumpForwardState(this, "data/aiData/IAstageStateV2/jumpForward");
		jumpBackwardState = new JumpBackwardState(this, "data/aiData/IAstageStateV2/jumpBackward");
		stayState = new StayState(this, "data/aiData/IAstageStateV2/stay");
				
		currentAttackState = nothingState;
		currentMovingState = stayState;
		
		return 0;
	}

	public Key input() 
	{
		inputKeyA.A = (inputKeyA.A || inputKeyM.A)?true:false;
		inputKeyA.B = (inputKeyA.B || inputKeyM.B)?true:false;
		inputKeyA.C = (inputKeyA.C || inputKeyM.C)?true:false;
		inputKeyA.U = (inputKeyA.U || inputKeyM.U)?true:false;
		inputKeyA.D = (inputKeyA.D || inputKeyM.A)?true:false;
		inputKeyA.R = (inputKeyA.R || inputKeyM.R)?true:false;
		inputKeyA.L = (inputKeyA.L || inputKeyM.L)?true:false;
		
		return inputKeyA;
	}

	public void processing() 
	{
		currentAttackState.printState();
		currentAttackState.doYourStuff();
		currentMovingState.printState();
		currentMovingState.doYourStuff();
		System.out.println("");
	}
}