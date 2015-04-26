import java.util.Random;

/*********************************************************
 * Last Name:           Hung
 * First Name:          Michael
 * Student ID:          10099049
 * Course:              CPSC 233
 * Tutorial Section:    L03 w/ Yongxin Liu
 * Assignment:          5
 *
 * A child of Track used exclusively with the SUV. 
 * A random number generator determines whether
 * a blizzard will occur.
**********************************************************/

public class ArcticTrack extends Track

{
    private SUV [] anArctic;
    private Random rng;
    
    public ArcticTrack () // Default Constructor.
    
    {
        	anArctic = new SUV [SIZE];
        	rng = new Random ();
        	
        	int c;
        	for (c = 0; c < SIZE; c++)
        	
	    {
	        anArctic [c] = null;
        }
    }
    
    
    public boolean makeBlizzard (boolean cheat) // Uses RNG to determine if a blizzard occurs. If cheatBlizzard == true, the chance of this happening is 100%.
    
    {
        boolean blizzard = false;
        
        if (cheat)
        
        {
            blizzard = true;
        }
        
        else if (rng.nextInt (101) % 10 == 0) // 10% chance
        
        {
            blizzard = true;
        }
        
        return blizzard;
    }
}    
