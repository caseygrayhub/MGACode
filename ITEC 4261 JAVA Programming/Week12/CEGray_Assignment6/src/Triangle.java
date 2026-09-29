/* Casey Gray
 * ITEC 4261 Section 02
 * April 20, 2025
 */

 /*
 Design a class named Triangle that extends GeometricObject. The class contains:
* Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of the triangle.
* A default constructor that creates a default triangle.
* A constructor that creates a triangle with the specified side1, side2, and side3.
* The accessor methods for all three data fields.
* A method named getArea() that returns the area of this triangle.
* A method named getPerimeter() that returns the perimeter of this triangle.
* A method named toString() that returns a string description for the triangle including the fill status and color of the triangle.
* Make sure to enforce encapsulation in your class
*/

public class Triangle extends GeometricObject {
    
    // Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of the triangle.
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    // A default constructor that creates a default triangle.
    public Triangle()
    {
    }

    // A constructor that creates a triangle with specified side lengths
    public Triangle(double side1, double side2, double side3)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Get methods for the three sides
    public double getSide1()
    {
        return side1;
    }

    public double getSide2()
    {
        return side2;
    }

    public double getSide3()
    {
        return side3;
    }
    
    // A method named getArea() that returns the area of this triangle.
    public double getArea()
    {
        double x = (side1 + side2 + side3) / 2;
        return Math.sqrt(x * (x - side1) * (x - side2) * (x - side3));
    }

    // A method named getPerimeter() that returns the perimeter of this triangle.
    public double getPerimeter()
    {
        return side1 + side2 + side3;
    }

    // A method named toString() that returns a string description for the triangle including the fill status and color of the triangle.
    @Override
    public String toString()
    {
        return "Side 1 = " + side1 + 
        "\nSide 2 = " + side2 +
        "\nSide 3 = " + side3 + 
        "\n" + super.toString();
    }
}