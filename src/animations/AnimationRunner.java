package animations;
import utilities.*;
import biuoop.GUI;
import biuoop.DrawSurface;
/***
 * <p>
 * a class that runs the game animation.
 * </p>
 * this class will run the game using time and draw the animation.
 * @author Shahar Razlan.
 */
public class AnimationRunner {
    private final GUI gui;
    private int framesPerSecond;
    private final biuoop.Sleeper sleeper = new biuoop.Sleeper();
    /**
     * a animation runner constructor.
     * @param gui gui.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
    }

    /**
     * this method will run the game animations objects and draw them.
     * @param animation any animation.
     */
    public void run(Animation animation) {
        framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond; // timing
        while (!animation.shouldStop()) { // shouldStop() is in charge of stopping condition.
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);  // doOneFrame(DrawSurface) is in charge of the logic.
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * gets screen height.
     * @return screen height.
     */
    public int getGuiHeight() {
        return 600;
    }
    /**
     * gets screen width.
     * @return screen width.
     */
    public int getGuiwidth() {
       return 800;
    }

}