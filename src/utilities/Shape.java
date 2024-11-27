package utilities;
import biuoop.DrawSurface;
import java.awt.Color;
import sprites.Sprite;

import utilities.*;


/***

/***
 * <p>
 * an abstract class of a shape.
 * </p>
 * the program will get color and center point of object, and draw it.
 * @author Shahar Razlan.
 */
public abstract class Shape implements Sprite {
    private Color color;
    private Point pt;

    /**
     * shape constructor.
     * @param color of obj.
     * @param pt center point of obj.
     */
    public Shape(Color color, Point pt) {
        try {
            if (pt == null) {
                throw new BadInitialize("Point of shape need to be initialiize...");
            }
            if (color == null) {
                throw new BadInitialize("color of shape need to be initialiize...");
            }
            this.color = color;
            this.pt = pt;
        } catch (BadInitialize z) {
            System.out.println(z);
        }
    }

    /**
     * getter.
     * @return color
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * getter.
     * @return center point
     */
    public Point getCenter() {
        return this.pt;
    }
    /**
     * getter.
     * @return x value of center point.
     */
    public int getX() {
        return (int) this.pt.getX();
    }
    /**
     * getter.
     * @return y value of center point.
     */
    public int getY() {
        return (int) this.pt.getY();
    }

    /**
     * setter.
     * @param color of shpae.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * draw function for shape.
     * @param surface where the drawing appear.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
    }
}