package utilities;



/**
 * the class will handle bad initializions of objects and exception.
 */
public class BadInitialize extends Exception {
    private String s;


    BadInitialize(String s) {
        this.s = s;
    }
    /**
     * send error message.
     * @return string output
     */
    public String toString() {
        return s;
    }
}
