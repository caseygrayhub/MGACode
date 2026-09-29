
import java.util.Scanner;
/**
  Casey Gray
  Assignment 1 Part A
  January 26, 2025
 */



/**
 Write a program that reads in investment amount, annual interest rate, and number of years,
 and displays the future investment value using the following formula:

futureInvestmentValue =  investmentAmount * (1 + monthlyInterestRate)numberOfYears*12

Note: divide the annual interest rate by 1200 to get the monthly interest rate for the calculation.

For example, if you enter amount 1000, annual interest rate 3.25%, and number of years 1,
the future investment value is 1032.98.

Hint: Use the Math.pow(a, b) method to compute a raised to the power of b. 

Make sure your input requests clearly indicate what the user is expected to enter and that your
output statements clearly indicate what is being displayed.
 */
public class CEGrayA1A {

	public static void main(String[] args) {
		// Declare variables
		Scanner input = new Scanner(System.in);
		double investmentAmount;
		double annualInterestRate;
		int years;
		double monthlyInterestRate;
		double futureInvestmentValue;
		
		// Get input from user
		System.out.print("Enter investment amount: ");
		investmentAmount = input.nextDouble();
		
		// Get annual interest rate, in percentage from user, and calculate
		System.out.print("Enter the annual interest rate: ");
		annualInterestRate = input.nextDouble() / 100;
		
		// Get number of years from user
		System.out.print("Enter number of years: ");
		years = input.nextInt();
		
		// Close input scanner
		input.close();
		
		// Calculate the monthly interest rate
		monthlyInterestRate = annualInterestRate / 12;
		
		// Calculate the future investment value
		futureInvestmentValue = investmentAmount * Math.pow((1 + monthlyInterestRate), years * 12);
		
		// Display result
		System.out.printf("Future investment value: $%.2f\n", futureInvestmentValue);

	}

}
