package animations;
import utilities.*;
import biuoop.DrawSurface;

/***
 * <p>
 * a class for end winnig path animation.
 * </p>
 this class will draw the animation and run it.
 * @author Shahar Razlan.
 */
public class EndGameWin implements Animation {
    private final int score;
    private final boolean stop;
    /**
     * a constructor, gets score.
     * @param score of the game.
     */
    public EndGameWin(int score) {
        this.stop = false;
        this.score = score;
    }
    /**
     * the function in charge of doing one frame of animation.
     * @param d the surface of one frame of animation.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score, 32);
    }
    /**
     * stopping condition.
     * @return true in order to stop the anima, otherwise false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
