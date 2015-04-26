/** 
 * Time.java:  A class containing the time information. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 4
 */

/*********************************************************
 * Last Name:  
 * First Name: 
 * Student ID: 
 * Course: CPSC 233
 * Tutorial Section:
 * Assignment: 4
 *
 * <Brief description of your program and main features>
*********************************************************/

public class Time
{
    private int hour;
    private int minute;
    
    /** Constructor
     * @param hr The hour
     * @param min The minute
     */
    public Time (int hr, int min)
    {
        hour = hr;
        minute = min;
    }
    
    /** Match the given time with this time
     * @param t The given time
     * @return How close is the time t to this time
     */
    public int matches (Time t)
    {

        return 0;
    }
    
    /** Conver the class object to a string
     * @return The string representatio of the Time object
     */
    public String toString()
    {
        String str = hour + ":";
        
        if (minute < 10 && minute >= 0)
            str += "0";
        str += minute;
        return str;
    }       
}
