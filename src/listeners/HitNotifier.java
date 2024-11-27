package listeners;

/***
 * <p>
 * an interface indicate that objects that implement it send notifications when they are being hit
 * </p>
 * allow to other object to register for hit events.
 * @author Shahar Razlan.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl any obj.
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl any obj.
     */
    void removeHitListener(HitListener hl);
}
