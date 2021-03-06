/** 
 * Driver.java:  A driver class for assignment 4. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 4
 */
import java.io.*;

public class Driver
{
    // The main method made this class the driver class
    public static void main (String[] args) throws IOException
    {
        // Getting the file name from the command line
        if (args.length != 2)
        {
            System.out.println("Usage: java Driver <suspect input> <oracle input>");
            System.exit(0);
        }
        String suspectInput = args[0];
        String oracleInput = args[1];
        
        // Create the oracle and pass it the input file
        FileReader file = new FileReader(oracleInput);
        BufferedReader buffer = new BufferedReader(file);
        String line = buffer.readLine();
        Oracle theOracle = new Oracle(line);
        
        // Create a dectective
        Detective detective = new Detective(theOracle);
        
        // Read each line of the file
        file = new FileReader(suspectInput);
        buffer = new BufferedReader(file);
        line = null;
        line = buffer.readLine();
        int count = 0;
        boolean finished = false;
        while (line != null && !finished)
        {
            if (detective.check(line))
                finished = true;
                
            count ++;
            line = buffer.readLine();
        }
        
        System.out.println("Number to times the Oracle is queried: " + theOracle.getCount());
        System.out.println("Number of suspects checked: " + count);
        System.out.println("Detective found: \n" + detective);
    }        
}
