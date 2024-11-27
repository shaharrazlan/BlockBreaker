package sprites;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
import listeners.HitListener;
import listeners.HitNotifier;
import utilities.*;
import game.GameLevel;
/***
 * <p>
 * a class of a block.
 * </p>
 * the program will get upperleft point value, rectangle width and height, and color.
 * the class will change current velocity of collision object.
 * @author Shahar Razlan.
 */
public class Block extends Rectangle implements Collidable, Sprite, HitNotifier {
    private final List<HitListener> hitListeners = new ArrayList<>();

    /**
     * a constructor, same as the rectangle class.
     * @param location upperleft point.
     * @param width of block.
     * @param height of block.
     * @param color of block
     */
    public Block(Point location, int width, int height, java.awt.Color color) {
        super(location, width, height, color);
    }



    /**
     * a drawing function of the block, similar to rectangle drawOn func.
     * @param surface where the rectangle appear.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        super.drawOn(surface);
        for (int i = 0; i < 4; ++i) { // draw outlines in black
                super.getRectLines()[i].drawOn(surface);
            }
        }



    /**
     * Add hl as a listener to hit events.
     * @param hl listener.
     */
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl listener.
     */
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * getter.
     * @return block upcasting.
     */
    public Rectangle getCollisionRectangle() {
        return new Rectangle(super.getUpperLeft(), super.getWidth(), super.getHeight(), super.getColor());
    }

    /**
     * a function in order to notify all listeners that this block was hit.
     * @param hitter by a ball.
     */
    private void notifyHit(Ball hitter) {
        if (this.hitListeners != null) {
            // Make a copy of the hitListeners before iterating over them.
            List<HitListener> listeners = new ArrayList<>(this.hitListeners);
            // Notify all listeners about a hit event:
            for (HitListener hl : listeners) {
                hl.hitEvent(this, hitter);
            }
        }
    }

    /**
     * the function will change current velocity of collision object.
     * @param collisionPoint the point of shape collision with the ball.
     * @param currentVelocity of the ball.
     * @param hitter the ball.
     * @return new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx1 = currentVelocity.getDx(), dy1 = currentVelocity.getDy();
        Line zero = new Line(collisionPoint, collisionPoint);
        if (zero.isIntersecting(super.getRectLines()[1])) { // left block limit
             dx1 = Math.abs(currentVelocity.getDx());
        }
        if (zero.isIntersecting(super.getRectLines()[3])) { // right block limit
            dx1 = -Math.abs(currentVelocity.getDx());
        }
        if (zero.isIntersecting(super.getRectLines()[2])) { // up block limit
            dy1 = Math.abs(currentVelocity.getDy());
        }
        if (zero.isIntersecting(super.getRectLines()[0])) { // down block limit
            dy1 = -Math.abs(currentVelocity.getDy());
        }
        this.notifyHit(hitter);
         return new Velocity(dx1, dy1);
    }

    /**
     * add this to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * remove this from the game.
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.getEnvironment().removeCollidable(this);
    }

}
