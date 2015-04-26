/** 
 * Person.java:  A class containing the person information. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 4
 */

public class Person
{
    private char gender;
    private int ageRange;
    private double height;
    
    /** Default constructor */
    public Person ()
    {
        gender = 'U';
        ageRange = 0;
        height = 0;
    }
    
    /** Constructor
     * @param g The gender
     * @param range The age range
     * @param h The height
     */
    public Person (char g, int range, double h)
    {
        gender = g;
        ageRange = range;
        height = h;
    }
    
    /** Check if the person information is complete.
     * @return True if all attributes are defined, false otherwise.
     */
    public boolean isComplete ()
    {
        return (!(gender == 'U' || ageRange == 0 || height <= 0)); 
    }
    
    /** Get the gender
     * @return The gender
     */
    public char getGender ()
    {
        return gender;
    }
    
    /** Get the age range
     * @return The age range
     */
    public int getAgeRange ()
    {
        return ageRange;
    }
    
    /** Get the height
     * @return The height
     */
    public double getHeight ()
    {
        return height;
    }
    
    /** Set the gender
     * @param g The gender
     */
    public void setGender (char g)
    {
        gender = g;
    }

    /** Set the age range
     * @param range The age range
     */
    public void setAgeRange (int range)
    {
        ageRange = range;
    }

    /** Set the height
     * @param The height
     */
    public void setHeight (double h)
    {
        height = h;
    }
    
    /** Match the given person with this person
     * @param individual The given person
     * @return The number of attributes matched
     */
    public int matches (Person individual)
    {
        int match = 0;
        
        if (gender == individual.getGender())
            match ++;
            
        if (ageRange == individual.getAgeRange())
            match ++;
        
        if (height == individual.getHeight())
            match ++;
            
        return match;
    }
    
    /** Conver the class object to a string
     * @return The string representatio of the Person object
     */
    public String toString()
    {
        String str = "";
        if (gender == 'F')
            str += "female, ";
        else if (gender == 'M')
            str += "male, ";
        else
            str += "unknown, ";
            
        str += ageRange + "'s, ";
        str += height +"m";
        
        return str;
    }       
}
