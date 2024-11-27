package game;

import java.util.ArrayList;
import sprites.Collidable;
import sprites.CollisionInfo;
import utilities.*;


/***
 * <p>
 * The GameEnvironment class will be a collection of many objects a Ball can collide with.
 * </p>
 * The ball will know the game environment, and will use it to check for collisions and direct its movement.
 * @author Shahar Razlan.
 */
public class GameEnvironment {
    private final ArrayList<Collidable> a = new ArrayList<>();
    private final int width;
    private final int height;

    /**
     * a counstructor that build the game settings, width,height and holds an array of
     many objects a Ball can collide with.
     * @param width of the game.
     * @param height of the game.
     */
    public GameEnvironment(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * add the given collidable to the environment.
     * @param c the given collidable.
     */
   public void addCollidable(Collidable c) {
        a.add(c);
    }

    /**
     * remove the given collidable from the environment.
     * @param c the given collidable.
     */
    public void removeCollidable(Collidable c) {
        a.remove(c);
    }
    /**
     * a function that calculationg the closest cilliadble object in the ball trajectory.
     * @param trajectory an object moving from line.start() to line.end().
     * @return If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        Collidable cd;
        CollisionInfo info;
        Point pt;

        if (!(a.isEmpty())) {
            for (int i = 0; i < a.size(); ++i) { // gets the intescting point between trajectory
                // to the closest colliadble obj.
                if (trajectory.closestIntersectionToStartOfLine(a.get(i).getCollisionRectangle()) != null) {
                    pt = trajectory.closestIntersectionToStartOfLine(a.get(i).getCollisionRectangle());
                    cd = a.get(i);
                    info = new CollisionInfo(pt, cd);
                    return info;
                }
            }
        }
        info = null;
        return info;
    }

    /**
     * getter.
     * @return height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * getter.
     * @return width.
     */
    public int getWidth() {
        return width;
    }
}
