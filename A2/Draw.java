/****************************************************************************************************************************************************
 *                                                                                                                                                  *
 * Last Modified:   02/14/2013 16:02 MST                                                                                                            *
 *                                                                                                                                                  *
 * Author:          Michael Hung                                                                                                                    *
 * UCID:            10099049                                                                                                                        *
 * Course:          CPSC 233                                                                                                                        *
 * Tutorial:        T03 w/ Yongxin Liu                                                                                                              *
 * Assignment:      Two (2)                                                                                                                         *
 *                                                                                                                                                  *
 *                                                                                                                                                  *
 * This class contains a number of methods that either draws a shape out of some                                                                    *
 * given character or returns the number of certain shapes drawn. Can draw rectangles                                                               *
 * and right angles triangles of two different orientations. Left Triangles are drawn                                                               *
 * with the right angle on the upper left corner while Right Triangles are drawn                                                                    *
 * with the right angle on the bottom right corner.                                                                                                 *
 *                                                                                                                                                  *
 ****************************************************************************************************************************************************/
 
public class Draw

{
    private int numRectangles = 0;
    private int numLeftTriangles = 0;
    private int numRightTriangles = 0;
    
    public int getTotalRectangles ()

    {
        return numRectangles;
    }

    public int getTotalLeftTriangles ()

    {
        return numLeftTriangles;
    }

    public int getTotalRightTriangles ()

    {
        return numRightTriangles;
    }

    public void drawRectangle (char fill, int height, int width)

    {
        if ((width < 10 && width > 0) && (height < 10 && height > 0))

        {
            System.out.print ("\n");

            for (int i = 1; i <= height; i++)

            {
                for (int j = 1; j <= width; j++)

                {
                    System.out.print (fill);
                }

                System.out.print ("\n");
            }

            numRectangles ++;
        }

        else

        {
            if (width > 10 || width < 0)
            
            {   
                System.out.println("\n" + width + " is an invalid width parameter. Recatngles must have a width of between 1 and 9, inclusive.");   
            }
            
            if (height > 10 || height < 0)
            
            {
                System.out.println ("\n" + height + " is an invalid height parameter. Rectangles must have a height of between 1 and 9, inclusive.");
            }
        }
    }

    public void drawLeftTriangle (char fill, int size)

    {
        int columnMax = size;

        System.out.print ("\n");

        if ((size > 1) && (size < 10))
        
        {
            for (int i = 1; i <= size; i++)

            {
                for (int j = 1; j <= columnMax; j++)

                {
                    System.out.print (fill);
                }

                System.out.print ("\n");
                columnMax --;
            }

            numLeftTriangles ++;
        }
        
        else
        
        {
            System.out.println (size + " is an invalid parameter. Triangles must have a size between 2 and 9, inclusive.");
        }
    }

    public void drawRightTriangle(char fill, int size)

    {
        int columnMax = size;
        int columnConstraint = (size - 1);

        System.out.print ("\n");   

        if ((size > 1) && (size < 10))
        
        {
            for (int i = 1; i <= size; i++)

            {
                for (int j = 1; j <= (columnConstraint); j++)

                {
                    System.out.print(" ");
                }

                for (int k = 1; k <= (columnMax - columnConstraint); k++)

                {
                    System.out.print (fill);
                }

                System.out.print ("\n");            
                columnConstraint --;
            }
            
            numRightTriangles ++;
        }
        
        else
        
        {
            System.out.println (size + " is an invalid parameter. Triangles must have a size between 2 and 9, inclusive.");
        }
    }
}
