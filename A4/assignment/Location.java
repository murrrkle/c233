/** 
 * Location.java:  A class containing the location information. <br>
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
 * This is the Location class, which contains the x and y
 * coordinates of the murder. It will be used in conjunction
 * with the Time and Person classes by the Detective class
 * in order to determine the identity of the 'murderer.'
 *
 * Input is assumed to be in the correct format. Accessors 
 * and mutators for the x-/y-coordinates help the Detective 
 * and Oracle's implementation, though they primarily make 
 * use of the matches method.
*********************************************************/

public class Location

{
    private double x;
    private double y;
    
    /** Constructor
     * @param xValue The x-coordinate.
     * @param yValue The y-coordinate.
     */
    public Location (double xValue, double yValue)
    
    {
        x = xValue;
        y = yValue;
    }
    
    /** Accessor for x-coordinate.
     *  @return The x-coordinate
     */
    public double getX ()
    
    {
        return x;
    }
    
    /** Accessor for y-coordinate.
     *  @return The y-coordinate.
     */
    public double getY ()
    
    {
        return y;
    }

    /** Mutator for x-/y-coordinate.
     */    
    public void setLocation (double newX, double newY)
    
    {
        x = newX;
	y = newY;
    }
    
    /** Matches the given location with this location.
     * @param aLocation The given location
     * @return The distance between aLocation and this location
     */
    public double matches (Location aLocation)
    
    {
        double distance = 0;
        double xDistance = 0;
        double yDistance = 0;
        
        xDistance = Math.pow((aLocation.getX() - x), 2);
        yDistance = Math.pow((aLocation.getY() - y), 2);
        distance = Math.sqrt((xDistance + yDistance));

        return distance;
    }
    
    /** Converts the class object to a string
     * @return The string representation of the Location object
     */
    public String toString ()
    
    {
        return "(" + Double.toString (x) + ", " + Double.toString (y) + ")";
    }       
}
