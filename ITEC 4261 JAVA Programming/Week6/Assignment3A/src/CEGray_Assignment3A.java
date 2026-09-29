/* Casey Gray
 * ITEC 4261 Section 02
 * February 23, 2025
 */

/*
Credit card numbers follow certain patterns. A credit card number must be between 13 and 16 digits. It must start with:
4 for Visa cards
5 for Master cards
37 for American Express cards
6 for Discover cards
 
In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card numbers. The algorithm is useful to determine if a card number
is entered correctly or if a credit card is scanned correctly by a scanner. Almost all credit card numbers are generated following this
validity check, commonly known as the Luhn check or the Mod 10 check, which can be described as follows (for illustration, consider the card
number 4388576018402626):
 
1. Double every second digit from right to left. If doubling a digit results in a two-digit number, add up the two digits to get a
single-digit number.
2 * 2 = 4
2 * 2 = 4
4 * 2 = 8
1 * 2 = 2
6 * 2 = 12 (1 + 2 = 3)
5 * 2 = 10 (1 + 0 = 1)
8 * 2 = 16 (1 + 6 = 7)
4 * 2 = 8
 
2. Now add all single-digit numbers from Step 1.
4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37
 
3. Add all digits in the odd places from right to left in the card number.
   6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38
 
4. Sum the results from Step 2 and Step 3.
37 + 38 = 75
 
5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise, it is invalid. For example, the number
4388576018402626 is invalid, but the number 4388576018410707 is valid.
 
Write a method called validateCard that determines whether the number is valid or invalid and returns a Boolean value.
 
In the Main method get the user’s credit card number and card type.  Use the method to determine if the card number is valid and display
the card type, number and whether it is valid or invalid.
 */

import java.util.Scanner;
public class CEGray_Assignment3A {

	public static void main(String[] args) {
		// Declare variables
		Scanner in = new Scanner(System.in);
		String cardNum = "";
		String cardType;
		boolean isValid;
		
		// Prompt user for credit card number
		System.out.print("Enter a credit card number as a long integer: ");
		cardNum = in.nextLine();
		
		// Close scanner
		in.close();
		
		// Run functions for getting card type and if card is valid
		cardType = getCardType(cardNum);
		isValid = validateCard(cardNum);
		
		// Display results
		System.out.println(cardType + " " + cardNum + " " + (isValid ? "is valid." : "is invalid."));

	}
	
	// Function for validating card
	public static boolean validateCard(String cardNum)
	{
		// Declare variables for card length, the first digit of the card, and if the sum is even or odd
		int length = cardNum.length();
		char firstDigit = cardNum.charAt(0);
		// Variables to store the sums of digits at even and odd positions when counting from the right
		int sumEven = 0;
		int sumOdd = 0;
		
		// Determine if card is correct length
		if (length < 13 || length > 16)
		{
			return false;
		}
		
		// Determine if the first digit is valid for the card types
		if (firstDigit != '4' && firstDigit != '5' && firstDigit != '6' && cardNum.startsWith("37"))
		{
			return false;
		}
		
		// Determine if the card is valid by iterating through the card number from right to left
		for (int i = length - 1; i >= 0; i--)
		{
			// Convert the character at the current position into an integer
			int digit = Character.getNumericValue(cardNum.charAt(i));
			
			// if statement for even positions from right
			if ((i % 2) == 0)
			{
				int doubled = digit * 2;
				// If the doubled value is > 9, get the remainder when divided by 10 (the right digit) and the quotient
				// when divided by 10 (the left digit). Add them together to get the sum for even positions
				if (doubled > 9)
				{
					sumEven += (doubled > 9) ? (doubled % 10) + (doubled / 10) : doubled;
				}
				else
				{
					sumEven += doubled;
				}
			}
			
			// Odd positions from right
			else
			{
				sumOdd += digit;
			}
		}
		
		// Calculates the sum of sumEven and sumOdd and divides by 10. If the remainder is 0, returns true, otherwise, returns false
		return (sumEven + sumOdd) % 10 == 0;
	}
	
	// Function for determining card type
	public static String getCardType(String cardNum)
	{
		// Check first number to determine if card is visa, mastercard, discover, amex, or an unknown card
		if (cardNum.startsWith("4"))
		{
			return "Visa";
		}
		else if (cardNum.startsWith("5"))
		{
			return "MasterCard";
		}
		else if (cardNum.startsWith("6"))
		{
			return "Discover";
		}
		else if (cardNum.startsWith("37"))
		{
			return "American Express";
		}
		else
		{
			return "Unknown card type";
		}
		
	}

}
