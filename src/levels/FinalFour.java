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
 * this class will implement the LevelInformation interface, representing level 4.
 * </p>
 * this class will implement of final level information.
 * @author Shahar Razlan.
 */
public class FinalFour implements LevelInformation {
    /**
     * this method in charge of the amount of the balls in this level.
     * @return numbers of balls.
     */
    public int numberOfBalls() {
        return 3;
    }
    /**
     * this method in charge of setting each ball velocity.
     * @return  The initial velocity of each ball
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(new Velocity(-4, -4));
        v.add(new Velocity(0, -6));
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
     * this method in charge of drawing the background of this level.
     * @return a sprite with the background of the level.
     */
    public String levelName() {
        return "Final Four";
    }
    // Returns a sprite with the background of the level
    /**
     * this method in charge of drawing the background of this level.
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        Sprite t = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                Color sky = new Color(0, 128, 255);
                Color darkCloud = new Color(160, 160, 160);
                d.setColor(sky);
                d.fillRectangle(0, 0, 800, 600);
                Color grayCloud = new Color(216, 216, 216);
                Color whiteCloud = new Color(192, 192, 192);
                d.setColor(grayCloud);
                for (int i = 0; i < 10; ++i) {
                    d.drawLine(85 + (i * 8), 385, 70 + (i * 8), 600);
                    d.drawLine(615 + (i * 8), 520, 600 + (i * 8), 600);
                }
                d.setColor(grayCloud);
                d.fillCircle(95, 385, 25);
                d.fillCircle(85, 355, 20);
                d.fillCircle(625, 525, 25);
                d.fillCircle(610, 490, 20);
                d.setColor(whiteCloud);
                d.fillCircle(120, 355, 25);
                d.fillCircle(650, 495, 25);
                d.setColor(darkCloud);
                d.fillCircle(150, 370, 25);
                d.fillCircle(130, 385, 20);
                d.fillCircle(680, 520, 30);
                d.fillCircle(660, 530, 20);
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
        for (int j = 0; j < 7; ++j) { // add blocks.
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
                color = Color.green;
            }
            if (j == 4) {
                color = Color.white;
            }
            if (j == 5) {
                color = Color.pink;
            }
            if (j == 6) {
                color = Color.cyan;
            }
            for (int i = 0; i < 10; ++i) {
                b.add(new Block(new Point((730 - (i * 50)), (100 + (j * 20))), 50, 20, color));
            }
            for (int z = 0; z < 5; ++z) {
                b.add(new Block(new Point((229 - (z * 52)), (100 + (j * 20))), 52, 20, color));
            }
        }
        return b;
    }
    /**
     * this method in charge of Number of blocks that should be removed.
     * @return  Number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return 5;
    }
}
