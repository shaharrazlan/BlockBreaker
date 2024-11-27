package utilities;
import biuoop.DrawSurface;
import java.util.ArrayList;




/***
 * <p>
 * a class for creating rectangle.
 * </p>
 * the program will get start point ,height, width of wanted rectangle and create it, can draw it too.
 * @author Shahar Razlan.
 */
public class Rectangle extends Shape {
    private int width, height;

    /**
     * constructor of rectangle.
     * @param upperLeft point of rec.
     * @param width     of wanted rec.
     * @param height    of wanted rec.
     * @param color of wanted rec.
     */
    public Rectangle(Point upperLeft, int width, int height, java.awt.Color color) {
        super(color, upperLeft);
        try {
            if (width <= 0 || height <= 0) {
                throw new BadInitialize("width or height cant have non positive values... ");
            }
            this.width = width;
            this.height = height;
        } catch (BadInitialize z) {
            System.out.println(z);
        }
    }

    /**
     * this function doing nothing for now.
     */
    public void timePassed() {

    }

    /**
     * a function for drawing the rectangle.
     * @param surface where the rectangle appear.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(super.getColor());
        surface.drawRectangle((int) super.getCenter().getX(), (int) super.getCenter().getY(), this.width, this.height);
        surface.fillRectangle((int) super.getCenter().getX(), (int) super.getCenter().getY(), this.width, this.height);
    }

    /**
     * a function that gives the upperleft point of rectangle.
     * @return start point of rectangle.
     */
    public Point getUpperLeft() {
        return super.getCenter();
    }

    /**
     * a function that gives the width of rectangle.
     * @return width of rectangle.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * a function that gives the Height of rectangle.
     * @return Height of rectangle.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * a function for creating the outlines of the rectangle.
     * @return all 4 rectangle outlines.
     */
    public Line[] getRectLines() {
        Line[] list = new Line[4];
        Point downleft = new Point(super.getX(), super.getY() + this.height);
        Point topright = new Point(super.getX() + this.getWidth(), super.getY());
        Point downright = new Point(super.getX() + this.getWidth(),
                super.getY() + this.height);

        Line ab = new Line(super.getCenter(), topright);
        list[0] = ab;
        Line bc = new Line(topright, downright);
        list[1] = bc;
        Line cd = new Line(downright, downleft);
        list[2] = cd;
        Line da = new Line(downleft, super.getCenter());
        list[3] = da;
        return list;
    }


    /**
     *
     * @param line the speed trajectory of velocity.
     * @return  a (possibly empty) List of intersection points
     *  with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> mylist = new ArrayList<Point>();
        for (int i = 0; i < 4; ++i) {
            boolean bool = this.getRectLines()[i].isIntersecting(line);
            if (bool) {
                mylist.add(this.getRectLines()[i].intersectionWith(line));
            }
        }
        return mylist;
    }
}
