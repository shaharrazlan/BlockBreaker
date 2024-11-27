package sprites;
import utilities.*;
/***
 * <p>
 * an interface will be used by things that can be collided with.
 * </p>
 * Notify the object that we collided with it at collisionPoint with a given velocity.
 * interface will the location and size will be specified using a Rectangle.
 * @author Shahar Razlan.
 */
public interface Collidable {

    /**
     * "collision shape" of the object.
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     *  Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint the point of shape collision with the ball.
     * @param currentVelocity of the ball.
     * @param hitter the ball.
     * @return The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
