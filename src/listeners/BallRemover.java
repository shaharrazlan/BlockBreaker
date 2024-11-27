package listeners;

import game.GameLevel;
import utilities.*;
import sprites.Ball;
import sprites.Block;


/***
 * <p>
 * a class of a ball remover.
 * </p>
 * the program will remove the ball from the game when it pass the downborder.
 * @author Shahar Razlan.
 */
public class BallRemover implements HitListener {
    private final GameLevel game;
    private final Counter remainingBalls;

    /**
     * a constructor for ball remover.
     * @param game this game.
     * @param removedBalls counter for balls that remain in the game.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * gets notify when the ball hits the down border.
     * @param beingHit down border.
     * @param hitter the removed ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        this.remainingBalls.decrease(1);
        if (this.remainingBalls.getValue() == 0) {
            beingHit.removeHitListener(this);
        }
    }
}
