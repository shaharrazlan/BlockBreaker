package utilities;


/***
 * <p>
 * a simple class that is used for counting things
 * </p>
 * the program will get center of ball point value, ball radius and ball color for creating two dementional ball.
 * the program will create ball,draw it,
 * set its velocity and his movment.
 * @author Shahar Razlan.
 */
public class Counter {
    private int num;

    /**
     * a constructor for counter.
     * @param num start number of counting.
     */
    public Counter(int num) {
        this.num = num;
    }

    /**
     * add number to current count.
     * @param number number.
     */
       public void increase(int number) {
            this.num = num + number;
        }
    /**
     * subtract number from current count.
     * @param number number.
     */
       public void decrease(int number) {
            this.num = num - number;
        }

    /**
     * get current count.
     * @return counter value.
     */
       public int getValue() {
            return this.num;
    }

}
