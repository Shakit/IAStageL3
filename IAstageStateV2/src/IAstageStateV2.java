import gameInterface.AIInterface;
import structs.FrameData;
import structs.GameData;
import structs.Key;


public class IAstageStateV2 implements AIInterface
{
    /* ==================================================================== */
    /* =======================        MEMBERS       ======================= */
    private Key         inputKeyM;
    private Key         inputKeyA;
    private FrameData   fData;
    private boolean     myPlayerNumber;
    private int         maxX;
    private int         maxY;

    private AttackState currentAttackState;
    private MovingState currentMovingState;

    private AttackState punchState;
    private AttackState kickState;
    private AttackState mysteryState;
    private AttackState nothingState;

    private MovingState forwardState;
    private MovingState backwardState;
    private MovingState crouchState;
    private MovingState jumpState;
    private MovingState jumpForwardState;
    private MovingState jumpBackwardState;
    private MovingState stayState;

    private Event       currentEvent;
    private Event       inCornerEvent;
    private Event       middleKickRangeEvent;
    private Event       highKickRangeEvent;
    private Event       lowKickRangeEvent;
    private Event       oppJumpingEvent;
    private Event       nothingEvent;

    /* ==================================================================== */
    /* =======================        GETTERS       ======================= */
    public FrameData getFData()
    {
        return fData;
    }

    public boolean getPlayerNumber()
    {
        return myPlayerNumber;
    }

    public int getDistance()
    {
        int distance = 0;

        if (!fData.getEmptyFlag() && fData.getRemainingTime() > 0)
        {
            distance = Math.abs(fData.getMyCharacter(myPlayerNumber).getX()
                                - fData.getOpponentCharacter(myPlayerNumber)
                                .getX());
        }

        return distance;
    }

    public int getCornerDistance()
    {
        if (!fData.getEmptyFlag() && fData.getRemainingTime() > 0)
        {
            if (fData.getMyCharacter(myPlayerNumber).isFront())
                return Math.abs(fData.getMyCharacter(myPlayerNumber).getX());
            else
                return Math.abs(fData.getMyCharacter(myPlayerNumber).getX()
                                - maxX);
        }
        else 
        {
            return -1;
        }
    }

    public int getOppGroundDistance()
    {
        if (!fData.getEmptyFlag() && fData.getRemainingTime() > 5)
        { 
            return Math.abs(fData.getOpponentCharacter(myPlayerNumber).getBottom()
                            - maxY);
        }
        return -1;
    }

    /* --------------------------------------------- */
    /* ------------     AttackStates     ------------*/
    public AttackState getPunchState()
    {
        return punchState;
    }

    public AttackState getKickState()
    {
        return kickState;
    }

    public AttackState getMysteryState()
    {
        return mysteryState;
    }

    public AttackState getNothingState()
    {
        return nothingState;
    }

    /* --------------------------------------------- */
    /* ------------     MovingStates     ------------*/
    public MovingState getForwardState()
    {
        return forwardState;
    }

    public MovingState getBackwardState()
    {
        return backwardState;
    }

    public MovingState getCrouchState()
    {
        return crouchState;
    }

    public MovingState getJumpState()
    {
        return jumpState;
    }

    public MovingState getJumpForwardState()
    {
        return jumpForwardState;
    }

    public MovingState getJumpBackwardState()
    {
        return jumpBackwardState;
    }

    public MovingState getStayState()
    {
        return stayState;
    }

    /* --------------------------------------------- */
    /* ------------        Event         ------------*/
    public Event getCurrentEvent()
    {
        return currentEvent;
    }

    public Event getInCornerEvent()
    {
        return inCornerEvent;
    }

    public Event getMiddleKickRangeEvent()
    {
        return middleKickRangeEvent;
    }

    public Event getHighKickRangeEvent()
    {
        return highKickRangeEvent;
    }

    public Event getLowKickRangeEvent()
    {
        return lowKickRangeEvent;
    }

    public Event getOppJumpingEvent()
    {
        return oppJumpingEvent;
    }

    public Event getNothingEvent()
    {
        return nothingEvent;
    }

    /* ==================================================================== */
    /* =======================        SETTERS       ======================= */
    public void setCurrentAttackState(AttackState currentAttackState)
    {
        this.currentAttackState = currentAttackState;
    }

    public void setCurrentMovingState(MovingState currentMovingState)
    {
        this.currentMovingState = currentMovingState;
    }

    public void setInputKeyA(Key input)
    {
        inputKeyA = input;
    }

    public void setInputKeyM(Key input)
    {
        inputKeyM = input;
    }

