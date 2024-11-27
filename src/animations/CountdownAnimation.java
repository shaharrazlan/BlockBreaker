package animations;
import utilities.*;
import biuoop.DrawSurface;
import sprites.SpriteCollection;
/***
 * <p>
 * the class will display counting while initializing the game.
 * </p>
 * this class will display the counting on top of the game screen
 * @author Shahar Razlan.
 */
public class CountdownAnimation implements Animation {
    private int countFrom;
    private double numOfSeconds;
    private final SpriteCollection gameScreen;
    private boolean stop;
    private final biuoop.Sleeper sleeper = new biuoop.Sleeper();
    private boolean first;

    /**
     * the animation constructor.
     * @param numOfSeconds of the animation.
     * @param countFrom the start number of counting.
     * @param gameScreen the game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
    this.countFrom = countFrom;
    this.numOfSeconds = numOfSeconds;
    this.gameScreen = gameScreen;
    this.stop = false;
    this.first = true;
    }

    /**
     *  this method in charge of the logic for drawing one frame.
     * @param d surface.
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, "" + countFrom, 50);
        countFrom--;
        this.first = false;
    }

    /**
     * checks stopping condition.
     * @return boolean value of sttoping condition.
     */
    public boolean shouldStop() {
        if (!this.first) {
            sleeper.sleepFor(900);
            numOfSeconds--;
        }
    if (numOfSeconds == -1) {
        this.stop = true;
    }
    return this.stop;
    }
}
