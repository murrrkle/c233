import java.util.Scanner;

/*********************************************************
 * Last Name:           Hung
 * First Name:          Michael
 * Student ID:          10099049
 * Course:              CPSC 233
 * Tutorial Section:    L03 w/ Yongxin Liu
 * Assignment:          5
 *
 *
 * This racing simulation pits an SUV on an ArcticTrack
 * against a Sports car on a DesertTrack. 
 * 
 * This class is the brain of the program. It handles 
 * menu dusplay, menu processing, track display, car
 * movement, fuel management, debug-mode-toggling, and
 * a cheat mode for debugging purposes.
 *
 * At this point in time, there is no exception handling
 * involved to deal with unexpectedly belligerent inputs. 
**********************************************************/

public class GameController
{
    private Scanner in;
    
    private boolean done;           // A flag that will break out of the loop when the simulation is over.
    
    private boolean cheatBlizzard;  // A flag that indicates whether the blizzard cheat is ON/OFF.
    private boolean cheatHeatWave;  // A flag that indicates whether the heat wave cheat is ON/OFF.
    
    private SUV anSUV;              // A child of Car that is used exclusively in the Arctic Track.
    private Sports aSport;          // A child of Car that is used exclusively in the Desert Track.

    private ArcticTrack anArctic;   // A child of Track that is used exclusively with SUV.
    private DesertTrack aDesert;    // A child of Track that is used exclusively with Sports.
    
    private int arcticIndex;        // The location of an SUV in anArctic.
    private int desertIndex;        // The location of a Sports in aDesert.
    
    private Debug debugTracker;     // A flag that indicates whether debug mode is ON/OFF.
    
    public GameController ()        // Default Constructor: Initializes all classes to be used. Sets done and debug flags to false.
    
    {
	    in = new Scanner (System.in);
	    
	    anSUV = new SUV ();
	    aSport = new Sports ();
	    anArctic = new ArcticTrack ();
	    aDesert = new DesertTrack ();
	    
	    debugTracker = new Debug ();
	    
	    done = false;
	    debugTracker.on = false;
    }
    
    public void displaySUVMenu ()       // Displays driving options during the SUV turn.
    
    {
	    System.out.println ("\nSUV DRIVING MENU:\n");
	    System.out.println ("(a)ll wheel drive mode");
	    System.out.println ("(d)rive normally");
	    System.out.println ("(q)uit the simulation\n");
	    System.out.print   ("Please enter your selection now: ");
    }
    
    public void displaySportsMenu ()    // Displays driving options during the Sports turn.
    
    {
	    System.out.println ("\nSPORTS CAR DRIVING MENU:\n");
	    System.out.println ("(d)rive normally");
	    System.out.println ("(q)uit simulation\n");
	    System.out.print   ("Please enter your selection now: ");
    }
    
    public void displayCheatMenu ()     // Displays cheat options during any turn it is invoked in.
    
    {
	    System.out.println ("\nCHEAT MENU SELECTION\n");
	    System.out.println ("(0) Toggle debugging messages ON/OFF.");
	    System.out.println ("(1) Change the amount of fuel in the sports car.");
	    System.out.println ("(2) Change the amount of fuel in the SUV.");
	    System.out.println ("(3) Change the location of the sports car.");
	    System.out.println ("(4) Change the location of the SUV.");
	    System.out.println ("(5) Summon a punishing blizzard into the Arctic track.");
	    System.out.println ("(6) Summon a sweltering heat wave to swallow the Desert track.");
	    System.out.print   ("\nPlease enter your selection now: ");
	}        

    public boolean processSUVMenu (char selection, boolean weather) // Processes the selection made in SUV menu using a switch clause. Returns TRUE/FALSE to indicate valid selection.
    
    {
	    String line = null;
	    char cheatSelection = ' ';
	    
	    switch (selection)
	    
	    {
	        case 'A': // (a)ll wheel drive mode - Updates location and clears old location from display using AWD settings. Output depends on weather and debug flags.
	        case 'a':
	        
	        {
		        System.out.println ("\nAWD mode activated!");
		        anArctic.setLocation (null, arcticIndex);
	            arcticIndex += anSUV.moveAWD (weather, debugTracker.on);
	            
	            return true;
            }
            
	        case 'd': // (d)rive normally - Updates location and clears old location from display using normal settings. Output depends on weather and debug flags.
	        case 'D':
		    
		    {
		        anArctic.setLocation (null, arcticIndex);
	            arcticIndex += anSUV.move (weather, debugTracker.on);
	            
	            return true;
            }
            
	        case 'Q': // (q)uit simulation
	        case 'q':
	        
	        {
	            System.out.println ("\nThe ice collapses under you and you are never seen again. Your opponent wins by default.\n");
		        done = true;
		        
		        return true;
            }
            
            case 'c': // (c)heat options - Displays cheat menu and handles cheat menu processing. 
            case 'C':
            
            {
                displayCheatMenu ();
                line = in.nextLine ();
                cheatSelection = line.charAt (0);
                
                return processCheatMenu (cheatSelection);
            }
            
	        default: // Invalid input.
	        
	        {
		        System.out.println ("\nPlease enter 'a', 'd' or 'q'\n");
		        
		        return false;
            }
	    }
    }

