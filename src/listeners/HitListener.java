package listeners;

import sprites.Ball;
import sprites.Block;
/***
 * <p>
 * a interface for Objects that want to be notified of hit events.
 * </p>
 * register objects for hit event.
 * @author Shahar Razlan.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit collidable.
     * @param hitter is the Ball that's doing the hitting.
     */
  void hitEvent(Block beingHit, Ball hitter);
}
