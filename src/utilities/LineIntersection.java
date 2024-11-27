package utilities;


/***
 * <p>
 * a class that serve the line class intersection point method.
 * </p>
 * the program will get two lines, finds the intersection point, and its place on the line.
 * @author Shahar Razlan.
 */
public class LineIntersection {
    private boolean icut;
    private Line line1, line2;
    private Point cut;

    /**
     * a constructor.
     * @param line1 first line.
     * @param line2 second line.
     */
    public LineIntersection(Line line1, Line line2) {
        this.line1 = line1;
        this.line2 = line2;
    }

    /**
     * checks the position of point intersection on segment.
     * @param p1 start point of line.
     * @param p2 end point of line.
     * @param p3 point of other line.
     * @return the position of the intersection point of segment.
     */
    private boolean onSegment(Point p1, Point p2, Point p3) {

        boolean stat1 = (p2.getX() <= Math.max(p1.getX(), p3.getX()));
        boolean stat2 = p2.getX() >= Math.min(p1.getX(), p3.getX());
        boolean stat3 = p2.getY() <= Math.max(p1.getY(), p3.getY());
        boolean stat4 = p2.getY() >= Math.min(p1.getY(), p3.getY());

        if (stat1 && stat2 && stat3 && stat4) {
            return true;
        }
        return false;
    }

    /**
     * a function that checks if two segments of line is intersecting and calculate the point of intersection.
     * @param co1 orientation 1.
     * @param co2 orientation 2.
     * @param co3 orientation 3.
     * @param co4 orientation 4.
     * @return true if intersecting, null otherwise.
     */
    public boolean isIntersect(double co1, double co2, double co3, double co4) {
        Double dx1, dy1;
        Double dx2, dy2;
        Double slope1, slope2;
        Double n1, n2;
        double x1, y1;
        dx1 = line1.start().getX() - line1.end().getX();
        dy1 = line1.start().getY() - line1.end().getY();
        dx2 = line2.start().getX() - line2.end().getX();
        dy2 = line2.start().getY() - line2.end().getY();

        if (co1 != co2 && co3 != co4) {
            slope1 = dy1 / dx1;
            n1 = line1.start().getY() - (slope1 * line1.start().getX());
            slope2 = dy2 / dx2;
            n2 = line2.start().getY() - (slope2 * line2.start().getX());
            if (dx1 == 0) {
                x1 = line1.start().getX();
                y1 = n2 + (slope2 * x1);
            } else if (dx2 == 0) {
                x1 = line2.start().getX();
                y1 = n1 + (slope1 * x1);
            } else {
                x1 = (n2 - n1) / (slope1 - slope2);
                y1 = n1 + (slope1 * x1);
            }
            Point pt3 = new Point(x1, y1);
            this.cut = pt3;
            return true;
        }
        // p1, q1 and p2 are collinear and p2 lies on segment p1q1
        if (co1 == 0 && onSegment(line1.start(), line2.start(), line1.end())) {
            this.cut = line2.start();
            return true;
        }

        // p1, q1 and q2 are collinear and q2 lies on segment p1q1
        if (co2 == 0 && onSegment(line1.start(), line2.end(), line1.end())) {
            this.cut = line2.end();
            return true;
        }

        // p2, q2 and p1 are collinear and p1 lies on segment p2q2
        if (co3 == 0 && onSegment(line2.start(), line1.start(), line2.end())) {
            this.cut = line1.start();
            return true;
        }

        // p2, q2 and q1 are collinear and q1 lies on segment p2q2
        if (co4 == 0 && onSegment(line2.start(), line1.end(), line2.end())) {
            this.cut = line1.end();
            return true;
        }

        this.cut = null;
        return false; // Doesn't fall in any of the above cases
    }

    /**
     * a function that gets the intersection point.
     * @return intersection point.
     */
    public Point getIntersect() {
        return this.cut;
    }
}
