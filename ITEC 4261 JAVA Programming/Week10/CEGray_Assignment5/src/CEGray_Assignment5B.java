/* Casey Gray
 * ITEC 4261 Section 02
 * April 6, 2025
 */

 /* Write a test program that creates a Circle2D Object using input from the user for the center point and the radius along
 * with a Circle2D Object using the default constructor. Display the area and perimeters of each circle then ask the user
 * for a point (x & y coordinates).   Check to see if the point is contained in either circle object, then test if either
 * circle contains or overlaps with the other circle. 

 * Make sure to enforce encapsulation in your Circle2D class and to print out all results with descriptions.
 */

 import java.util.Scanner;

 public class CEGray_Assignment5B {
     public static void main(String[] args) {
         // Initialize scanner
         Scanner in = new Scanner(System.in);
 
         // Get user input for Circle2D object
         System.out.print("Enter x coordinate of the center: ");
         double x = in.nextDouble();
 
         System.out.print("Enter y coordinate of the center: ");
         double y = in.nextDouble();
 
         System.out.print("Enter the radius: ");
         double radius = in.nextDouble();
 
         // Construct user circle and default circle
         Circle2D userCircle = new Circle2D(x, y, radius);
         Circle2D defaultCircle = new Circle2D();

         // Display the area and perimeter of each circle
         System.out.println("User defined circle:");
         System.out.println("Area: " + userCircle.getArea());
         System.out.println("Perimeter: " + userCircle.getPerimeter());

         System.out.println("Default circle:");
         System.out.println("Area: " + defaultCircle.getArea());
         System.out.println("Perimeter: " + defaultCircle.getPerimeter());

         // Get user input for point coordinates
         System.out.print("Enter x coordinate of a point: ");
         double pointX = in.nextDouble();

         System.out.print("Enter y coordinate of a point: ");
         double pointY = in.nextDouble();

         // Check if the point is contained within either circle
         System.out.println("Point (" + pointX + ", " + pointY + ") is contained in:");

         if (userCircle.contains(pointX, pointY))
         {
            System.out.println("The user defined circle.");
         }

         if (defaultCircle.contains(pointX, pointY))
         {
            System.out.println("The default circle.");
         }

         if (!userCircle.contains(pointX, pointY) && !defaultCircle.contains(pointX, pointY))
         {
            System.out.println("Neither circle.");
         }

         // Check if the circles contain or overlap each other
         System.out.println("The user defined circle contains the default circle: " + userCircle.contains(defaultCircle));
         System.out.println("The default circle contains user defined circle: " + defaultCircle.contains(userCircle));
         System.out.println("The user defined circle overlaps the default circle: " + userCircle.overlaps(defaultCircle));
         System.out.println("The default circle overlaps the user defined circle: " + defaultCircle.overlaps(userCircle));

         // Close scanner
         in.close();
     }
 }
 