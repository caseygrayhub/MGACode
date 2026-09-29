/* Casey Gray
 * ITEC 4261 Section 02
 * February 9, 2025
 */

/*
 The international standard letter/number mapping found on the telephone
Write a program that reads a letter and displays its corresponding digit.
 */
import java.util.Scanner;
public class CEGray_Assignment2A {

	public static void main(String[] args) {
		
		// Declare variables
		Scanner input = new Scanner(System.in);
		String letter = "";
		char ch;
		int digit;
		
		// Ask user for a letter, and convert it to uppercase
		System.out.print("Enter a letter: ");
		letter = input.next().toUpperCase();
		
		// Close scanner
		input.close();
				
		// Check if input is valid
		if (letter.length() != 1 || !Character.isLetter(letter.charAt(0)))
		{
			System.out.print("Invalid input. Please enter a single letter.");
			return;
		}
		
		ch = letter.charAt(0);
		digit = getDigit(ch);
		
		// Check if a correct mapping is found
		if (digit != -1)
		{
			System.out.println("The corresponding digit for the letter " + ch + " is: " + digit);
		}
	}
	
	// Create function to determine corresponding number
	public static int getDigit(char ch) {
		switch (ch)
		{
		case 'A': case 'B': case 'C': return 2;
		case 'D': case 'E': case 'F': return 3;
		case 'G': case 'H': case 'I': return 4;
		case 'J': case 'K': case 'L': return 5;
		case 'M': case 'N': case 'O': return 6;
		case 'P': case 'Q': case 'R': case 'S': return 7;
		case 'T': case 'U': case 'V': return 8;
		case 'W': case 'X': case 'Y': case 'Z':return 9;
		// Return -1 if letter is not A-Z
		default: return -1;
		}
	}
}
