package levels;

import biuoop.DrawSurface;
import java.awt.Color;
import sprites.Sprite;
import sprites.Block;
import game.GameLevel;
import utilities.*;
/***
 * <p>
 * this class in charge of drawing the game level name.
 * </p>
 this class will draw the level name.
 * @author Shahar Razlan.
 */
public class LevelName implements Sprite {
    private final String s;

    /**
     * level name constructor.
     * @param s level name.
     */
    public LevelName(String s) {
        this.s = s;
    }
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawText(500, 15, "Level Name: " + this.s, 15);
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
