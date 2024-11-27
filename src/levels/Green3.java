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
 * this class will implement the LevelInformation interface, representing level 3.
 * </p>
 * this class will implement of green three level information.
 * @author Shahar Razlan.
 */
public class Green3 implements LevelInformation  {
    /**
     * this method in charge of the amount of the balls in this level.
     * @return numbers of balls.
     */
    public int numberOfBalls() {
        return 2;
    }
    /**
     * this method in charge of setting each ball velocity.
     * @return  The initial velocity of each ball
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(new Velocity(-4, -4));
        v.add(new Velocity(4, -4));
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
    /**
     * this method in charge the level name will be displayed at the top of the screen.
     * @return level name.
     */
    public String levelName() {
        return "Green 3";
    }
    /**
     * this method in charge of drawing the background of this level.
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        Sprite t = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                Color grass = new Color(0, 153, 0);
                d.setColor(grass);
                d.fillRectangle(0, 0, 800, 600);
                Color building = new Color(32, 32, 32);
                d.setColor(building);
                d.fillRectangle(60, 460, 10, 140);
                d.fillRectangle(150, 460, 10, 140);
                d.fillRectangle(60, 460, 90, 10);
                d.setColor(Color.white);
                d.fillRectangle(70, 470, 80, 130);
                int z = 0;
                for (int i = 0; i < 4; i++) {
                    d.setColor(building);
                    d.fillRectangle(80 + z, 470, 7, 140);
                    z = z + 17;
                }
                z = 0;
                for (int i = 0; i < 5; i++) {
                    d.setColor(building);
                    d.fillRectangle(60, 490 + z, 100, 7);
                    z = z + 30;
                }
                d.setColor(Color.darkGray);
                d.fillRectangle(95, 410, 30, 50);
                d.setColor(new Color(96, 96, 96));
                d.fillRectangle(105, 200, 10, 210);
                d.setColor(Color.orange);
                d.fillCircle(110, 190, 10);
                d.setColor(new Color(255, 102, 102));
                d.fillCircle(110, 190, 7);
                d.setColor(Color.white);
                d.fillCircle(110, 190, 3);
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
        for (int j = 0; j < 5; ++j) { // add blocks.
            Color color = Color.GRAY;
            if (j == 0) {
                color = Color.GRAY;
            }
            if (j == 1) {
                 color = Color.RED;
            }
            if (j == 2) {
                 color = Color.yellow;
            }
            if (j == 3) {
                 color = Color.blue;
            }
            if (j == 4) {
                color = new Color(224, 224, 244);
            }
            for (int i = 0; i < 10 - j; ++i) {
                b.add(new Block(new Point((730 - (i * 50)), (150 + (j * 20))), 50, 20, color));
            }
        }
        return b;
    }
    /**
     * this method in charge of Number of blocks that should be removed.
     * @return  Number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return 4;
    }
}
