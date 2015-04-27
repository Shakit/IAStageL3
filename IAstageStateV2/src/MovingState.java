
public abstract class MovingState extends State {

	public MovingState(IAstageStateV2 client, String file) {
		super(client,file);
		// TODO Auto-generated constructor stub
	}
	
	public void doYourStuff() {
		// TODO Auto-generated method stub
		super.doYourStuff();
	}
	
	public void nextState() {
		int choice = rand.nextInt(100);
		int cpt = 0;
		int probaTot = 100;
		boolean exit = false;
		
		for(double i : probabilities)
		{
			if (choice >= probaTot - i)
			{
				switch(cpt)
				{
					case 0 : 
						client_.setCurrentMovingState(client_.getForwardState());
						exit = true;
						break;
					case 1: 
						client_.setCurrentMovingState(client_.getBackwardState());
						exit = true;
						break;
					case 2 : 
						client_.setCurrentMovingState(client_.getJumpState());
						exit = true;
						break;
					case 3 : 
						client_.setCurrentMovingState(client_.getJumpForwardState());
						exit = true;
						break;
					case 4 : 
						client_.setCurrentMovingState(client_.getJumpBackwardState());
						exit = true;
						break;
					case 5 : 
						client_.setCurrentMovingState(client_.getCrouchState());
						exit = true;
						break;
					case 6 : 
						client_.setCurrentMovingState(client_.getStayState());
						exit = true;
						break;
				}
			}
			probaTot -= i;
			++cpt;
			if (exit) break;
		}
	}
	
	public void printState() {
		// TODO Auto-generated method stub
		System.out.print("MOVING STATE");
	}

}
