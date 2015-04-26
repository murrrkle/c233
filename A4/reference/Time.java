/** 
 * Time.java:  A class containing the time information. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 4
 */

public class Time
{
    private int hour;
    private int minute;
    
    /** Default constructor */
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
    
    /** Check if the time information is complete.
     * @return True if all attributes are defined, false otherwise.
     */
    public boolean isComplete ()
    {
        return (!(hour < 0 || minute < 0)); 
    }
    
    /** Get the hour
     * @return The hour
     */
    public int getHour ()
    {
        return hour;
    }
    
    /** Get the minute
     * @return The minute
     */
    public int getMinute ()
    {
        return minute;
    }
    
    /** Match the given time with this time
     * @param t The given time
     * @return The difference between the time in hours
     */
    public double matches (Time t)
    {
        double diff = hour - t.getHour();
        diff += (minute - t.getMinute()) / 60;
        
        return diff;
    }
    
    /** Adjust the time according to the time difference
     * @param diff The time difference
     */
    public void adjustTime (double diff)
    {
        hour += (int)Math.floor(diff);
        minute += (diff - Math.floor(diff)) * 60;
    }
    
    /** Conver the class object to a string
     * @return The string representatio of the Time object
     */
    public String toString()
    {
        return hour + ":" + minute;
    }       
}
