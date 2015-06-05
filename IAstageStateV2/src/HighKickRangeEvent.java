
public class HighKickRangeEvent extends Event
{

    public HighKickRangeEvent(IAstageStateV2 client)
    {
        super(client);
    }
    
    @Override
    public void AtkAndMovStateChoice()
    {
        client_.setCurrentAttackState(client_.getKickState());
        client_.setCurrentMovingState(client_.getForwardState());
    }
    
    @Override
    public void printEvent()
    {
        System.out.print("HKRa");
    }
}
