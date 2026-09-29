import java.util.Scanner;
/** Casey Gray
 	Assignment 1 Part B
	January 26, 2025
/*



/**
 Write a program that prompts the user to enter the numerator and denominator of a fraction number
 and determines whether it is a proper fraction and improper fraction.

For an improper fraction number, display its mixed fraction in the form of a + b / c if b % c is not zero;
otherwise, display only the integer.

For example: 16 / 3 is an improper fraction, and its mixed fraction is 5 + 1 / 3.

Make sure your input requests clearly indicate what the user is expected to enter and that your
output statements clearly indicate what is being displayed.
 */
public class CEGrayA1B {

	public static void main(String[] args) {
		// Declare variables
		Scanner input = new Scanner(System.in);
		int numer;
		int den;
		int whole;
		int remain;
		
		// Get numerator from user
		System.out.print("Enter the numerator of the fraction: ");
		numer = input.nextInt();
		
		// Get denominator from user
		System.out.print("Enter the denominator of the fraction: ");
		den = input.nextInt();
		
		// Close scanner
		input.close();
				
		// Check if the denominator is zero
		if (den == 0) {
			System.out.println("Error: Denominator cannot be a zero.");
			return;
		}
				
		// Determine if the fraction is proper or improper
		if (numer < den) {
			System.out.print(numer + "/" + den + " is a proper fraction.");
		}
		else {
			System.out.print(numer + "/" + den + " is an improper fraction");
		
			// Calculate the mixed fraction
			whole = numer / den;
			remain = numer % den;
			
			// Display the results
			if (remain != 0) {
				System.out.print(", and its mixed fraction is " + whole + " + " + remain + " / " + den);
			}
			else {
				System.out.print(", and its whole number is " + whole);
			}
		}
	}

}
