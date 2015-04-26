/*********************************************************
 * Last Name:           Hung
 * First Name:          Michael
 * Student ID:          10099049
 * Course:              CPSC 233
 * Tutorial Section:    L03 w/ Yongxin Liu
 * Assignment:          5
 *
 * A child of Car used exclusively with the DesertTrack.
 * Returns the distance moved to update its location in 
 * the track.
**********************************************************/

public class Sports extends Car

{
    private int consumptionRate;    // The number of units of fuel consumed per turn by default.
    private int moveDistance;       // Moving distance in normal driving mode.
    
    public Sports () // Default Constructor.
    
    {
        consumptionRate = CONSUMPTION_RATE;
        moveDistance = STANDARD_DISTANCE + 1;
        
        setFuel (30);
        setAppearance ('P');
    }
    
    public int move (boolean weather, boolean debug) // Overloading move() from Car. Return depends on weather flag, output depends on weather and debug flags.
    
    {
	    if (weather) // Heat wave hits. Consumes twice as much fuel as usual.
	    
	    {
	        consumeFuel (2 * consumptionRate);
	        if (getFuel() < 0)
	        
	        {
	            setFuel (0);
	        }
	        
    	        System.out.println ("\nA heat wave hammers the desert track! The fuel meter drops by twice the normal amount!\n");
            	
            	if (debug)
            	
            	{
            	    System.out.println ("\nCurrent fuel: " + getFuel());
        	        System.out.println ("Fuel use: " + 2 * consumptionRate);
        	        System.out.println ("Distance traveled: " + moveDistance + "\n\n");
        	    }
        	    
        	    return moveDistance;
	    }
	    
	    else // No weather. 
	    
	    {
	        consumeFuel (consumptionRate);
	        if (getFuel() < 0)
	        
	        {
	            setFuel (0);
	        }
	        
	        System.out.println ("\nThe sweat on your brow trickles down as you zoom by the sand dunes.\n");
        	    
        	    if (debug)
        	    
        	    {
        	        System.out.println ("\nCurrent fuel: " + getFuel());
	            System.out.println ("Fuel use: " + (consumptionRate));
	            System.out.println ("Distance traveled: " + moveDistance + "\n");
	        }
	        
	        return moveDistance;
	    }
    }
}

