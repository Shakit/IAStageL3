import java.util.Random;

import structs.Key;


public abstract class State {
	/*=============================================*/
	/*===============    MEMBERS    ===============*/
	protected IAstageState client_; 
	protected Random rand;
	
	/*=============================================*/
	/*============    CONSTRUCTORS    =============*/
	public State(IAstageState client)
	{
		client_ = client;
		rand = new Random();
	}
	
	/*=============================================*/
	/*============    OTHER METHODS    ============*/
	/**
	 * The method that execute codes depending on current state
	 */
	public void doYourStuff(){
		client_.setInputKey(new Key());
	}
	
	/**
	 * This method enable switching from a state to an other.
	 * Each parameter represents the probability of switching to 
	 * AttackState (ATK), DefenseState (DEF), MovingFState (MF)
	 * multiplied by 100. The probability of switching to 
	 * MovingBState is deducted from the sum of the others.
	 * Hence, the sum of all parameters has to be less or equal
	 * to 100. 
	 * 
	 * @param ATK >= 0, the probability of switching to AttackState multiplied by 100.
	 * @param DEF >= 0, the probability of switching to DefenseState multiplied by 100.
	 * @param MF >= 0, the probability of switching to MovingFState multiplied by 100.
	 */
	public void nextState(int ATK, int DEF, int MF)
	{
		int choice = rand.nextInt(100);
		if (choice >= 100 - ATK) 
		{
			client_.setCurrentState(client_.getAttackState());
		}
		else if (choice >= 100 - ATK - DEF) 
		{
			client_.setCurrentState(client_.getDefenseState());
		}
		else if (choice >= 100 - ATK - DEF - MF) 
		{
			client_.setCurrentState(client_.getMovingFState());
		}
		else 
		{
			client_.setCurrentState(client_.getMovingBState());
		}
	}
	
	public void printState()
	{
		System.out.println("zbra !");
	}
}
