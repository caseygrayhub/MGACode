/* Casey Gray
 * ITEC 4261 Section 02
 * February 9, 2025
 */

/*
 * Write a program that lets the user enter the loan amount and loan period in number of years and displays
 * the monthly and total payments for each annual interest rate starting from 5% to 8%, with an increment of 1/8.
 * Display the output in a chart with aligned columns (boxes/table not required, just make sure each column is
 * clearly delineated and the amounts in each column line up).

Hint: remember to divide annual interest to get monthly interest rate and to convert to a decimal for the calculation.
 */

import java.util.Locale;
import java.util.Scanner;
public class CEGray_Assignment2C {

	public static void main(String[] args) {
		
		// Declare Variables
		Scanner input = new Scanner (System.in);
		double loanAmt;
		int loanPd;
		double annualIntRate;
		double monthlyIntRate;
		int numOfPayments;
		double monthlyPayment;
		double totalPayment;
		
		// Prompt user for loan amount
		System.out.print("Loan amount: ");
		loanAmt = input.nextDouble();
		
		// Prompt user for loan period
		System.out.print("Loan period (in years): ");
		loanPd = input.nextInt();
		
		// Close Scanner
		input.close();
		
		// Display header
		System.out.printf("%-15s%-20s%-20s\n", "Interest Rate", "Monthly Payment", "Total Payment");
		System.out.println("--------------------------------------------------");
		
		// Use a loop to calculate and display annual interest rate, monthly interest rate, number of payments,
		// monthly payment, and total payment (as per assignment instructions) into the chart
		for (annualIntRate = 5; annualIntRate <=8; annualIntRate += 0.125)
		{
			monthlyIntRate = annualIntRate / 1200.0;
			numOfPayments = loanPd * 12;
			monthlyPayment = (loanAmt * monthlyIntRate) / (1 - Math.pow(1 + monthlyIntRate, -numOfPayments));
			totalPayment = monthlyPayment * numOfPayments;
			
			// Format the numbers
			
			String formatIntRate;
				// Check for whole number or decimal
				if (annualIntRate % 1 == 0)
				{
					formatIntRate = String.format("%.0f%%", annualIntRate);
				}
				else
				{
					int decimalPlaces = decimalPlaces(annualIntRate);
					formatIntRate = String.format("%." + decimalPlaces + "f%%", annualIntRate);
				}
				// Apply padding for chart
				formatIntRate = String.format("%-10s", formatIntRate);
			String formatMonthlyPmt = String.format(Locale.US, "$%,-18.2f", monthlyPayment);
			String formatTotal = String.format(Locale.US, "$%,-15.2f", totalPayment);
						
			System.out.printf("%-15s %s %s \n", formatIntRate, formatMonthlyPmt, formatTotal);

		}
	}

	// Function to fine-tune decimal places for interest rate (up to 3 spaces)
	private static int decimalPlaces(double number)
	{
		String s = String.valueOf(number);
		int ind = s.indexOf('.');
		return (ind < 0) ? 0 : s.length() - ind - 1; 
	}
}
