


public abstract class AttackState extends State {

	int distMin;
	int distMax;
	
	public AttackState(IAstageStateV2 client, String file) {
		super(client, file);
		distMin = 0;
		distMax = 500;
	}

	public int getDistMin() {
		return distMin;
	}
	
	public int getDistMax() {
		return distMax;
	}
	
	
	public void doYourStuff() {
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
						client_.setCurrentAttackState(client_.getPunchState());
						exit = true;
						break;
					case 1: 
						client_.setCurrentAttackState(client_.getKickState());
						exit = true;
						break;
					case 2 : 
						client_.setCurrentAttackState(client_.getMysteryState());
						exit = true;
						break;
					case 3 : 
						client_.setCurrentAttackState(client_.getNothingState());
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
		System.out.println("ATTACK STATE");
	}

}
