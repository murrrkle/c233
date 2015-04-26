import java.util.Scanner;

/*
  Author:  James Tam
  Version: February 3, 2010

  (Feb 3 2010): Replaced input routines that were implemented with classes from the 
  tio package with the standard Java Scanner class.

  This class performs list management functions for an array of references to Foo:
  * Displaying the list.
  * Adding elements to the end of the list.
  * Deleting elements from the end of the list.
*/

public class Manager
{
    public final int MAX_ELEMENTS = 10;    
    private Book [] bookList;
    private int lastElement;

    /*
      The no-argument constructor allocates memory for the array of references
      to instances of class Foo.  No array elements refer to yet to any instances
      (each element is set to null).
     */
    public Manager ()
    {
	bookList = new Book[MAX_ELEMENTS];
	int i;
	for (i = 0; i < MAX_ELEMENTS; i++)
	{
	    bookList[i] = null;
	}
	// No elements in list so the last element is set to a value lower than
	// the smallest array element.
	lastElement = -1;
    }

    /*
      This method iterates through the array and display the data value for each
      Book or an error message if the list is empty.
     */
    public void display()
    {
	int i;
	System.out.println("Displaying list");
	if (lastElement == -1)
	    System.out.println("\tList is empty");
	for (i = 0; i <= lastElement; i++)
	{
	    System.out.println("\tTitle No. " + (i+1) + ": "+ bookList[i].getName());
	}
    }
    
    /*
      This method adds a new element to the end of list until the list is full 
      (current maximum capacity of 10 elements)
     */
    public void add ()
    {
	String newName;
	Scanner in;

	if ((lastElement+1) < MAX_ELEMENTS)
	{
	    System.out.print("Enter a title for the book: ");
          in = new Scanner (System.in);
          newName = in.nextLine ();
	    lastElement++;
	    bookList[lastElement] = new Book(newName);
	    System.out.println("Book " + newName + " added");
	}
	else
	{
	    System.out.print("Cannot add new element: ");
	    System.out.println("List already has " + MAX_ELEMENTS + " elements.");
	}
	    
    }

    /*
      This method will remove the last element from the list or an error message if
      the list is already empty.
     */
    public void remove ()
    {
	if (lastElement > -1)
	{
	    bookList[lastElement] = null;
	    lastElement--;
	    System.out.println("Last element removed from list.");
	}
	else
	{
	    System.out.println("List is already empty: Nothing to remove");
	}
    }
}
