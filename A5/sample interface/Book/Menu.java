import java.util.Scanner;

/*
   Author:  James Tam
   Version: February 3, 2010

  (Feb 3 2010): Replaced input routines that were implemented with classes from the 
  tio package with the standard Java Scanner class.
   A class for displaying a menu and processing the user's selections.
*/

public class Menu
{
   private Manager aManager;
   private String menuSelection;
   
   public Menu ()
   {
       aManager = new Manager ();
	 menuSelection = null;
   }


   public void display ()
   {
	System.out.println("\n\nLIST MANAGEMENT PROGRAM: OPTIONS");
	System.out.println("\t(d)isplay list");
	System.out.println("\t(a)dd new book to end of list");
	System.out.println("\t(r)emove last book from the list");
	System.out.println("\t(q)uit program");
	System.out.print("Selection: ");
   }

   public void getSelection ()
   {
	Scanner in = new Scanner (System.in);
      menuSelection = in.nextLine ();
   }

   public void processSelection ()
   {
      do 
      {
	  display();
	  getSelection();
	
	  if (menuSelection.equalsIgnoreCase("d"))
		aManager.display ();
	  else if (menuSelection.equalsIgnoreCase("a"))
		aManager.add ();
	  else if (menuSelection.equalsIgnoreCase("r"))
		aManager.remove ();
	  else if (menuSelection.equalsIgnoreCase("q"))
		System.out.println ("Quitting program.");
	  else
		 System.out.println("Please enter one of 'd','a','r' or 'q'");
       } while (!(menuSelection.equalsIgnoreCase("q")));
   }
}
