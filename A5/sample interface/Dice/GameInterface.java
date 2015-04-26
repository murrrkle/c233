import java.util.Scanner;

public class GameInterface
{
    private Scanner in;
    private boolean done;
    private Dice aDice;

    public GameInterface ()
    {
	in = new Scanner(System.in);
	done = false;
	aDice = new Dice();
    }

    public void displayMenu ()
    {
	System.out.println("(d)ouble roll");
	System.out.println("(r)oll die");
	System.out.println("(q)uit game");
	System.out.print("Selection: ");
    }

    public void processMenu (char selection)
    {
	System.out.println();
	switch(selection)
	{
	     case 'D':
	     case 'd':
		 System.out.println("Roll two dice!");
	         aDice.rollTwo();
	         break;

	     case 'R':
	     case 'r':
		 System.out.println("Roll the die");
	         aDice.rollOne();
	     break;

	     case 'Q':
	     case 'q':
		 done = true;
	         break;

	     default:
		 System.out.println("Please enter 'd', 'r' or 'q'");
	}
	System.out.println();
    }


    public void start ()
    {
	final int FIRST = 0;
	String line  = null;
	char selection = ' ';
	while (done == false)
	{
	    displayMenu();
	    line = in.nextLine();
	    selection = line.charAt(FIRST);
	    processMenu(selection);
	}
    }
}