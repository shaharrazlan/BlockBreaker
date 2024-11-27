package listeners;

import utilities.*;
import sprites.Ball;
import sprites.Block;

/***
 * <p>
 * a class for updating this counter when blocks are being hit and removed.
 * </p>
 * the class will update the score counter on hit events.
 * @author Shahar Razlan.
 */
public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;

    /**
     * a constructor for tracking the score by score counter.
     * @param scoreCounter the counter of the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * a function that add 5 points to the score in every hit event.
     * @param beingHit collidable.
     * @param hitter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
