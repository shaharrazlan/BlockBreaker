package listeners;

import game.GameLevel;
import utilities.*;
import sprites.Ball;
import sprites.Block;
/***
 * <p>
 * a class of a block remover.
 * </p>
 * the program will remove the block from the game when it was hit by a ball.
 * @author Shahar Razlan.
 */
public class BlockRemover implements HitListener {
        private final GameLevel game;
        private final Counter remainingBlocks;

    /**
     * a constructor for block remover.
     * @param game this game.
     * @param removedBlocks the remaining block in the game.
     */
   public BlockRemover(GameLevel game, Counter removedBlocks) {
       this.game = game;
       this.remainingBlocks = removedBlocks;
        }

        // Blocks that are hit should be removed
        // from the game. Remember to remove this listener from the block
        // that is being removed from the game.

    /**
     * gets notify when the ball hits a block.
     * @param beingHit block.
     * @param hitter a ball.
     */
        public void hitEvent(Block beingHit, Ball hitter) {
       beingHit.removeFromGame(game);
       this.remainingBlocks.decrease(1);
       beingHit.removeHitListener(this);
       }

    }

