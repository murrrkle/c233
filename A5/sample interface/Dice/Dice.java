import java.util.Random;

public class Dice
{
    public final int NUM_SIDES = 6;

    private Random aGenerator;

    public Dice ()
    {
	aGenerator = new Random();
    }

    public void rollOne ()
    {
	int die = aGenerator.nextInt(NUM_SIDES)+1;
	System.out.println("Die roll: " + die);
    }

    public void rollTwo ()
    {
	int die1 = aGenerator.nextInt(NUM_SIDES)+1;
	int die2 = aGenerator.nextInt(NUM_SIDES)+1;
	int total = die1 + die2;
	System.out.println("Die roll: " + total);
    }

}