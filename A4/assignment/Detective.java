/** 
 * Detective.java: The detective that reasons about the murder based on information provided 
 *                 and the response from the Oracle. <br>
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
 * This is the Detective class. It uses the classes
 * Person, Location, Time, and Oracle. Its purpose
 * is to identify the true 'murderer', defined by 
 * oracle.txt,  by querying the Oracle with a list 
 * of suspects, provided by suspects.txt.
 *
 * When the Detective has found the murderer, the
 * murderer's information is printed in a certain
 * format by way of the toString method.
 *
 * The algorithm has not been optimized so the 
 * Detective is completely reliant on the Oracle.
 * Max number of queries are made.
*********************************************************/

public class Detective
{
    private Person murderer;
    private Person suspect;
    private Location murderLocation;
    private Location suspectLocation;
    private Time murderTime;
    private Time suspectTime;
    private Oracle theOracle;
    
    /** Constructor 
     * @param ora The reference to the Oracle 
     */
    public Detective (Oracle ora)
    
    {
        theOracle = ora;
	suspect = null;
	suspectLocation = null;
	suspectTime = null;
        murderer = new Person('U', 0, 0);
        murderLocation = new Location(0, 0);
        murderTime = new Time();

	printBanner();
    }
    /** Queries the oracle about a suspect. Matching information is updated in murderer.
     * @param line The suspect's information
     */    
    public boolean check (String line)
    
    {
        String[] suspectInfo = line.split("; ");
        double suspectScore = 0;

 
        // From Oracle class
        String[] info;
        
        // Update the suspect's information
        info = suspectInfo[0].split(", ");
        suspect = new Person(info[0].charAt(0), Integer.parseInt(info[1]), Double.parseDouble(info[2]));
        suspectScore = theOracle.checkPerson(suspect);

        // Update the suspect's location
        info = suspectInfo[1].split(", ");
        suspectLocation = new Location(Double.parseDouble(info[0]), Double.parseDouble(info[1]));
        
        // Update the suspect's time
        info = suspectInfo[2].split(":");
        suspectTime = new Time(Integer.parseInt(info[0]), Integer.parseInt(info[1]));       
	
	// If the suspect's time matches the Oracle's murderer, update murdererTime.
	if (theOracle.checkTime(suspectTime) == 0)

	{
	    murderTime.setTime(suspectTime.getHour(), suspectTime.getMinute());
	}

	// If the suspect's gender  matches the Oracle's murderer, update murderer's gender.
	if (suspectScore < 100)

	{
	    murderer.setGender(suspect.getGender());
	    
	
	    // If the score is 0, then everything matches. Found the culprit.
	    if (suspectScore == 0)

		{
		    murderer.setAgeRange(suspect.getAgeRange());
		    murderer.setHeight(suspect.getHeight());
		}
	}

	// If the suspect's location matches the Oracle's murderer, update murdererLocation.
	if (theOracle.checkLocation(suspectLocation) == 0)

	{
	    murderLocation.setLocation(suspectLocation.getX(), suspectLocation.getY());
        }
        
        return false;
    }
    
    /** Allows the Detective to print the murderer's information once found.
     */
    public String toString ()
    
    {
        String summary = "";
        
         summary += "\nCulprit: " + murderer.toString();
         summary += "\nLocation: " + murderLocation.toString();
         summary += "\nTime: " + murderTime.toString();
        
        return summary;
    }

    /** Prints the student identification banner.
     */
    public void printBanner ()

    {
	System.out.println("Last Name:           Hung");
	System.out.println("First Name:          Michael");
	System.out.println("Student ID:          10099049");
	System.out.println("Course:              CPSC 233");
	System.out.println("Tutorial Section:    L03 w/ Yongxin Liu");
	System.out.println("Assignment:          4");
    }
}
