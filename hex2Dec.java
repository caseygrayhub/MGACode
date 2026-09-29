// Casey Gray
// ITEC 4264
// August 29, 2025

import java.util.Scanner;

public class hex2Dec {

	// Recursive method to parse a hex string into a decimal int
	// hexStr = the hexadecimal string to be converted
	// Returns the decimal of the hex string
	public static int hex2Dec(String hexStr)
	{
		return hex2Dec(hexStr, 0, 0);
	}

	// Helper method with an index parameter for the recursion
	// hexStr = the hex string
	// index = the current character index to process
	// Returns the decimal value of the substring from the index
	private static int hex2Dec(String hexStr, int index, int total)
	{
		// If the index has reached the end of the string, return 0
		if (index == hexStr.length())
		{
			return total;
		}
		
		char hexChar = hexStr.charAt(index);
		int decVal;
		
		// Convert the hex value to its decimal value
		if (hexChar >= '0' && hexChar <= '9')
		{
			decVal = hexChar - '0';
		}
		else if(hexChar >= 'A' && hexChar <= 'F')
		{
			decVal = hexChar - 'A' +10;
		}
		else if(hexChar >= 'a' && hexChar <= 'f')
		{
			decVal = hexChar - 'a' +10;
		}
		// Handle invalid hex characters
		else
		{
			throw new NumberFormatException(hexChar + " is an invalid hexadecimal character.");
		}
		
		// Recursive step - multiply the current decimal value by 16 and add it to the end of the
		// recursive call. Processes the string from left to right
		total = total * 16 + decVal;
		return hex2Dec(hexStr, index + 1, total);
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a hex string: ");
		String hex = in.nextLine();
		
		try
		{
			int decVal = hex2Dec(hex);
			System.out.println("The decimal equivalent of " + hex + " is " + decVal);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
		in.close();
	}
}
