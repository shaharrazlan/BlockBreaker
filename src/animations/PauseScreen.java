package animations;
import utilities.*;
import biuoop.DrawSurface;

/***
 * <p>
 * a class for pausing game animation.
 * </p>
 this class will pause the game, draw the animation and run it.
 * @author Shahar Razlan.
 */
public class PauseScreen implements Animation {
    private final boolean stop;
    /**
     * the class constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }
    /**
     * the function in charge of doing one frame of animation.
     * @param d the surface of one frame of animation.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    /**
     * stopping condition.
     * @return true in order to stop the anima, otherwise false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}

