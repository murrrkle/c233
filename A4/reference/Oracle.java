/** 
 * Oracle.java:  The oracle that has the complete knowledge of the murder. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 4
 */
import java.io.*;

public class Oracle
{
    private Person murderer;
    private Location murderLocation;
    private Time murderTime;
    private int count;

    /** Constructor
     * @param line The line containing the murder information
     */
    public Oracle (String line)
    {
        // Separte the information into three categories
        String[] categories = line.split("; ");
        String[] info;
        
        // Get the murderer's information
        info = categories[0].split(", ");
        murderer = new Person(info[0].charAt(0), Integer.parseInt(info[1]), Double.parseDouble(info[2]));
        
        // Get the location
        info = categories[1].split(", ");
        murderLocation = new Location(info[0], info[1], info[2]);
        
        // Get the time
        info = categories[2].split(":");
        murderTime = new Time(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
        
        // Initialize the count
        count = 0;
    }
    
    /** Match the suspect with the decription of the murderer
     * @param suspect The suspect
     * @return The score indication the number of criterias matched.
     */
    public int checkPerson (Person suspect)
    {
        count ++;
        return murderer.matches(suspect);
    }
    
    /** Match the suspect's location with the murder location
     * @param suspectLocation The suspect's location
     * @return The score indication the number of criteria matched.
     */
    public int checkLocation (Location suspectLocation)
    {
        count ++;
        return murderLocation.matches(suspectLocation);
    }
    
    /** Match the suspect's time with the murder time
     * @param suspectTime The suspect's time
     * @return The time difference.
     */
    public double checkTime (Time suspectTime)
    {
        count ++;
        return murderTime.matches(suspectTime);
    }
    
    /** Get the count --- the number of times the Oracle is queried.
     * @return The value of count
     */
    public int getCount ()
    {
        return count;
    }
}
