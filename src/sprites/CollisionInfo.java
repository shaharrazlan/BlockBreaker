package sprites;
import utilities.*;
/***
 * <p>
 * a class for storing colliadble obj info.
 * </p>
 * storing, point of collision and the object of collision.
 * @author Shahar Razlan.
 */
public class CollisionInfo {

    private final Point collisionPoint;
    private final Collidable collisionObject;

    /**
     * a constructor.
     * @param collisionPoint point of collision between the ball and obj.
     * @param collisionObject the object the ball hit.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * getter.
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {

        return this.collisionPoint;

    }

    /**
     * getter.
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }

}
