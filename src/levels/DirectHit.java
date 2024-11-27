package levels;

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import sprites.Sprite;
import sprites.Block;
import utilities.*;
/***
 * <p>
 * this class will implement the LevelInformation interface, represnting level 1.
 * </p>
 * this class will implement of direct hit level information.
 * @author Shahar Razlan.
 */
public class DirectHit implements LevelInformation {
    /**
     * this method in charge of the amount of the balls in this level.
     * @return numbers of balls.
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * this method in charge of setting each ball velocity.
     * @return  The initial velocity of each ball
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(new Velocity(0, -5));
        return v;
    }
    /**
     * this method in charge of setting paddle speed.
     * @return paddle speed.
     */
    public int paddleSpeed() {
        return 5;
    }
    /**
     * this method in charge of setting paddle width.
     * @return paddle width.
     */
    public int paddleWidth() {
        return 100;
    }
    // the level name will be displayed at the top of the screen.

    /**
     * this method in charge the level name will be displayed at the top of the screen.
     * @return level name.
     */
    public String levelName() {
        return "Direct Hit";
    }
    /**
     * this method in charge of drawing the background of this level.
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        Sprite t = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.BLACK);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.BLUE);
                d.drawCircle(400, 150, 50);
                d.drawCircle(400, 150, 80);
                d.drawCircle(400, 150, 110);
                d.drawLine(415, 150, 525, 150);
                d.drawLine(385, 150, 275, 150);
                d.drawLine(400, 165, 400, 275);
                d.drawLine(400, 135, 400, 25);
            }

            public void timePassed() {
            }
        };
        return t;
    }

    /**
     * this method in charge of creating the blocks of this level.
     * @return the list of blocks.
     */
    public List<Block> blocks() {
        List<Block> b = new ArrayList<>();
        b.add(new Block(new Point(390, 140), 20, 20, Color.RED));
        return b;
        }
    /**
     * this method in charge of Number of blocks that should be removed.
     * @return  Number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
