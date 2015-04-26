/** 
 * Time.java:  A class containing the time information. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 4
 */

/*********************************************************
 * Last Name:           Hung
 * First Name:          Michael
 * Student ID:          10099049
 * Course:              CPSC 233
 * Tutorial Section:    L03 w/ Yongxin Liu
 * Assignment:          4
 *
 * This is the Time class, which contains the hours and 
 * minutes about the murder. It will be used in conjunction
 * with the Location and Person classes by the Detective class
 * in order to determine the identity of the 'murderer.'
 *
 * Input is assumed to be in the correct format. Accessors 
 * and mutators for the hours/minutes values help the Detective 
 * and Oracle's implementation, though they primarily make 
 * use of the matches method.
*********************************************************/

public class Time

{
    private int hour;
    private int minute;
    
    /** Default Constructor
     */
    public Time ()
    
    {
        hour = -1;
        minute = -1;
    } 

    /** Constructor
     * @param hr The hour
     * @param min The minute
     */    
    public Time (int hr, int min)
    
    {
        hour = hr;
        minute = min;
    }
     
    public int getHour ()
    
    {
        return hour;
    } 
    
    public int getMinute ()
    
    {
        return minute;
    }

    public void setTime (int hr, int min)
    {
	hour = hr;
	minute = min;
    }

    /** Match the given time with this time
     * @param aTime The given time
     * @return How close is the time aTime to this time
     */    
    public int matches (Time aTime)
    
    {
        int difference = -1;
        int scoreTime = -1;
        
        difference = Math.abs(hour - aTime.getHour ()) + Math.abs((minute - aTime.getMinute ()) / 60);
        
        if (difference == 0)
        
        {
            scoreTime = 0;
        }
        
        else if ((difference > 0) && (difference <= 1))
        
        {
            scoreTime = 1;
        }
        
        else if ((difference > 1) && (difference <= 4))
        
        {
            scoreTime = 2;
        }
        
        else
        
        {
            scoreTime = 3;
        }
        
        return scoreTime;
    }
    
    /** Conver the class object to a string
     * @return The string representation of the Time object
     */
    public String toString ()
    
    {
        String s = hour + ":";
        
        if (minute < 10 && minute >= 0)

        {
            s += "0";
        }
        
        s += minute;
        
        return s;
    }       
}