    public boolean processSportsMenu (char selection, boolean weather)
    
    {
	    String line = null;
	    char cheatSelection = ' ';
	    
	    switch (selection)
	    
	    {
	        case 'd': // (d)rive normally - Updates location and clears old location from display using normal settings. Output depends on weather and debug flags.
	        case 'D':
		    
		    {
	            aDesert.setLocation (null, desertIndex);
	            desertIndex += aSport.move (weather, debugTracker.on);
	            
	            return true;
            }
            
	        case 'Q': // (q)uit simulation
	        case 'q':
	        
	        {
	            System.out.println ("\nA fierce sandstorm wrecks your engine, stranding you in the middle of nowhere. Your opponent wins by default.\n");
		        done = true;
		        
	            return true;
            }
            
            case 'c': // (c)heat options - Displays cheat menu and handles cheat menu processing. 
            case 'C':
            
            {
                displayCheatMenu ();
                line = in.nextLine ();
                cheatSelection = line.charAt (0);
                
                return processCheatMenu (cheatSelection);
            }
                        
	        default: // Invalid input.
	        
	        {
		        System.out.println ("\nPlease enter 'd' or 'q'\n");
		        
		        return false;
            }
	    }
    }

    public boolean processCheatMenu (char selection) // Returns TRUE/FALSE depending on validity of selection.
    
    {
	    int newFuel;
	    int newIndex;
	    
	    char newIndexCharacter;
	    
	    switch (selection)
	    
	    {
	        case '0': // Toggle debug mode.
	        
	        {
	            if (debugTracker.on == false)
	            
	            {
	                debugTracker.on = true;
	                System.out.println ("Debug mode has been toggled ON. Debugging messages will now be displayed.\n");
	                
	                return false;
	            }
	            
	            else
	            
	            {
	                debugTracker.on = false;
	                System.out.println ("Debug mode has been toggled OFF. Debug messages will no longer be displayed.\n");
	                
	                return false;
	            }
	        }
	        
	        case '1': // Set fuel of sports car.
	        
	        {
	            System.out.print ("Please enter a non-negative integer: ");
	            newFuel = in.nextInt ();
	            in.nextLine ();
	            
	            aSport.setFuel (newFuel);
	            
	            if (newFuel >= 0)
	            
	            {
	                System.out.println ("The sports car's fuel has been set to " + newFuel + ".\n");

	                return true;
	            }
	            
	            else
	            
	            {
	                System.out.println ("Returning to main menu.");
	                
	                return false;
	            }
	        }
	        
	        case '2': // Set fuel of SUV.
	        
	        {
	            System.out.print ("Please enter a non-negative integer: ");
	            newFuel = in.nextInt ();
	            in.nextLine ();
	            
	            anSUV.setFuel (newFuel);
	            
	            if (newFuel >= 0)
	            
	            {
	                System.out.println ("The SUV's fuel has been set to " + newFuel + ".\n");
	                
	                return true;
	            }
	            
	            else
	            
	            {
	                System.out.println ("Returning to main menu.");
	                
	                return false;
	            }
	        }
	        
	        case '3': // Set location of sports car.
	        
	        {
	            System.out.print ("Please enter a number from 0 to 24, inclusive: ");
	            newIndex = in.nextInt ();
	            in.nextLine ();
	            
	            if ((newIndex >= 0) && (newIndex < 25))
	            
	            {
	                newIndexCharacter = (char) (newIndex + 65);
	                
	                System.out.println  ("The sports car's location has been changed to " + newIndexCharacter + "\n");
	                aDesert.setLocation (null, desertIndex);
	                aDesert.setLocation (aSport, newIndex);
	                desertIndex = newIndex;
	                
	                return true;
	            }
	            
	            else
	            
	            {
	                System.out.println ("Invalid location specified. Returning to main menu.");
	                
	                return false;
	            }
	            
	        }
	        
	        case '4': // Set location of SUV. 
	        
	        {
	            System.out.print ("Please enter a number from 0 to 24, inclusive: ");
	            newIndex = in.nextInt ();
	            in.nextLine ();
	            
	            if ((newIndex >= 0) && (newIndex < 25))
	            
	            {
	                newIndexCharacter = (char) (newIndex + 65);
	                
	                System.out.println   ("The SUV's location has been changed to " + newIndexCharacter + "\n");
	                anArctic.setLocation (null, arcticIndex);
	                anArctic.setLocation (anSUV, newIndex);
	                arcticIndex = newIndex;
	                
	                return true;
	            }
	            
	            else
	            
	            {
	                System.out.println ("Invalid location specified. Returning to main menu.");
	                return false;
	            }	        
	        }
	        
	        case '5': // Set chance of blizzard on SUV's next turn to 100%. Does not work if invoked on SUV's turn.
	        
	        {
	            System.out.println ("On the SUV's next turn, a blizzard will ravish the Arctic track.\n");
	            cheatBlizzard = true;
	            
	            return true;
	        }
	        
	        case '6': // Set chance of heat wave on sports car's next turn to 100%. Does not work if invoked on Sports' turn.
	        
	        {
	            System.out.println ("On the sports car's next turn, a heat wave will hammer the Desert track.\n");
	            cheatHeatWave = true;
	            
	            return false;
	        }
	        
	        default: // Invalid input.
	        
	        {
	            System.out.println ("Invalid selection. Returning to previous menu.");
	            
	            return false;
	        }
	    }
    }


