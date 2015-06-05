
public class MiddleKickRangeEvent extends Event
{

    public MiddleKickRangeEvent(IAstageStateV2 client)
    {
        super(client);
    }

    @Override
    public void AtkAndMovStateChoice()
    {
        client_.setCurrentAttackState(client_.getKickState());
        client_.setCurrentMovingState(client_.getStayState());
    }

    @Override
    public void printEvent()
    {
        System.out.print("MKRa");
    }
}
