/** 
 * Location.java:  A class containing the location information. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 4
 */

public class Location
{
    private String place;
    private String city;
    private String province;
    
    /** Default constructor */
    public Location ()
    {
        place = "";
        city = "";
        province = "";
    }
    
    /** Constructor
     * @param p The place
     * @param c The city
     * @param prov The province
     */
    public Location (String p, String c, String prov)
    {
        place = p;
        city = c;
        province = prov;
    }
    
    /** Check if the location information is complete.
     * @return True if all attributes are defined, false otherwise.
     */
    public boolean isComplete ()
    {
        return (!(place.equals("") || city.equals("") || province.equals(""))); 
    }
    
    /** Get the place
     * @return The place
     */
    public String getPlace ()
    {
        return place;
    }
    
    /** Get the city
     * @return The city
     */
    public String getCity ()
    {
        return city;
    }
    
    /** Get the province
     * @return The province
     */
    public String getProvince ()
    {
        return province;
    }
    
    /** Set the place
     * @param p The place
     */
    public void setPlace (String p)
    {
        place = p;
    }

    /** Set the city
     * @param c The city
     */
    public void setCity (String c)
    {
        city = c;
    }

    /** Set the province
     * @param prov The province
     */
    public void setProvince (String prov)
    {
        province = prov;
    }
        
    /** Match the given location with this location
     * @param loc The given location
     * @return The number of attributes matched
     */
    public int matches (Location loc)
    {
        int match = 0;
        
        if (place.equals(loc.getPlace()))
            match ++;
        
        if (city.equals(loc.getCity()))
            match ++;
        
        if (province.equals(loc.getProvince()))
            match ++;
        
        return match;
    }
    
    /** Conver the class object to a string
     * @return The string representatio of the Location object
     */
    public String toString()
    {
        String str = place + ", ";
        str += city + ", ";
        str += province;
        
        return str;
    }       
}