    public void start () // The meat of the program. 
    {
	    String line  = null;
        String winner = "";
        
	    char selection = ' ';
	    
	    boolean blizzard;
	    boolean heatWave;
	    boolean validSelection;
	    
	    cheatBlizzard = false;
	    cheatHeatWave = false;
	    
	    arcticIndex = 0;
	    desertIndex = 0;
	    
	    System.out.println ("\nLast Name:\t\tHung"); // Prints identification Banner
        System.out.println ("First Name:\t\tMichael");
        System.out.println ("Student ID:\t\t10099049");
        System.out.println ("Course:\t\t\tCPSC 233");
        System.out.println ("Tutorial Section\tT03 w/ Yongxin Liu");
        System.out.println ("Assignment:\t\t5\n");
	    
	    System.out.println ("This racing simulation pits an SUV on an ArcticTrack");
	    System.out.println ("against a Sports car on a DesertTrack.\n");
	    System.out.println ("The SUV consumes 3 units of fuel and moves 2 spaces by") ;
	    System.out.println ("default. It can drive in All Wheel Drive (AWD), where");
	    System.out.println ("it will still consume 3 units of fuel but advance only"); 
	    System.out.println ("1 space. There is a 10% chance that it will be caught") ;
	    System.out.println ("in a blizzard, where unless it is in AWD, the SUV will") ;
	    System.out.println ("consume 3 units of fuel but advance 0 spaces. If AWD");
	    System.out.println ("is on, the SUV advances 1 space and consumes 3 fuel.");
	    System.out.println ("The SUV starts with 50 fuel units.\n");
	    System.out.println ("The Sports car consumes 2 units of fuel and moves 3");
	    System.out.println ("spaces by default. There is a 10% chance that it will");
	    System.out.println ("be caught in a heat wave, where it will still move");
	    System.out.println ("3 spaces but consume 4 units of fuel - twice the");
	    System.out.println ("usual amount. The Sports car begins with 30 fuel"); 
	    System.out.println ("units.\n");
	    System.out.println ("Whichever Car reaches the 25th space (index 24) first");
	    System.out.println ("is declared the winner. If both cars run out of fuel");
	    System.out.println ("before a winner is declared, the match is considered");
	    System.out.println ("a draw.\n");
	    
	    
	    while (done == false)
	    
	    {   
	        if (anSUV.isEmpty () && aSport.isEmpty ()) // Checks auto-end conditions.
	        
	        {
	            System.out.println ("\nBoth participants are out of fuel! There is no winner!\n");
	            done = true;
	            
	            break;
	        }
	        
	        if (anSUV.isEmpty ())
	        
	        {
	           System.out.println ("The SUV is out of fuel!\n"); 
	        }
	        
	        else
	        
	        {
	            validSelection = false;
	            
	            while (!validSelection)
	            
	            {
	                displaySUVMenu ();
	                
	                line = in.nextLine ();
	                selection = line.charAt (0);
	                
	                blizzard = anArctic.makeBlizzard (cheatBlizzard);
	                validSelection = processSUVMenu (selection, blizzard);
            	    	    anArctic.setLocation (anSUV, arcticIndex);	     
            	    	               
	                cheatBlizzard = false;
	            }
	            
	            if (done)
	            
	            {
	                break;
	            }
	        }
	        
	        if (aSport.isEmpty ())
	        
	        {
	            System.out.println ("The sports car is out of fuel!\n");
	        }
	        
	        else
	        
	        {
	            validSelection = false;
	            
	            while (!validSelection)
	            
	            {
        	            displaySportsMenu ();
        	            
	                line = in.nextLine ();
	                selection = line.charAt (0);
	                
	                heatWave = aDesert.makeHeatWave (cheatHeatWave);
	                validSelection = processSportsMenu (selection, heatWave);
                	    aDesert.setLocation (aSport, desertIndex);   
                	    
	                cheatHeatWave = false;
	            }
	            
	            if (done)
	            
	            {
	                break;
	            }	            
	        }
	        
	        anArctic.display (); // Displays the tracks and the cars' positions.
	        aDesert.display  ();
	        
	        if (anArctic.isWon () || aDesert.isWon ()) // Checks winning conditions. If met, break loop.
	        
	        {
	            if (anArctic.isWon ())
	            
	            {
	                winner = "SUV";
	            }
	            
	            else
	            
	            {
	                winner = "sports car";
	            }
	            
	            System.out.println("\nAaaaand we have our winner! Congratulations to the " + winner + "!\n");
	            
	            done = true;
	        }
	    }
    }
}
