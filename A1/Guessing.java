/*
 * Last Modified:   01/30/2013 14:13 MST
 *
 * Author:          Michael Hung
 * UCID:            10099049
 * Course:          CPSC 233
 * Tutorial:        T03 w/ Yongxin Liu
 * Assignment:      One (1)
 *
 * External source code used, courtesy of Professor Tam:
 *      - Getting the command-line input
 *      - Reading from the file
 *      - Converting the lines from file to numeric form.
 *
 * For this guessing game, the first nine lines of the file will be read, assuming there are in fact nine lines. All lines are assumed to contain 
 * one integer number per line. The first line's integer will be kept static, though will not be declared a constant. The remaining eight lines 
 * will be evaluated against this integer to be greater or lower. If none of the guesses match after 8 attempts, the game is over (winning and losing 
 * conditions have been defined). The program has been in written in such a way that after eight tries, the program will terminate regardless of whether 
 * there are still numbers after the ninth line. However, the program is limited in that:
 *
 *      1) If the specified input file does not exist within the working directory, a run-time error is generated.
 *      2) If there is any non-integer character within the contents of the file, a run-time error is generated.
 *      3) Interactive gameplay is not supported.
*/

import java.io.*;

public class Guessing
{
    public static void main(String [] args) throws Exception
    {
        FileReader fr = null;
        BufferedReader br = null;
        String filename = null;
        String lineFromFile = null;
        boolean finished = false;
        int num = -1;
        int compare = 0;
        int remain = 8;
    
        // If nothing is entered as an argument, or more than one argumement is provided, this informs the user of the correct usage of this program.
        
        if (args.length != 1)
        {
            System.out.println("Usage:java Guessing <name of input file>");
        }
        
        // Opens the input file and pipes the contents to a buffer.
        
        else
        {
            filename = args[0];
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            lineFromFile = br.readLine();

            // If there is nothing in the file, the following String will be shown and the program is terminated.
            
            if (lineFromFile == null)
            {
                System.out.println("Empty Input File: There are no guesses provided.");
                finished = true;
            }
            
            // If the file is not empty, then set compare to be the integer in the first line. num is also set to be the first integer, but 
            // the winning scenario prevents the program from assuming that you have guessed correctly without using any tries.
            
            else
            {
                compare = Integer.parseInt(lineFromFile);
                lineFromFile = br.readLine();
                num = Integer.parseInt(lineFromFile);
                
                // Prints an identification banner
                
                System.out.println("\nLast Name: Hung");
                System.out.println("First Name: Michael");
                System.out.println("Student ID: 10099049");
                System.out.println("Course: CPSC 233");
                System.out.println("Tutorial Section: T03 w/ Yongxin Liu");
                System.out.println("Assignment: 1");
                System.out.println("\nGuess a number from between 1 and 100, inclusive!");
            }
            
            // This while loop simulates the game.
            
            while (finished == false) 
            {    
            
                // Checks whether the value of num is within the range of accepted numbers. If not, a message is displayed and the program is terminated.
                // Otherwise, the program will continue normally.
                
                if (num < 1 || num > 100)
                {
                    System.out.println("\nWha-! Th... This number!!\nThis isn't between 1 and 100!\n...I explicitly instructed you to use a number between 1 and 100!\nWell, congratulations on failing to follow instructions!\nThis program will now terminate!\n\n\nBam! Kapow!! Goodbye!\n");
                    finished = true;
                    break;
                }
                
                else 
                {
                    lineFromFile = br.readLine();
                    
                    // Compares num and compare and generates a message based on whether num is greater than or lower than compare.
                    // The message will also output the number of tries remaining until the program automatically terminates.
                    // remain is decremented by 1 for every iteration of the loop.
                    
                    if (num != compare)
                    {
                        --remain;
                        
                        if (num < compare)
                        {
                            System.out.println("\nBzzt! Incorrect! " + num + " is lower than the correct number!\nYou have " + remain + " attempt(s) remaining.");
                        }
                        
                        else if (num > compare)
                        {
                            System.out.println("\nBzzt! Incorrect! " + num + " is greater than the correct number!\nYou have " + remain + " attempt(s) remaining.");
                        }
                    }
                
                    // Winning Scenario - if num and compare have the same numerical value, a congratulatory message is displayed, which also provides
                    // how many attempts it took to succeed. The program is terminated after the message is printed.
                
                    if (num == compare)
                    {
                        System.out.println("\nCongratulations!! You successfully guessed the correct number, " + compare + ", within " + (9-remain) + " attempt(s)!\n");
                        finished = true;
                        break;

                    }
                    
                    // If the number was not guessed within 8 guesses, the program will tell you that you have run out of guesses and what the correct number was.
                    // Program is terminated.
                    
                    if (remain == 0)
                    {
                        System.out.println("\nYou've run out of guesses! The correct number was " + compare + ". Sorry, but you've lost the game. :c\n");
                        finished = true;
                        break;
                    }

                    // If the number of lines in the input file is less than 8, a message will be printed saying that not all of the attempts were used, and 
                    // how many attempts remained. Program is terminated.
                                      
                    if (lineFromFile == null && remain > 0)
                    {
                        System.out.println("\nWhy did you stop? You still had " + remain + " attempt(s)!\n");
                        finished = true;
                        break;
                    }
              
                    // If none of the above are applicable, then read the next line in the file.
                    
                    if (lineFromFile != null)
                    {
                        num = Integer.parseInt(lineFromFile);
                    }   
                }
            }
        }
    }
}
