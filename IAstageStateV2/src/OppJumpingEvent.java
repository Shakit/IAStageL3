
public class OppJumpingEvent extends Event
{

    public OppJumpingEvent(IAstageStateV2 client)
    {
        super(client);
    }

    @Override
    public void AtkAndMovStateChoice()
    {
        // TODO Find a countermeasure for jumping.
    }

    @Override
    public void printEvent()
    {
        System.out.print("OppJ");
    }

}
