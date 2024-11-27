package sprites;
import biuoop.DrawSurface;
import utilities.*;

/***
 * <p>
 * an interface Sprites that is a game object that can be drawn to the screen.
 * </p>
 * the sprite can be drawn on the screen, and can be notified that time has passed
 * @author Shahar Razlan.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d where the drawing appear.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
