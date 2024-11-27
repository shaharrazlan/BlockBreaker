package utilities;
import sprites.*;


/***
 * <p>
 * a class of a point.
 * </p>
 * the program will get x and y values and can measure the distance to other points,
 * and if it is equal to another point.
 * @author Shahar Razlan
 */
public class Point {

    private double x, y;
    /**
     * a constructor.
     * @param x  x coordinate.
     * @param y y coordinate.
     */
    public Point(double x, double y) {
        try {
            if (x < 0 || y < 0) {
                throw new BadInitialize("Point values must be Positive... ");
            }
            this.x = x;
            this.y = y;
        } catch (BadInitialize z) {
            System.out.println(z);
        }
    }

    /**
     * in case of empty point.
     */
    public Point() {
        try {
            throw new BadInitialize("Point cant be empty... ");
        } catch (BadInitialize z) {
            System.out.println(z);
        }
    }


    /**
     * a function for calculating the distance between two points.
     * @param other point
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        if (other == null) { // in case of null point.
            return -1;
        }
        double sqx = (this.x - other.getX()) * (this.x - other.getX());
        double sqy = (this.y - other.getY()) * (this.y - other.getY());
        double root = Math.sqrt((sqx) + (sqy)); // square root calculating.
        return root;
    }

    /**
     * a function that check if two points are equal.
     * @param other point.
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (other == null) {  // // in case of Uninitialized other point.
            return false;
        }
        boolean equal = ((this.x == other.getX()) && (this.y == other.getY()));
        return (equal) ? true : false;
    }

    /**
     * a function for getting x coordinate of a point.
     * @return x coordinate.
     */
    public double getX() {
        return this.x;
    }

    /**
     * a function for getting y coordinate of a point.
     * @return y coordinate.
     */
    public double getY() {
        return this.y;
    }
}
