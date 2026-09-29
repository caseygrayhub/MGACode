/* Casey Gray
 * ITEC 4261 Section 02
 * March 16, 2025
 */

 /*
* In the Main Method of a Test Program:
* Create an instance of the Invoice class with the following information:
* Part number = L93inwds5lbs
* Part description = #9 3-inch star head wood deck screw (5 lb. box)
* Quantity sold = 1000
* Price = 53.57
* Display the part number & part description using the method.
* Update the quantity to 1500
* Display the quantity
* Update the price to 62.27
* Display the price
* Calculate the invoice and display the result with a subtotal (before tax) and a total (with 8.0% sales tax) in a neatly aligned chart.
  */

public class CEGray_Assignment4B {

    public static void main(String[] args) {

        // Create an instance of the invoice class with info given in instructions
        Invoice invoice = new Invoice("L93inwds5lbs", "#9 3-inch star head wood deck screw (5 lb. box)",
        1000, 53.57);

        // Display part number and description
        invoice.displayPartInfo();

        // Update quantity and display
        invoice.setQuantitySold(1500);
        System.out.println("Quantity Sold: " + invoice.getQuantitySold());

        // Update price and display
        invoice.setPricePerItem(62.27);
        System.out.println("Price per item: " + invoice.getPricePerItem());

        // Calculate the invoice with tax as stated in instructions
        double subtotal = invoice.calculateInvoice();
        double taxRate = 0.08;
        double taxAmt = subtotal * taxRate;
        double total = subtotal + taxAmt;

        // Display invoice
        System.out.println("\nInvoice Details:");
        System.out.printf("%-15s $%10.2f\n", "Subtotal:", subtotal);
        System.out.printf("%-15s $%10.2f\n", "Tax (8.0%):", taxAmt);
        System.out.printf("%-15s $%10.2f\n", "Total:", total);
    }
}