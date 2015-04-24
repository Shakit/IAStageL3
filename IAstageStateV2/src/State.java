import java.util.Random;
import java.util.Vector;

import structs.Key;

public abstract class State 
{
	/*=============================================*/
	/*=============== MEMBERS ===============*/
	protected IAstageStateV2 client_;
	protected Vector<Integer> probabilities;
	protected Random rand;
	
	/*=============================================*/
	/*============ CONSTRUCTORS =============*/
	public State(IAstageStateV2 client)
	{
		client_ = client;
		rand = new Random();
	}
	
	/*=============================================*/
	/*============ OTHER METHODS ============*/
	/**
	* The method that execute codes depending on current state
	*/
	public void doYourStuff()
	{
		client_.setInputKeyA(new Key());
		client_.setInputKeyM(new Key());
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
	public void nextState()
	{
		int choice = rand.nextInt(100);
		if (choice >= 100) //100 - ATK
		{
			
		}
	}
	/**
	 * A simple method for for testing
	 */
	public void printState()
	{
		System.out.println("zbra !");
	}
}