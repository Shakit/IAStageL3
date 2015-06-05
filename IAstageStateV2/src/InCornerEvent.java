
public class InCornerEvent extends Event
{
    public InCornerEvent(IAstageStateV2 client)
    {
        super(client);
    }

    @Override
    public void AtkAndMovStateChoice()
    {
        client_.setCurrentAttackState(client_.getNothingState());
        client_.setCurrentMovingState(client_.getJumpForwardState());
    }

    public void printEvent()
    {
        System.out.print("Corn");
    }
}
