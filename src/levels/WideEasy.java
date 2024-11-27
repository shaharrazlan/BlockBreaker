package levels;

import biuoop.DrawSurface;
import utilities.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import sprites.Sprite;
import sprites.Block;

/***
 * <p>
 * this class will implement the LevelInformation interface, representing level 2.
 * </p>
 * this class will implement of wide - easy level information.
 * @author Shahar Razlan.
 */
public class WideEasy implements LevelInformation {
    /**
     * this method in charge of the amount of the balls in this level.
     * @return numbers of balls.
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * this method in charge of setting each ball velocity.
     * @return  The initial velocity of each ball
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        double x = 3;
        double y = 3;
        for (double i = 0; i < 5; i++) {
            v.add(new Velocity(-x, -y));
            v.add(new Velocity(x, -y));
            x = x - 0.5;
            y = y + 0.2;

        }
        return v;
    }

    /**
     * this method in charge of setting paddle speed.
     * @return paddle speed.
     */
    public int paddleSpeed() {
        return 1;
    }
    /**
     * this method in charge of setting paddle width.
     * @return paddle width.
     */
    public int paddleWidth() {
        return 600;
    }
    /**
     * this method in charge the level name will be displayed at the top of the screen.
     * @return level name.
     */
    public String levelName() {
        return "Wide Easy";
    }
    /**
     * this method in charge of drawing the background of this level.
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        Sprite t = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.WHITE);
                d.fillRectangle(0, 0, 800, 600);
                Color darkYellow = new Color(255, 204, 0);
                Color mid = new Color(226, 215, 58);
                Color lightYellow = new Color(232, 226, 151);
                for (int i = 0; i < 600; i++) {
                    i = i + 4;
                    d.setColor(lightYellow);
                    d.drawLine(150, 150, i, 250);
                }
                d.setColor(lightYellow);
                d.fillCircle(150, 150, 60);
                d.setColor(mid);
                d.fillCircle(150, 150, 50);
                d.setColor(darkYellow);
                d.fillCircle(150, 150, 40);
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
        b.add(new Block(new Point(20, 250), 51, 20, Color.RED));
        b.add(new Block(new Point(71, 250), 51, 20, Color.RED));
        b.add(new Block(new Point(122, 250), 51, 20, Color.ORANGE));
        b.add(new Block(new Point(173, 250), 51, 20, Color.ORANGE));
        b.add(new Block(new Point(224, 250), 51, 20, Color.YELLOW));
        b.add(new Block(new Point(275, 250), 50, 20, Color.YELLOW));
        b.add(new Block(new Point(325, 250), 50, 20, Color.green));
        b.add(new Block(new Point(375, 250), 50, 20, Color.green));
        b.add(new Block(new Point(425, 250), 50, 20, Color.green));
        b.add(new Block(new Point(475, 250), 50, 20, Color.BLUE));
        b.add(new Block(new Point(526, 250), 51, 20, Color.BLUE));
        b.add(new Block(new Point(577, 250), 51, 20, Color.pink));
        b.add(new Block(new Point(628, 250), 51, 20, Color.pink));
        b.add(new Block(new Point(679, 250), 51, 20, Color.cyan));
        b.add(new Block(new Point(730, 250), 51, 20, Color.cyan));
        return b;
    }
    /**
     * this method in charge of Number of blocks that should be removed.
     * @return  Number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return 13;
    }
}


