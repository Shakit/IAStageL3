
public class NothingEvent extends Event
{
    public NothingEvent(IAstageStateV2 client)
    {
        super(client);
    }
    
    @Override
    public void AtkAndMovStateChoice()
    {}
    
    @Override
    public void printEvent()
    {
        System.out.print("None");
    }
}
