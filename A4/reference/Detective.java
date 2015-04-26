/** 
 * Detective.java: The detective that reasons about the murder based on information provided 
 *                 and the response from the Oracle. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 4
 */
 
public class Detective
{
    private Person murderer;
    private Location where;
    private Time when;
    private Oracle theOracle;
    
    /** Constructor 
     * @param ora The reference to the Oracle 
     */
    public Detective (Oracle ora)
    {
        murderer = new Person();
        where = new Location();
        when = new Time();
        theOracle = ora;
    }
    
    public boolean check (String line)
    {
        // Separte the information into three categories
        String[] categories = line.split("; ");
        String[] info;
        
        // Check the person if not yet defined
         if (!murderer.isComplete())
         {
             info = categories[0].split(", ");
             checkPerson(info[0].charAt(0), Integer.parseInt(info[1]), Double.parseDouble(info[2]));
         }
         else
         {
             System.out.println("Skip the person info.");
         }
         
         // Check the location if not yet defined
         if (!where.isComplete())
         {
             info = categories[1].split(", ");
             checkLocation(info[0], info[1], info[2]);
         }
         else
         {
             System.out.println("Skip the location info.");
         }
         
         // Check the location if not yet defined
         if (!when.isComplete())
         {
             info = categories[2].split(":");
             checkTime(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
         }
         else
         {
             System.out.println("Skip the time info.");
         }
         
         // Stop if all information are found
         if (murderer.isComplete() && where.isComplete() && when.isComplete())
             return true;
         else
             return false;
    }
    
    private boolean checkPerson (char gender, int range, double height)
    {
        Person suspect = new Person (gender, range, height);
        
        // Check the suspect information against the known possible murderer information
        // Stop checking any information does not match with the known info
        int fullScore = 0;
        System.out.println("Murder: " + murderer);
        if (murderer.getGender() != 'U')
            gender = 'U';
        else
            fullScore ++;
        if (murderer.getAgeRange() != 0)
            range = 0;
        else
            fullScore ++;
        if (murderer.getHeight() > 0)
            height = 0;
        else
            fullScore ++;
            
        // Check with the Oracle
        System.out.println("Check person: " + gender + ", " + range + ", " + height);
        int score = theOracle.checkPerson(suspect);
        
        if (score == 0)
            return murderer.isComplete();
        
        // If all criteria matches, then set all attributes
        if (score == fullScore)
        {
            if (murderer.getGender() == 'U')
                murderer.setGender(gender);
            if (murderer.getAgeRange() == 0)
                murderer.setAgeRange(range);
            if (murderer.getHeight() <= 0)
                murderer.setHeight(height);
        }
        
        System.out.println("Score = " + score + " and fullScore = " + fullScore);
        
        // Check the gender if it was checked with the Oracle
        if (gender != 'U')
        {
            System.out.println("Check person: " + gender);
            suspect = new Person (gender, 0, 0);
            if (theOracle.checkPerson(suspect) > 0)
            {
                murderer.setGender(gender);
                score--;
                if (score == 0)
                    return murderer.isComplete();
            }
        }
        
        // Check the age range if it was checked with the Oracle
        if (range != 0)
        {
            System.out.println("Check person: " + range);
            suspect = new Person ('U', range, 0);
            if (theOracle.checkPerson(suspect) > 0)
            {
                murderer.setAgeRange(range);
                score--;
                if (score == 0)
                    return murderer.isComplete();
            }
        }

        // Check the height if it was checked with the Oracle
        if (height > 0)
        {
            System.out.println("Check person: " + height);
            suspect = new Person ('U', 0, height);
            if (theOracle.checkPerson(suspect) > 0)
            {
                murderer.setHeight(height);
                score--;
                if (score == 0)
                    return murderer.isComplete();
            }
        }
        
        return murderer.isComplete();    
    }
    
    private boolean checkLocation (String place, String city, String province)
    {
        //System.out.println("checking location info: " + place + ", " + city + ", " + province);
        Location loc = new Location (place, city, province);
        boolean[] match = new boolean[3];
        for (int i = 0; i < 3; i++)
            match[i] = false;
        
        // Check the location against the known possible location information
        // Stop checking if the province or city does not match with the known location info
        if (!where.getProvince().equals(province) && !where.getProvince().equals(""))
            return where.isComplete();
        else if (where.getProvince().equals(province) && !where.getProvince().equals(""))
            match[0] = true;
            
        if (!where.getCity().equals(city) && !where.getCity().equals(""))
            return where.isComplete();
        else if (where.getCity().equals(city) && !where.getCity().equals(""))
            match[1] = true;
        
        // Check with the oracle
        //System.out.println("Checking the location with the oracle.");
        //System.out.println("complete: " + where.isComplete());
        int score = theOracle.checkLocation(loc);
        if (score == 0)
            return where.isComplete();
        
        //System.out.println("score = " + score);
        // Assume that no province has the same city name, and no city has same place name,
        // If one criteria matches, it must be the province.
        if (score >= 1 && !match[0])
            where.setProvince(province);
        // If two criteria maches, it must be the province and the city
        if (score >= 2 && !match[1])
            where.setCity(city);
        if (score == 3 && !match[2])
            where.setPlace(place);
        
        return where.isComplete();
    }
    
    private boolean checkTime (int hr, int min)
    {
        when = new Time (hr, min);
        
        double diff = theOracle.checkTime(when);
        when.adjustTime(diff);
        
        return when.isComplete();
    }
    
    public String toString()
    {
        String str = "Person: " + murderer.toString() + "\n";
        str += "Location: " + where.toString() + "\n";
        str += "Time: " + when.toString() + "\n";
        
        return str;
    }
}
