package sprites;
import utilities.*;
import biuoop.DrawSurface;
/***
 * <p>
 * a class of borders.
 * </p>
 * the program will initialize borders and draw it.
 * @author Shahar Razlan.
 */

public class Borders extends Block {

    /**
     * a constructor for creating border.
     * @param location upperleft point of the border.
     * @param width of the border.
     * @param height of the border.
     * @param color of the border.
     */
    public Borders(Point location, int width, int height, java.awt.Color color) {
        super(location, width, height, color);
    }



    /**
     * a drawing function of the block, similar to rectangle drawOn func.
     * @param surface where the rectangle appear.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(super.getColor());
        surface.drawRectangle((int) super.getCenter().getX(),
                (int) super.getCenter().getY(), this.getWidth(), this.getHeight());
        surface.fillRectangle((int) super.getCenter().getX(),
                (int) super.getCenter().getY(), this.getWidth(), this.getHeight());
    }

}
