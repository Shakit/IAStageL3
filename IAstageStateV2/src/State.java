import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import structs.Key;




public abstract class State 
{
    /*=============================================*/
    /*=============== MEMBERS ===============*/
    protected IAstageStateV2 client_;
    protected String probaFile;
    protected Vector<Double> probabilities;
    protected Random rand;
    protected int nbFrameInit;
    protected int nbFrameCurr;
        
    /*=============================================*/
    /*============ CONSTRUCTORS =============*/
    public State(IAstageStateV2 client, String file)
    {
        client_ = client;
        probabilities = new Vector<Double>();
        probaFile = file; 
        rand = new Random();
        
        nbFrameCurr = 60; 
        nbFrameInit = 60;
        
        Scanner sc = null;
        try
        {
            sc = new Scanner(new File(probaFile));
            while(sc.hasNextLine())
            {
                Double n = new Double(sc.nextLine());
                probabilities.add(n);
                System.out.println(n);
            }
        }
        catch(Exception e)
        {
            System.out.println("fichier introuvable ! ");
        }
        finally
        {
            if (sc != null)
            {
                sc.close();
            }
        }
        
    }
    
    /*=============================================*/
    /*============ OTHER METHODS ============*/
    /**
    * The method that execute codes depending on current state
    */
    public void doYourStuff()
    {
        client_.setInputKeyA(new Key());
        client_.setInputKeyM(new Key());
    }
    
    /**
    * This method enable switching from a state to an other.
    * Each parameter represents the probability of switching to
    * AttackState (ATK), DefenseState (DEF), MovingFState (MF)
    * multiplied by 100. The probability of switching to
    * MovingBState is deducted from the sum of the others.
    * Hence, the sum of all parameters has to be less or equal
    * to 100.
    *
    * @param ATK >= 0, the probability of switching to AttackState multiplied by 100.
    * @param DEF >= 0, the probability of switching to DefenseState multiplied by 100.
    * @param MF >= 0, the probability of switching to MovingFState multiplied by 100.
    */
    public void nextState()
    {
        int choice = rand.nextInt(100);
        if (choice >= 100) //100 - ATK
        {
            
        }
    }
    /**
     * A simple method for for testing
     */
    public void printState()
    {
        System.out.println("zbra !");
    }
    
    public void rewriteProbaFile()
    {
        String s = "";
        for(double i : probabilities)
        {
            s += i + "\n";
        }
        File file = null;
        file = new File(probaFile);
        if (file.delete())
        {
            try 
            {
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(s);
                bw.close();
            }
            catch(Exception e)
            {
                System.out.print("erreur d'ecriture");
            }
        }
    }
    
    public void setProba(int place, double plus)
    {
        double otherPlus = -(plus/(probabilities.size()-1));
        for(int i = 0; i < probabilities.size(); ++i)
        {
            if(i == place)
            {
                probabilities.set(i, probabilities.get(i) + plus);
            }
            else
            {
                probabilities.set(i, probabilities.get(i) + otherPlus);
            }
        }
    }
}
