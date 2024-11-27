package sprites;
import biuoop.DrawSurface;
import java.util.ArrayList;
import utilities.*;

/***
 * <p>
 * the class will hold a collection of sprites.
 * the class allow to add sprite and call timePassed() on all sprites.
 * </p>
 * @author Shahar Razlan.
 */
public class SpriteCollection {
    private final ArrayList<Sprite> mylist = new ArrayList<>();

    /**
     * a function in order to add sprite to the sprites arraylist.
     * @param s a sprite.
     */
    public void addSprite(Sprite s) {
       mylist.add(s);
    }
    /**
     * a function in order to remove sprite from the sprites arraylist.
     * @param s a sprite.
     */
    public void removeSprite(Sprite s) {
        mylist.remove(s);
    }

    /**
     *  call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < mylist.size(); ++i) {
            mylist.get(i).timePassed();
        }

    }


    /**
     * call drawOn(d) on all sprites.
     * @param d surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < mylist.size(); ++i) {
            mylist.get(i).drawOn(d);
        }
    }


}
