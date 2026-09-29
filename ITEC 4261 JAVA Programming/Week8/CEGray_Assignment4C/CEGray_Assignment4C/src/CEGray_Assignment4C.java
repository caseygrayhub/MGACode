/* Casey Gray
 * ITEC 4261 Section 02
 * March 16, 2025
 */

/*
 * Write the following method that returns the location of the largest element in a two-dimensional array. 

public static int[] locateLargest(double[][] a)

The return value is a one-dimensional array that contains two elements. These two elements indicate the row and column indices of the largest element in the two-dimensional array. Write a test program in the Main method that prompts the user to enter a two-dimensional array and displays the location of the largest element in the array. Here is a sample run:

<Output>

Enter the number of rows and columns of the array: 3 4

Enter the array:

23.5 35 2 10

4.5 3 45 3.5

35 44 5.5 9.6

The location of the largest element is at (1, 2)

<End Output>
 */
import java.util.Scanner;

 public class CEGray_Assignment4C {

    // Create a method that returns the location of the largest element in a two-dimensional array.
    public static int[] locateLargest(double[][] a)
    {
        // Make sure the array is not null or empty
        if (a == null || a.length == 0 || a[0].length == 0)
        {
            return null;
        }

        // Initialize variable to store the row and column of the largest element
        // and sets the largest element to the first element of the array
        int[] location = new int[2];
        double largest = a[0][0];
        
        // Sets largest to 0-0
        location[0] = 0;
        location[1] = 0;

        // Iterate through the array, comparing each element with largest
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                if (a[i][j] > largest)
                {
                    largest = a[i][j];
                    location[0] = i;
                    location[1] = j;
                }
            }
        }
        
        // Return the location of the largest element
        return location;
    }

    public static void main(String[] args) {
        // Declare variables
        Scanner in = new Scanner(System.in);

        // Ask user for how many rows/columns are in the array
        System.out.print("Enter the number of rows and columns of the array: ");
        int rows = in.nextInt();
        int columns = in.nextInt();

        double[][] array = new double[rows][columns];

        // Prompt user for the array
        System.out.println("Enter the array:");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                array[i][j] = in.nextDouble();
            }
        }

        // Call the locateLargest method to find the location of the largest element
        int[] location = locateLargest(array);

        // Make sure input is not null
        if (location != null)
        {
            System.out.println("The location of the largest element is at (" + location[0] + ", " + location[1] + ")");
        }
        // Return error if input is null
        else
        {
            System.out.println("Invalid input array.");
        }

        // Close scanner
        in.close();
    }
}
