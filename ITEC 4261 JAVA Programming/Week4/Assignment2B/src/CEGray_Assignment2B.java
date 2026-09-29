/* Casey Gray
 * ITEC 4261 Section 02
 * February 9, 2025
 */

/*
 * Write a program that reads integers, finds the largest of them, and counts its occurrences.
 * Assume that the input ends with number 0. Suppose that you entered 3 5 2 5 5 5 0; the program finds that
 * the largest is 5 and the occurrence count for 5 is 4.
 * (Hint: Maintain two variables, max and count. max stores the current max number, and count stores its
 * occurrences. Initially, assign the first number to max and 1 to count. Compare each subsequent number
 * with max. If the number is greater than max, assign it to max and reset count to 1. If the number is
 * equal to max, increment count by 1.)
 */
import java.util.Scanner;
public class CEGray_Assignment2B {

	public static void main(String[] args) {
	
		// Declare variables
		Scanner input = new Scanner(System.in);
		int max;
		int count = 0;
		int num;
		
		// Prompt user to input numbers
		System.out.print("Enter integers: ");
		
		// Initialize max to the smallest integer
		max = Integer.MIN_VALUE;
		
		// Read input until zero is entered
		while ((num = input.nextInt()) != 0)
		{
			// Replace max to larger number, if new input is larger
			if (num > max) {
				max = num;
				
				// Reset counter since a new maximum is found
				count = 1;
			}
			// Increment count if the number is equal to the current maximum number
			else if (num == max)
			{
				count++;
			}
		}
		
		// Close scanner
		input.close();
		
		// Check if no numbers were entered besides 0
		if (max == Integer.MIN_VALUE && count == 0)
		{
			System.out.println("No numbers were entered.");
		}
		else
		{
			System.out.println("The largest number is " + max);
			System.out.println("The occurrence count of the largest number is " + count);
		}
	}

}
