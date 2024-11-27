/// 316357466 Shahar Razlan
package indicators;

import biuoop.DrawSurface;
import java.awt.Color;
import utilities.Rectangle;
import sprites.Sprite;
import utilities.Counter;
import utilities.Point;
import game.GameLevel;

/***
 * <p>
 * a sprite for displaying game score.
 * </p>
 * the class will draw the score and add it to the game.
 * @author Shahar Razlan.
 */
public class ScoreIndicator extends Rectangle implements Sprite {
    private final Counter score;


    /**
     * a constructor for game score imaging.
     * @param upperLeft the top left of the image.
     * @param width of the image.
     * @param height of the image.
     * @param color of the background.
     * @param score the game score.
     */
    public ScoreIndicator(Point upperLeft, int width, int height, java.awt.Color color, Counter score) {
        super(upperLeft, width, height, color);
        this.score = score;
    }
    /**
     * a drawing function of the block, similar to rectangle drawOn func.
     * @param surface where the rectangle appear.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        super.drawOn(surface);
        surface.setColor(Color.BLACK);
        surface.drawText(300, 15, "Score: " + this.score.getValue(), 15);
    }

    /**
     * add this to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

}
