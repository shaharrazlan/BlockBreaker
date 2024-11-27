/// 316357466 Shahar Razlan
package animations;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/***
 * <p>
 * a class for helping bouncing balls animation.
 * </p>
 * the program will cast a string array to int abs values for ball radius and gives random color by request.
 * @author Shahar Razlan.
 */

public class DrawAnimationHelp {
    private ArrayList<Integer> mylist = new ArrayList<>();
    /**
     * a function for casting string args of ball radius to abs int.
     * @param numbers1 ball radius string.
     * @return an array of ball radius abs int.
     */
    public ArrayList<Integer> stringToInt(String[] numbers1) {
        int i = 0; // Using temp array in order to contain the numbers after casting.
        while (i < numbers1.length) { //
            try {
                int number = Integer.parseInt(numbers1[i]);
                if (number > 0 && number < 5) {
                    mylist.add(number);
                    i++;
                } else {
                    i++;
                }
            } catch (Exception e) {
                i++;
                continue;
            }
        }
        return mylist;
    }

    /**
     * a function that gives random color.
     * @return random color.
     */
    public Color randomColor() {
        Random random = new Random();
        final float hue = random.nextFloat();
        final float saturation = 0.9f; //1.0 for brilliant, 0.0 for dull
        final float luminance = 1.0f; //1.0 for brighter, 0.0 for black
        Color color = Color.getHSBColor(hue, saturation, luminance);
        return color;
    }

}





