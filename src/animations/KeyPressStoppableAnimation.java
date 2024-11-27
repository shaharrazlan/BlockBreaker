package animations;
import utilities.*;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/***
 * <p>
 * an animation class in charge for wrapping other animations, for the stopping key press of the animations.
 * </p>
 this animation will stop animation if stopping key is pressed.
 * @author Shahar Razlan.
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor sensor;
    private final String key;
    private final Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * key press constructor.
     * @param sensor game keyboard.
     * @param key stop key of animation.
     * @param animation animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }
    /**
     * this function in charge of wrapping anima doOneFrame function, fixing bug.
     * @param d the surface of one frame of animation.
     */
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        // for stop this specific anima once.
        if (this.sensor.isPressed(this.key) && !this.isAlreadyPressed) {
            this.stop = true;
        }
        if (!this.sensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }

    }

    /**
     * the function in charge of stopping condition of the anima.
     * @return true for stop' false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}

