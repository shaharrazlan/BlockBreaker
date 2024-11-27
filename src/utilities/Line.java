package utilities;

import biuoop.DrawSurface;
import java.awt.Color;
import sprites.*;


/***
 * <p>
 * a class of a line.
 * </p>
 * the program will get point of start and point of end values and can measure the length between them,
 * and if it is equal to another line, intersect with other line and is so their intersecting point.
 * @author Shahar Razlan
 */
public class Line {
    private Point pt1;
    private Point pt2;

    /**
     * exception in  a case of Uninitialized line.
     */
    public Line() {
        try {
            throw new BadInitialize("Line cant be empty... ");
        } catch (BadInitialize z) {
            System.out.println(z);
        }
    }

    /**
     * a constructor by two points.
     * @param start first point value
     * @param end   second point value
     */
    public Line(Point start, Point end) {
        this.pt1 = start;
        this.pt2 = end;
    }

    /**
     * a constructor by coordinates.
     *
     * @param x1 gets first point x coordinate
     * @param y1 gets first point y coordinate
     * @param x2 gets second point x coordinate
     * @param y2 gets second point x coordinate
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.pt1 = new Point(x1, y1);
        this.pt2 = new Point(x2, y2);

    }

    /**
     * draw the line on the given DrawSurface.
     * @param d surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawLine((int) this.pt1.getX(), (int) this.pt1.getY(), (int) this.pt2.getX(), (int) this.pt2.getY());
    }


    /**
     * calculate line length.
     * @return the length of a line.
     */
    public double length() {
        try {
            if (this.pt2 == null) {
                throw new BadInitialize("Other Line is empty... ");
            } else {
                return this.pt1.distance(this.pt2);
            }
        } catch (BadInitialize z) {
            System.out.println(z);
        }
        return -1;
    }

    /**
     * a function for calculating the middle point of a line.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        if (this.length() == 0) { // in case of point1 == point2.
            return this.pt1;
        }
        double x = (this.pt1.getX() + this.pt2.getX()) / 2;
        double y = (this.pt1.getY() + this.pt2.getY()) / 2;
        Point pt = new Point(x, y);
        return pt;
    }

    /**
     * a function for getting the start point val.
     *
     * @return first point val.
     */
    public Point start() {
        return this.pt1;
    }

    /**
     * a function for getting the end point val.
     *
     * @return second point val.
     */
    public Point end() {
        return this.pt2;
    }

    /**
     * a functioan for calculating the orientation of a segment of line in two dementional coordinates.
     *
     * @param p1 start point of a line.
     * @param p2 end point of a line.
     * @param p3 a point of other line.
     * @return the orientation of a segment.
     * 1 = clockwise,2 =  counterclockwise, 0 = colliner.
     */
    static double orientation(Point p1, Point p2, Point p3) {
        double val = (p2.getY() - p1.getY()) * (p3.getX() - p2.getX())
                - (p2.getX() - p1.getX()) * (p3.getY() - p2.getY());
        if (val > 0) {
            return 1; // clockwise.
        }
        if (val < 0) {
            return 2; // counterclockwise.
        } else {
            return 0; // colliner
        }
    }

    /**
     * a function that check if two segments of line is intersecting.
     *
     * @param other line.
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        double co1 = orientation(this.pt1, this.pt2, other.pt1);
        double co2 = orientation(this.pt1, this.pt2, other.pt2);
        double co3 = orientation(other.pt1, other.pt2, this.pt1);
        double co4 = orientation(other.pt1, other.pt2, this.pt2);

        LineIntersection n = new LineIntersection(this, other); // using lineIntersection class.
        return n.isIntersect(co1, co2, co3, co4);
    }

    /**
     * a function that calculate the intersection point between two segments of lines.
     *
     * @param other line segment.
     * @return Returns the intersection point if the lines intersect,and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double co1 = orientation(this.pt1, this.pt2, other.pt1); // checks orientation.
        double co2 = orientation(this.pt1, this.pt2, other.pt2);
        double co3 = orientation(other.pt1, other.pt2, this.pt1);
        double co4 = orientation(other.pt1, other.pt2, this.pt2);
        LineIntersection n = new LineIntersection(this, other); // using LineIntersection class.
        n.isIntersect(co1, co2, co3, co4); // checks if two segments of lin intersecting.
        return n.getIntersect();
    }

    /**
     * a function that check if two segments of lines are equal.
     *
     * @param other segment of line.
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (this.pt1.equals(other.pt1) && (this.pt2.equals(other.pt2))) {
            return true;
        }
        if (this.pt1.equals(other.pt2) && (this.pt2.equals(other.pt1))) {
            return true;
        }
        return false;
    }
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.

    /**
     * return the closest Intersection To Start Of Line.
     * @param rect specific rectangle.
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Point mypt = null;

        if (!(rect.intersectionPoints(this).isEmpty())) {
            Double flag = (rect.intersectionPoints(this).get(0)).distance(this.pt1);
            mypt = (rect.intersectionPoints(this)).get(0);
            for (int i = 1; i < rect.intersectionPoints(this).size(); i++) {
                if ((rect.intersectionPoints(this).get(i)).distance(this.pt1) < flag) {
                    flag = ((rect.intersectionPoints(this)).get(i).distance(this.pt1));
                    mypt = (rect.intersectionPoints(this)).get(i);
                }
            }
        }
        return mypt;
    }
}




