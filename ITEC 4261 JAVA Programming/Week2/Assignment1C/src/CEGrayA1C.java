import java.util.Scanner;
/** Casey Gray
 	Assignment 1 Part C
	January 26, 2025
/*



/**
 The United States federal personal income tax is calculated based on filing status and taxable income.
 There are four filing statuses: single filers, married filing jointly, married filing separately,
 and head of household. The tax rates vary every year. If you are, say, single with a taxable income of
 $10,000, the first $8,350 is taxed at 10% and the other $1,650 is taxed at 15%. So, your tax is $1,082.50.
 
 *Note: Tax bracket table given in assignment
 
 You are to write a program to compute personal income tax. Your program should prompt the user to enter
 the filing status and taxable income and compute the tax. Enter 0 for single filers,
 1 for married filing jointly, 2 for married filing separately, and 3 for head of household.
 */
public class CEGrayA1C {

	public static void main(String[] args) {
		// Declare variables
		Scanner input = new Scanner(System.in);
		int filingStatus;
		double taxableIncome;
		double tax = 0.0;
		
		// Prompt user for their filing status
		System.out.print("Enter filing status (0: Single, 1: Married Filing Jointly, 2: Married Filing Separately"
				+ ", or 3: Head of Household: ");
		filingStatus = input.nextInt();
		
		// Prompt user for their taxable income
		System.out.print("Enter taxable income: ");
		taxableIncome = input.nextDouble();
		
		// Close scanner
		input.close();
		
		// Calculate tax based on filing status and taxable income
		switch (filingStatus) {
		
			// Single
			case 0:
				tax = calculateTax(taxableIncome,
						new double[] { 8350, 33950, 82250, 171550, 372951 },
						new double[] { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 });
				break;
				
			// Married filing jointly
			case 1:
				tax = calculateTax(taxableIncome, 
	                    new double[] { 16700, 67900, 137050, 208850, 372951 }, 
	                    new double[] { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 });
	                break;
	                
	        // Married filing separately
			case 2:
				tax = calculateTax(taxableIncome, 
	                    new double[] { 8350, 33950, 68525, 104425, 186476 }, 
	                    new double[] { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 });
	                break;
	                
            // Head of Household
			case 3:
				tax = calculateTax(taxableIncome, 
	                    new double[] { 11950, 45500, 117450, 190200, 372951 }, 
	                    new double[] { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 });
	                break;
            
            // Display error if incorrect number is entered.
            default:
            	System.out.println("Invalid filing status.");
            	return;
		}
		
		// Display the calculated tax
		System.out.printf("Your tax is: $%.2f\n", tax);

	}
	
	// Function to calculate tax for the given income and tax brackets
	private static double calculateTax(double income, double[] brackets, double[] rates) {
		// Declare variables
		double tax = 0.0;
		
		// Create loop to iterate through the tax brackets
		for (int i = 0; i < brackets.length; i++) {
			// If income is less than or equal to  the current bracket, the tax is calculated for that income
			if (income <= brackets[i]) {
				tax += (income - (i == 0 ? 0 : brackets[i-1])) * rates[i];
				break;
			}
			// If income is greater than the current bracket, the tax is calculated and it continues
			// to the next bracket
			else {
				tax+= (brackets[i] - (i == 0 ? 0 : brackets[i - 1])) * rates[i];
			}
		}
		return tax;
	}

}
