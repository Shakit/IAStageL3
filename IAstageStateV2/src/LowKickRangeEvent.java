
public class LowKickRangeEvent extends Event
{

    public LowKickRangeEvent(IAstageStateV2 client)
    {
        super(client);
    }

    @Override
    public void AtkAndMovStateChoice()
    {
        client_.setCurrentAttackState(client_.getKickState());
        client_.setCurrentMovingState(client_.getCrouchState());
    }
    
    @Override
    public void printEvent()
    {
        System.out.print("LKRa");
    }
}
