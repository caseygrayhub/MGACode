/* Casey Gray
 * ITEC 4261 Section 02
 * April 20, 2025
 */

/*
 * Write a test program that creates a Triangle using the default constructor and a second Triangle from user input for all attributes,
 * then print out the area and perimeter of the triangle objects along with their toString message.
 */

 import java.util.Scanner;

 public class CEGray_Assignment6B {
    public static void main(String[] args) {

        // Create a triangle using the default constructor
        Triangle defaultTriangle = new Triangle();

        // Create a triangle using user input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter sides 1, 2, and 3 for a triangle:");
        double side1 = in.nextDouble();
        double side2 = in.nextDouble();
        double side3 = in.nextDouble();

        System.out.println("Enter a color for your triangle:");
        String color = in.next();

        System.out.println("Is your triangle filled?");
        // Initialized isFilled to false
        boolean isFilled = false;
        // Convert to lowercase for case-sensitive comparison
        String filled = in.next().toLowerCase();

        // Check if yes/no = true/false
        if (filled.equals("yes") || filled.equals("true"))
        {
            isFilled = true;
        }
        else if (filled.equals("no") || filled.equals("false"))
        {
            isFilled = false;
        }
        else
        {
            System.out.println("Invalid input. Assuming not filled.");
        }

        Triangle userTriangle = new Triangle(side1, side2, side3);
        userTriangle.setColor(color);
        userTriangle.setFilled(isFilled);

        // Print the area, perimiter, and string to the default triangle
        System.out.println("Default triangle:");
        System.out.println("Area: " + defaultTriangle.getArea());
        System.out.println("Perimeter: " + defaultTriangle.getPerimeter());
        System.out.println(defaultTriangle.toString());

        // Print the area, perimiter, and string to the user's triangle
        System.out.println("Your triangle:");
        System.out.println("Area: " + userTriangle.getArea());
        System.out.println("Perimeter: " + userTriangle.getPerimeter());
        System.out.println(userTriangle.toString());

        // Close scanner
        in.close();
    }
    
 }