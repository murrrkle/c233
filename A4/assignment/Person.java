/** 
 * Person.java:  A class containing the person information. <br>
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
 * This is the Person class, which contains the gender, age, 
 * and height details of a 'person.' It will be used in conjunction
 * with the Time and Location classes by the Detective class
 * in order to determine the identity of the 'murderer.'
 *
 * Input is assumed to be in the correct format. Accessors 
 * and mutators for the gender, age, and height values help 
 * the Detective and Oracle's implementation, though they 
 * primarily make use of the matches method.
*********************************************************/

public class Person
{
    private char gender;
    private int ageRange;
    private double height;
    
    /** Constructor
     * @param g The gender
     * @param r The age range
     * @param h The height
     */
    public Person (char g, int r, double h)
    
    {
        gender = g;
        ageRange = r;
        height = h;
    }
    
    /** Accessor for gender
     * @return The gender
     */    
    public char getGender ()
    
    {
        return gender;
    }

    /** Accessor for age range
     * @return The age range
     */       
    public int getAgeRange ()
    
    {
        return ageRange;
    }

    /** Accessor for height
     * @return The height
     */       
    public double getHeight ()
    
    {
        return height;
    }

    /** Mutator for gender
     */       
    public void setGender (char newGender)
    
    {
        gender = newGender;
    }

    /** Mutator for age range
     */           
    public void setAgeRange (int newRange)
    
    {
        ageRange = newRange;
    }

    /** Mutator for height
     */           
    public void setHeight (double newHeight)
    
    {
        height = newHeight;
    }
    
    /** Match the given person with this person
     * @param individual The given person
     * @return The difference between the individual and this person
     */
    public double matches (Person individual)
    
    {
        int scoreGender = 0;
        int scoreAgeRange = 0;
        double scoreHeight = 0;
        
        if (gender == individual.getGender ())
        
        {
            scoreGender = 0;
        }
        
        else
        
        {
            scoreGender = 100;
        }
        
        scoreAgeRange = Math.abs(ageRange - individual.getAgeRange ());
        
        scoreHeight = Math.abs(height - individual.getHeight ());

        
        return scoreGender + scoreAgeRange + scoreHeight;
    }
    
    /** Convert the class object to a string
     * @return The string representation of the Person object
     */
    public String toString()
    
    {
        String s = "";
        
        if (gender == 'F')
            s += "female, ";
            
        else if (gender == 'M')
            s += "male, ";
            
        else
            s += "unknown, ";
            
        s += ageRange + "'s, ";
        s += height + "m";
        
        return s;
    }       
}
