package animations;
import utilities.*;
import biuoop.DrawSurface;
/***
 * <p>
 * an animation logic interface.
 * </p>
 this interface will represent template methods of void doOneFrame(DrawSurface d) and boolean shouldStop().
 * @author Shahar Razlan.
 */
public interface Animation {
    /**
     * the function in charge of doing one frame of animation.
     * @param d the surface of one frame of animation.
     */
    void doOneFrame(DrawSurface d);

    /**
     * stopping condition.
     * @return true in order to stop the anima, otherwise false.
     */
    boolean shouldStop();
}
