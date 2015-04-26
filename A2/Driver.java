/************************************************************************************************************************************
 *                                                                                                                                  *
 * Last Modified:   02/14/2013 16:02 MST                                                                                            *
 *                                                                                                                                  *
 * Author:          Michael Hung                                                                                                    *
 * UCID:            10099049                                                                                                        *
 * Course:          CPSC 233                                                                                                        *
 * Tutorial:        T03 w/ Yongxin Liu                                                                                              *
 * Assignment:      Two (2)                                                                                                         *
 *                                                                                                                                  *
 *                                                                                                                                  *
 * This program reads an input file where each line is assumed to be of the form, <Shape Type> <Element> <Dimensions>, where        *
 * Shape Type consists of two letters, RE (rectangle), LT (right-angled triangle with its 90 degree corner on the topmost           *
 * left corner), or RT (right-angled triangle with its 90 degree corner on the bottommost right corner), where Element consists of  *
 * any single character with which the shape will be drawn, and Dimensions consists of either two numbers from between 1 and 9 for  *
 * the rectangle's height and width, in that order, or one number between 2 and 9 for the base and height of the triangle, which    *
 * are the same.                                                                                                                    *
 *                                                                                                                                  *
 * This program assumes that the input file indicated does, in fact, exist within the working directory. If not, the lack of        *
 * exception handling for such a case will cause the program to crash.                                                              *
 *                                                                                                                                  *
 * The program is prepared to handle most format issues including:                                                                  *
 *      1) The shape type is not RE, LT, or RT                                                                                      *
 *      2) For Triangles, the shape size is less than 2 or greater than 9                                                           *
 *                                                                                                                                  *
 * However, the program is not able to handle these cases:                                                                          *
 *      1) The shape dimensions are non-integer values                                                                              *
 *      2) There is an empty line within the file                                                                                   *
 *                                                                                                                                  *
 * The code used for file reading was adapted from the Assignment 1 skeleton code provided by Professor Tam.                        *
 *                                                                                                                                  *
 ************************************************************************************************************************************/

import java.io.*;

public class Driver

{
	public static void main (String [] args) throws Exception

    {       
        FileReader fr = null;
        BufferedReader br = null;
        String fileName = null;
        
        String command = null;
        
        Draw shape = null;
        char shapeFill = ' ';
        String shapeType = null;
        String shapeSize = " ";

        final String RE = "RE";
        final String LT = "LT";
        final String RT = "RT";

        int rectangleHeight = 0; 
        int rectangleWidth = 0;
        
        if (args.length != 1) // If number of arguments is not 1, a message informs user of correct usage. Program terminates here.

        {
            System.out.println ("CorrectUsage: java Driver <name of input file>");
        }

        else  // Opens the input file and pipes the contents to a buffer.

        {
            fileName = args [0];
            fr = new FileReader (fileName);
            br = new BufferedReader (fr);

            command = br.readLine ();
            
            if (command == null) // If file is empty, a message is displayed indicating such. Program terminates here.

            {
                System.out.println ("Empty Input File: There are no instructions provided.");   
            }

            else

            {
                // Prints an Identification Banner
                System.out.println ("\nLast Name: Hung");
                System.out.println ("First Name: Michael");
                System.out.println ("Student ID: 10099049");
                System.out.println ("Course: CPSC 233");
                System.out.println ("Tutorial Section: T03 w/ Yongxin Liu");
                System.out.println ("Assignment: 2");

                shape = new Draw ();           
                
                while (command != null) // Parses each line and executes each instruction using methods defined in the Draw class.

                {      
                    shapeType = command.substring (0, 2);
                    shapeFill = command.charAt (2);
                    shapeSize = command.substring (3);
                    
                    if (shapeType.equalsIgnoreCase (RE)) // Instruction - Draw a Rectangle

                    {
                        rectangleHeight = Integer.parseInt (shapeSize.substring (0, 1));
                        rectangleWidth = Integer.parseInt (shapeSize.substring (1));
                            
                        shape.drawRectangle (shapeFill, rectangleHeight, rectangleWidth);
                    }
             
                    else if (shapeType.equalsIgnoreCase (LT)) // Instruction - Draw a Left Triangle       

                    {
                        shape.drawLeftTriangle (shapeFill, Integer.parseInt (shapeSize));
                    }
                    
                    else if (shapeType.equalsIgnoreCase (RT)) // Instruction - Draw a Right Triangle                    

                    {
                        shape.drawRightTriangle (shapeFill, Integer.parseInt (shapeSize));
                    }
                   
                    else // None of the above

                    {
                        System.out.println ("\n" + command + " is an invalid instruction.");
                    }

                    command = br.readLine ();
                }
                
                // Prints the total number of each shape drawn.
                System.out.println ("\nTotal shapes drawn: ");
                System.out.println ("\tRectangles: " + shape.getTotalRectangles ());
                System.out.println ("\tLeft Triangles: " + shape.getTotalLeftTriangles ());
                System.out.println ("\tRight Triangles: " + shape.getTotalRightTriangles () + "\n");   
            }
        }
    }
}
