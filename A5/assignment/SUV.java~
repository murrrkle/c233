/*********************************************************
 * Last Name:           Hung
 * First Name:          Michael
 * Student ID:          10099049
 * Course:              CPSC 233
 * Tutorial Section:    L03 w/ Yongxin Liu
 * Assignment:          5
 *
 * A child of Car used exclusively with the ArcticTrack.
 * Returns the distance moved to update its location in 
 * the track.
**********************************************************/

public class SUV extends Car

{
    private int consumptionRate;    // The number of units of fuel consumed per turn by default.
    private int normMoveDistance;   // Moving distance in normal driving mode.
    private int awdMoveDistance;    // Moving distance in AWD mode.
    
    public SUV () // Default Constructor
    {
        consumptionRate = CONSUMPTION_RATE + 1;
        normMoveDistance = STANDARD_DISTANCE;
        awdMoveDistance = STANDARD_DISTANCE - 1;
        
        setFuel (50);
        setAppearance ('V');
    }
    
    public int moveAWD (boolean weather, boolean debug) // move() variant for AWD mode. Return depends on weather flag, output depends on weather and debug flags.
    {
	    if (weather) // Successful AWD activation.
	    
	    {
	        consumeFuel (consumptionRate);
	        if (getFuel () < 0)
	        
	        {
	            setFuel (0);
	        }
	        
	        System.out.println ("\nGood timing! The SUV treks on slowly but surely.\n");
            
            if (debug)
            
            {
            	    System.out.println ("\nRemaining fuel: " + getFuel ());
        	        System.out.println ("Fuel use: " + consumptionRate);
        	        System.out.println ("Distance traveled: " + awdMoveDistance + "\n");
        	    }
        	    
        	    return awdMoveDistance;
	    }
	    
	    else // Unsuccessful AWD activation.
	    
	    {
	        consumeFuel (consumptionRate); 
	        if (getFuel () < 0)
	        
	        {
	            setFuel (0);
	        }
	        
	        System.out.println ("\nBad judgement on your part. You wasted some precious fuel.\n");
        	    
        	    if (debug)
        	    
        	    {    
        	        System.out.println ("\nRemaining fuel: " + getFuel ());
	            System.out.println ("Fuel use: " + consumptionRate);
	            System.out.println ("Distance traveled: " + awdMoveDistance + "\n");
	        }
	        
	        return awdMoveDistance;
	    }
    }

    public int move (boolean weather, boolean debug) // Overloading move() from Car. Return depends on weather flag, output depends on weather and debug flags.
    
    {
	    if (weather) // Failed to activate AWD in time.
	    
	    {
	        consumeFuel (consumptionRate);
	        if (getFuel () < 0)
	        
	        {
	            setFuel (0);
	        }
	        
	        System.out.println ("\nA blizzard! You floor it, but the tires spin helplessly in the onslaught of snow and ice.\n");
            	
            	if (debug)
            	
            	{
            	    System.out.println ("\nRemaining fuel: " + getFuel ());
        	        System.out.println ("Fuel use: " + consumptionRate);
        	        System.out.println ("Distance traveled: 0\n");
        	    }
        	    
        	    return 0;
	    }
	    
	    else // No weather, no AWD.
	    
	    {
	        consumeFuel (consumptionRate);
	        if (getFuel () < 0)
	        
	        {
	            setFuel (0);
	        }
	        
	        System.out.println ("\nWhite, white, and more white. You wouldn't even be able to tell that you were moving if not for the acceleration.\n");
        	    
        	    if (debug)
        	    
        	    {
        	        System.out.println ("\nRemaining fuel: " + getFuel());
	            System.out.println ("Fuel use: " + consumptionRate);
	            System.out.println ("Distance traveled: " + normMoveDistance + "\n");
	        }
	        
	        return normMoveDistance;
	    }
    }
}
