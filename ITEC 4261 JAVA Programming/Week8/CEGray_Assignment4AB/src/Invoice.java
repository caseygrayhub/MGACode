/* Casey Gray
 * ITEC 4261 Section 02
 * March 16, 2025
 */

 /*
* Create a class called Invoice that a hardware store might use to represent an invoice for an item sold at the store. An Invoice should include four data attributes:
* part number (str)
* part description (str)
* quantity sold (int)
* price per item (decimal).
* The class should have the following methods:
* Constructor for initialization.
* Getter (Accessor) for each data attribute.
* Setter (Mutator) for each data attribute - use validation to ensure quantity and price are non-negative numbers.
* A calculate_invoice method that returns the invoice amount.
* A method that displays the part description with part # in parentheses
* Make sure to enforce encapsulation on the attributes to protect them from outside access & manipulation.
  */

public class Invoice {
  
  // Declare variables
  private String partNum;
  private String partDesc;
  private int quantitySold;
  private double pricePerItem;
    
  // Create constructor fo the invoice class
  public Invoice(String partNum, String partDesc, int quantitySold, double pricePerItem)
  {
    // Declare parameters for the constructor
    this.partNum = partNum;
    this.partDesc = partDesc;

    // Use setters for validation
    setQuantitySold(quantitySold);
    setPricePerItem(pricePerItem);
  }

  // Create getters/setters for each attribute
  public String getPartNum()
  {
    return partNum;
  }

  public void setPartNum(String partNum)
  {
    this.partNum = partNum;
  }

  public String getPartDesc()
  {
    return partDesc;
  }

  public void setPartDesc(String partDesc)
  {
    this.partDesc = partDesc;
  }

  public int getQuantitySold()
  {
    return quantitySold;
  }

  public void setQuantitySold(int quantitySold)
  {
    // Check to make sure that the number is not negative
    if (quantitySold >= 0)
    {
      this.quantitySold = quantitySold;
    }

    else
    {
      this.quantitySold = 0;
      System.out.println("Quantity sold cannot be negative. Setting to 0.");
    }
  }

  public double getPricePerItem()
  {
    return pricePerItem;
  }

  public void setPricePerItem(double pricePerItem)
  {
    // Make sure the price is not negative
    if (pricePerItem >= 0.0)
    {
      this.pricePerItem = pricePerItem;
    }

    else 
    {
      this.pricePerItem = 0.0;
      System.out.println("Price cannot be negative. Setting to 0.0.");
    }
  }

  // Create method to calculate the invoice
  public double calculateInvoice()
  {
    return quantitySold * pricePerItem;
  }

  // Create a method to show item descriptions with item number
  public void displayPartInfo()
  {
    System.out.println(partDesc + " (" + partNum + ")");
  }
}
