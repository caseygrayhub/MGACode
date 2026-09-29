/* Casey Gray
 * ITEC 4261 Section 02
 * April 6, 2025
 */

 /* Define a Circle2D class that contains:

* Two double data fields named x and y that specify the center of the circle with get methods.
* A data field radius with a get method.
* A default constructor that creates a default circle with (0, 0) for (x, y) and 1 for radius.
* A constructor that creates a circle with the specified x, y, and radius.
* A method getArea() that returns the area of the circle.
* A method getPerimeter() that returns the perimeter of the circle.
* A method contains(double x, double y) that returns true if the specified point (x, y) is inside this circle. See the figure below.
* A method contains(Circle2D circle) that returns true if the specified circle is inside this circle. See the figure below.
* A method overlaps(Circle2D circle) that returns true if the specified circle overlaps with this circle. See the figure below.
*/

public class Circle2D {
    
    // Initialize variables for x, y, and radius
    private double x;
    private double y;
    private double radius;

    // Default constructor that initializes circle at (0, 0) with radius 1
    Circle2D()
    {
        this(0, 0, 1);
    }

    // Constructor w/ parameters that initializes a circle with the given center and radius
    Circle2D(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Get methods for private variables x, y, and radius
    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getRadius()
    {
        return radius;
    }

    // Calculate area
    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    // Calculate perimeter
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    // Calculate the distance between the circle's center and the given point
    public boolean contains(double x, double y)
    {
        double distance = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));

        // Returns true if the specified point is inside this circle
        return distance <= radius;
    }

    // Calculate the distance between the centers of two circles
    public boolean contains(Circle2D circle)
    {
        double distance = Math.sqrt(Math.pow(this.x - circle.getX(), 2) + Math.pow(this.y - circle.getY(), 2));

        // Returns true if the specified circle is inside this circle
        return distance + circle.getRadius() <= this.radius;
    }

    // Calculate the distance between the centers of two circles
    public boolean overlaps(Circle2D circle)
    {
        double distance = Math.sqrt(Math.pow(this.x - circle.getX(), 2) + Math.pow(this.y - circle.getY(), 2));

        // Returns true if the specified circle overlaps this circle
        return distance < this.radius + circle.getRadius();
    }
}