    public void setCurrentEvent(Event currentEvent)
    {
        this.currentEvent = currentEvent;
    }

    /* ============================================= */
    /* ============ OTHER METHODS ============ */
    public void close()
    {
        punchState.rewriteProbaFile();
        kickState.rewriteProbaFile();
        mysteryState.rewriteProbaFile();
        nothingState.rewriteProbaFile();

        forwardState.rewriteProbaFile();
        backwardState.rewriteProbaFile();
        jumpState.rewriteProbaFile();
        jumpForwardState.rewriteProbaFile();
        jumpBackwardState.rewriteProbaFile();
        crouchState.rewriteProbaFile();
        stayState.rewriteProbaFile();
    }


    public String getCharacter()
    {
        return CHARACTER_ZEN;
    }


    public void getInformation(FrameData arg0)
    {
        fData = arg0;
    }


    public int initialize(GameData arg0, boolean arg1)
    {
        inputKeyA = new Key();
        inputKeyM = new Key();
        fData = new FrameData();
        myPlayerNumber = arg1;
        maxX = arg0.getStageXMax();
        maxY = arg0.getStageYMax();

        punchState = new PunchState(this, "data/aiData/IAstageStateV2/punch");
        kickState = new KickState(this, "data/aiData/IAstageStateV2/kick");
        mysteryState = new MysteryState(this,"data/aiData/IAstageStateV2/mystery");
        nothingState = new NothingState(this,"data/aiData/IAstageStateV2/nothing");

        forwardState = new ForwardState(this,"data/aiData/IAstageStateV2/forward");
        backwardState = new BackwardState(this,"data/aiData/IAstageStateV2/backward");
        crouchState = new CrouchState(this, "data/aiData/IAstageStateV2/crouch");
        jumpState = new JumpState(this, "data/aiData/IAstageStateV2/jump");
        jumpForwardState = new JumpForwardState(this,"data/aiData/IAstageStateV2/jumpForward");
        jumpBackwardState = new JumpBackwardState(this,"data/aiData/IAstageStateV2/jumpBackward");
        stayState = new StayState(this, "data/aiData/IAstageStateV2/stay");

        inCornerEvent = new InCornerEvent(this);
        middleKickRangeEvent = new MiddleKickRangeEvent(this);
        highKickRangeEvent = new HighKickRangeEvent(this);
        lowKickRangeEvent = new LowKickRangeEvent(this);
        oppJumpingEvent = new OppJumpingEvent(this);
        nothingEvent = new NothingEvent(this);

        currentAttackState = nothingState;
        currentMovingState = stayState;
        currentEvent = nothingEvent;
        return 0;
    }


    public Key input()
    {
        inputKeyA.U = inputKeyM.U;
        inputKeyA.D = inputKeyM.D;
        inputKeyA.R = inputKeyM.R;
        inputKeyA.L = inputKeyM.L;

        return inputKeyA;
    }


    public void processing()
    {

        String dpFrame = "0000";
        String dpMyHP = "0000";
        String dpMyEnergy = "0000";
        String dpOppHP = "0000";
        String dpOppEnergy = "0000";

        currentEvent.recognizeEvent();
        currentEvent.AtkAndMovStateChoice();

        if(!fData.getEmptyFlag())
        {
            if (fData.getRemainingTime() > 0)           
            {   
                dpFrame = String.valueOf(60100 -fData.getRemainingTime());
                dpMyHP = String.valueOf(fData.getMyCharacter(myPlayerNumber).getHp());
                dpMyEnergy = String.valueOf(fData.getMyCharacter(myPlayerNumber).getEnergy());
                dpOppHP = String.valueOf(fData.getOpponentCharacter(myPlayerNumber).getHp());
                dpOppEnergy = String.valueOf(fData.getOpponentCharacter(myPlayerNumber).getEnergy());
            }
            
        }
        while (dpFrame.length() < 4) dpFrame = "0" + dpFrame;
        while (dpMyHP.length() < 4) dpMyHP = "0" + dpMyHP;
        while (dpMyEnergy.length() < 4) dpMyEnergy = "0" + dpMyEnergy;
        while (dpOppHP.length() < 4) dpOppHP = "0" + dpOppHP;
        while (dpOppEnergy.length() < 4) dpOppEnergy = "0" + dpOppEnergy;

        System.out.print(dpFrame);
        currentEvent.printEvent();
        currentAttackState.printState();
        currentMovingState.printState();
        System.out.print(dpMyHP);
        System.out.print(dpMyEnergy);
        System.out.print(dpOppHP);
        System.out.println(dpOppEnergy);
        
        currentAttackState.doYourStuff();
        currentMovingState.doYourStuff();
    }

}