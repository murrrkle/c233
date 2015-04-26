/** 
 * Driver2.java:  A driver class for the event list class. <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, Assignment 3
 */
import java.io.*;

public class Driver2
{
    // The main method made this class the driver class
    public static void main (String[] args) throws IOException
    {
        // Getting the file name from the command line
        if (args.length != 1)
        {
            System.out.println("Usage: java Driver2 <intput file name>");
            System.exit(0);
        }
        String filename = args[0];
        
        // Open the file for read
        FileReader file = new FileReader(filename);
        
        // Initialize the buffer for reading the file
        BufferedReader buffer = new BufferedReader(file);
        String line = null;
        
        // Create a library
        EventList eList = new EventList();
        eList.printBanner();
        
        // Read each line of the file
        line = buffer.readLine();
        while (line != null)
        {
            // Add events to the list
            eList.addEvent (Integer.parseInt(line));
            
            //System.out.println(eList);
            line = buffer.readLine();
        }
        
        // Execute the events for one round
        eList.process();
        
        // Display the event list
        System.out.println(eList);
    }        
}
