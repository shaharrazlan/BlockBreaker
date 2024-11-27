package sprites;

import biuoop.DrawSurface;
import java.awt.Color;
import game.GameLevel;
import utilities.*;
/***
 * <p>
 * a class of a ball.
 * </p>
 * the program will get center of ball point value, ball radius and ball color for creating two dementional ball.
 * the program will create ball,draw it,
 * set its velocity and his movment.
 * @author Shahar Razlan.
 */

public class Ball extends Shape implements Sprite {
    private java.awt.Color color;
    private int r;
    private Point center;
    private Velocity v = new Velocity(0, 0);
    private GameLevel game;

    /**
     * a ball constructor.
     *
     * @param center point of center of the ball.
     * @param r      radius of the ball.
     * @param color  of the ball.
     */

    public Ball(Point center, int r, java.awt.Color color) {
        super(color, center);
        this.r = Math.abs(r);
        this.center = center;
        this.color = color;
    }
    /**
     * a ball constructor.
     *
     * @param x     coord of center ball.
     * @param y     coord of center ball.
     * @param r     radius of the ball.
     * @param color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        super(color,  new Point(x, y));
        this.r = r;
        this.center = new Point(x, y);
        this.color = color;
    }

    /**
     * make the ball move one step.
     */
    public void timePassed() {
           moveOneStep(this.game);
        }


    /**
     * gets radius size of the ball.
     * @return radius.
     */
    public int getSize() {
        return this.r;
    }


    /**
     * draw the ball on the given DrawSurface.
     * @param surface of the ball.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * setting ball speed.
     * @param v for ball velocity.
     */
    public void setVelocity(Velocity v) {
        this.v = new Velocity(v.getDx(), v.getDy());
    }

    /**
     * setting ball velocity.
     * @param dx The difference in absolute value between two x coordinate.
     * @param dy The difference in absolute value between two y coordinate.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * a function for 0 movement.
     * @return velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * a function that move the ball from point in interface to another.
     * @param game this game.
     */
    public void moveOneStep(GameLevel game) {
        this.center = this.getVelocity().applyToPoint(this, this.center, this.r, this.game);
    }

    /**
     * add this to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        this.game = g;
    }
    /**
     * remove this from the game.
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        this.game = g;
    }
}











