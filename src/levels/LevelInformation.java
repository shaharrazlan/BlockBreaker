package levels;

import java.util.List;
import utilities.Velocity;
import sprites.Sprite;
import sprites.Block;

/***
 * <p>
 * this class will implement the LevelInformation interface, representing level 2.
 * </p>
 * this class will implement of wide - easy level information.
 * @author Shahar Razlan.
 */
public interface LevelInformation {
    /**
     * this method in charge of the amount of the balls in this level.
     * @return numbers of balls.
     */
    int numberOfBalls();

    /**
     * this method in charge of setting each ball velocity.
     * @return  The initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();
    /**
     * this method in charge of setting paddle speed.
     * @return paddle speed.
     */
    int paddleSpeed();
    /**
     * this method in charge of setting paddle width.
     * @return paddle width.
     */
    int paddleWidth();
    /**
     * this method in charge the level name will be displayed at the top of the screen.
     * @return level name.
     */
    String levelName();
    /**
     * this method in charge of drawing the background of this level.
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();
    /**
     * this method in charge of creating the blocks of this level.
     * @return the list of blocks.
     */
    List<Block> blocks();
    /**
     * this method in charge of Number of blocks that should be removed.
     * @return  Number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
}


