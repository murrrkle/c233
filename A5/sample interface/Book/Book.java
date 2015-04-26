/*
  Author:  James Tam
  Version: February 3, 2010

  Feb 3 2010: Changed the constructor to set the attributes via the mutator method
  rather than doing it directly.

  A 'filler' class that provides the data that will be stored and tracked by
  the Manager class.
*/

public class Book
{
    private String name;
    public Book (String aName) 
    { 
	setName(aName); 
    }
    public void setName (String aName) 
    { 
	name = aName; 
    }
    public String getName () 
    { 
	return name; 
    }
}
