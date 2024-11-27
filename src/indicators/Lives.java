package indicators;

import biuoop.DrawSurface;
import java.awt.Color;
import sprites.Sprite;
import utilities.Counter;
import game.GameLevel;
/***
 * <p>
 * this class will draw the lives that left in the game.
 * </p>
 * @author Shahar Razlan.
 */
public class Lives implements Sprite {
    private final int lives;
    private Counter ballCounter;

    /**
     * lives constructor.
     * @param lives num of lives.
     */
    public Lives(int lives, Counter ballCounter) {
        this.lives = lives;
        this.ballCounter = ballCounter;
    }

    /**
     * the function in charge of doing one frame of animation.
     * @param surface the surface of one frame of animation.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawText(100, 15, "Lives: " + this.ballCounter.getValue(), 15);
    }

    /**
     * null function.
     */
    public void timePassed() {
    }
    /**
     * add this to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
