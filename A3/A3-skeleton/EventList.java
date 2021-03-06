/** 
 * EventList.java: Managing a list of events <br>
 * Copyright (c) 2013 Mea Wang. All rights reserved.
 *
 * @author Mea Wang
 * @version CPSC 233, skeleton class for Assignment 3
 */

/********************************************************************************
 * Last Modified: 03/07/2013 03:28 MST                                          *
 *                                                                              *
 * Last Name:           Hung                                                    *
 * First Name:          Michael                                                 *
 * Student ID:          10099049                                                *
 * Course:              CPSC 233                                                *
 * Tutorial Section:    03                                                      *
 * Assignment:          3                                                       *
 *                                                                              *
 * The core implementation of the "Linked Lists" was adapted                    *
 * from Dr. Wang's lecture slides on BlackBoard.                                *
 *                                                                              *
 * This class uses another class - the Event class. It is                       *
 * defined in Event.class within the same directory.                            *
 *                                                                              *
 * This class is an integral part of a simple OS simulation                     *
 * which uses linked lists to keep track of a number of Events.                 *
 * Each Event is assigned an integer - the number of times                      *
 * that it will be run in the duration of the program. Each                     *
 * time that it is run, the integer is decremented. When                        * 
 * the duration reaches 0, the Event is removed from the                        *
 * linked list. This continues until all Events have reached                    *
 * 0. This class contains the methods that:                                     *
 *                                                                              *
 *          - Adds new Events to a new linked list                              *
 *          - Converts the list to a human readable String                      *
 *          - 'Runs' the Events in the list                                     *
 *          - Prints a Student Identification Banner                            *
 *                                                                              *
 * This program is not prepared to handle exceptions of                         *
 * the following:                                                               *
 *                                                                              *
 *          - When the input file contains anything other than integers         *
 *          - If the input file does not exist in the working directory         *
 *                                                                              *
 * This program does not have the following features:                           *
 *                                                                              *
 *          - Manual insertion of Events into the list                          *
 *          - Manual removal Events from the list                               *
 *                                                                              *
 * Note that this linked list implementation does not take care of the          *
 * possibltt security risk since curr remains in memory.                        *
 ********************************************************************************/
 
public class EventList
{
    private Event head;
    private Event end;

    /** Default constructor: create an empty list */
    public EventList ()
    {
        head = null;
        end = null;
    }
    
    /** Add a new event to the end of the linked list
     * @param duration The duration of the event
     */
    public void addEvent (int duration)
    
    {
        Event newEvent = new Event (duration);
        
        if (head == null)
        
        {
            head = newEvent;
            end = newEvent;
            return;
        }
        
        if (end.getNext () == null)
        
        {
            end.setNext (newEvent);
            end = end.getNext ();
            return;
        }
    }
        
    /** A method compiling the event list into a string
     * @return A string representation of the linked list
     */
    public String toString ()
    
    {
        String str = "";
        for (Event curr = head; curr != null; curr = curr.getNext ())
        
        {
            if (curr == head)
            
            {
                str += curr.toString ();
            }
            
            else
            
            {
                str += ", " + curr.toString ();
            }
        }

        return str;
        
    }
    
    /** Process each event by calling the run() method in the Event class.  
     *  An event is removed from the list if the remaining time returned by the run() method reaches 0.  
     * @return False if the list is empty, true otherwise
     */
    public boolean process ()
    
    {   

        Event prev = null;

        if (head == null)
        
        {
            return false;
        }
        
        for (Event curr = head; curr != null; curr = curr.getNext ())
        
        {
            if (curr.run () < 1)
            
            {
                if (curr == head)
                
                {
                    head = curr.getNext ();
                }
                
                else
                
                {
                    prev.setNext(curr.getNext ());
                }
            }
            
            prev = curr;
            
        }
        
        return true;
        
    }
    
    /** Print the banner of the output */
    public void printBanner ()
    
    {
        System.out.println ("\nLast Name:\t\tHung");
        System.out.println ("First Name:\t\tMichael");
        System.out.println ("Student ID:\t\t10099049");
        System.out.println ("Course:\t\t\tCPSC 233");
        System.out.println ("Tutorial Section:\t03");
        System.out.println ("Assignment:\t\t3");
        System.out.println ();
    }
}
