public abstract class Event
{
    protected IAstageStateV2 client_;

    public Event(IAstageStateV2 client)
    {
        client_ = client;
    }

    public void recognizeEvent()
    {        
        if (client_.getCornerDistance() <= 50 && client_.getCornerDistance() >= 0)
        {
            client_.setCurrentEvent(client_.getInCornerEvent());
        }
        else if (client_.getDistance() <= 50)
        {
            client_.setCurrentEvent(client_.getMiddleKickRangeEvent());
        }
        else if (client_.getDistance() <= 70)
        {
            client_.setCurrentEvent(client_.getHighKickRangeEvent());
        }
        else if (client_.getDistance() <= 85
                 && client_.getOppGroundDistance() == 0)
        {
            client_.setCurrentEvent(client_.getLowKickRangeEvent());
        }
        else if (client_.getOppGroundDistance() > 0)
        {
            client_.setCurrentEvent(client_.getOppJumpingEvent());
        }
        else
        {
            client_.setCurrentEvent(client_.getNothingEvent());
        }
    }

    public void AtkAndMovStateChoice()
    {
        System.out.println("WRONG EVENT !");
    }

    public void printEvent()
    {
        System.out.print("It is not a concrete event");
    }
}