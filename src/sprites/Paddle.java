package sprites;
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
import java.awt.Color;

import utilities.*;
import game.GameLevel;
/***

/***
 * <p>
 * the class is the player in the game
 * </p>
 * It is a rectangle that is controlled by the arrow keys, and moves according to the player key presses.
 * the program will implement the Sprite and the Collidable interfaces.
 * It know how to move to the left and to the right set its velocity and his movment.
 * @author Shahar Razlan.
 */
public class Paddle extends Rectangle implements Sprite, Collidable {
    private GameLevel game;
    private Rectangle paddle;
    private Point upperLeft;
    private biuoop.KeyboardSensor keyboard;
    private final int speed;
    private final Color color;

    /**
     * a paddle constructor, similar as rectangle.
     * @param upperLeft of the rectangle.
     * @param width of the rectangle.
     * @param height of the rectangle.
     * @param color of the rectangle.
     * @param speed of the rectangle.
     */
    public Paddle(Point upperLeft, int width, int height, java.awt.Color color, int speed) {
        super(upperLeft, width, height, Color.blue);
        this.upperLeft = upperLeft;
        this.speed = speed;
        this.color = color;
        paddle =  new Rectangle(upperLeft, width, height, color);
    }

    /**
     * a drawing function for Paddle.
     * @param d where the drawing appear
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), super.getWidth(), super.getHeight());
        d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),  super.getWidth(), super.getHeight());
        for (int i = 0; i < 4; ++i) { // draw outlines in black
            paddle.getRectLines()[i].drawOn(d);
        }
    }

    /**
     * the function allow the player to move the paddle to the left.
     */
    public void moveLeft() {
        if (this.upperLeft.getX() - game.getBorderSize() > 0) {
            this.upperLeft = new Point(this.upperLeft.getX() - this.speed, this.upperLeft.getY());
            paddle = new Rectangle(this.upperLeft, super.getWidth(), super.getHeight(), super.getColor());
        }
    }

    /**
     * the function allow the player to move the paddle to the Right.
     */
    public void moveRight() {
        if ((this.upperLeft.getX() + this.getWidth() + game.getBorderSize()) < game.getEnvironment().getWidth()) {
            this.upperLeft = new Point(this.upperLeft.getX() + this.speed, this.upperLeft.getY());
            paddle = new Rectangle(this.upperLeft, super.getWidth(), super.getHeight(), super.getColor());
        }
    }

    // Sprite

    /**
     * while the game call all sprites timePassed its allow to the player to move the paddle with keyboard.
     */
    public void timePassed() {
        if (this.keyboard.isPressed("a")) {
            moveLeft();
        } else if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed("d")) {
            moveRight();
        } else if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }

    }


    /**
     * gettin.
     * @return upcasting of Paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * the function will change current velocity of collision object.
     * @param collisionPoint the point of shape collision with the ball.
     * @param currentVelocity of the ball.
     * @param hitter the ball.
     * @return new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
            double dx1 = currentVelocity.getDx(), dy1 = currentVelocity.getDy();
            Line zero = new Line(collisionPoint, collisionPoint);
            double section = (this.getWidth()) / 5;
            double start = paddle.getRectLines()[0].start().getX();
            double speed = Math.sqrt((dx1 * dx1) + (dy1 * dy1));
        if (zero.isIntersecting(paddle.getRectLines()[2])) { // left block limit
            if (start + section >= collisionPoint.getX()) {  //0 to 1/5 of the paddle hit
                currentVelocity = currentVelocity.fromAngleAndSpeed(120, speed);
            }
            if (((start + (2 * section)) >= collisionPoint.getX()) && (start
                    + section < collisionPoint.getX())) {  // 1/5 to 2/5 of the paddle hit
                currentVelocity = currentVelocity.fromAngleAndSpeed(150, speed);
            }
            if (((start + (3 * section)) >= collisionPoint.getX()) && ((start
                    + (2 * section)) < collisionPoint.getX())) {  // 2/5 to 3/5 of the paddle hit
                currentVelocity = currentVelocity.fromAngleAndSpeed(180, speed);
            }
            if (((start + (4 * section)) >= collisionPoint.getX()) && ((start
                    + (3 * section)) < collisionPoint.getX())) {  // 3/5 to 4/5 of the paddle hit
                currentVelocity = currentVelocity.fromAngleAndSpeed(210, speed);
            }
            if (((start + (5 * section)) >= collisionPoint.getX()) && ((start
                    + (4 * section)) < collisionPoint.getX())) { // 4/5 to 5/5 of the paddle hit
                currentVelocity = currentVelocity.fromAngleAndSpeed(240, speed);
            }
        }
            if (zero.isIntersecting(paddle.getRectLines()[1])) { // left block limit
                currentVelocity = currentVelocity.fromAngleAndSpeed(60, speed);
            }
            if (zero.isIntersecting(paddle.getRectLines()[3])) { // right block limit
                currentVelocity = currentVelocity.fromAngleAndSpeed(-60, speed);
            }
            if (zero.isIntersecting(paddle.getRectLines()[0])) { // down block limit
                if (start + section >= collisionPoint.getX()) {  //0 to 1/5 of the paddle hit
                    currentVelocity = currentVelocity.fromAngleAndSpeed(-60, speed);
                }
                if (((start + (2 * section)) >= collisionPoint.getX()) && (start
                        + section < collisionPoint.getX())) {  // 1/5 to 2/5 of the paddle hit
                    currentVelocity = currentVelocity.fromAngleAndSpeed(-30, speed);
                }
                if (((start + (3 * section)) >= collisionPoint.getX()) && ((start
                        + (2 * section)) < collisionPoint.getX())) {  // 2/5 to 3/5 of the paddle hit
                    currentVelocity = currentVelocity.fromAngleAndSpeed(0, speed);
                }
                if (((start + (4 * section)) >= collisionPoint.getX()) && ((start
                        + (3 * section)) < collisionPoint.getX())) {  // 3/5 to 4/5 of the paddle hit
                    currentVelocity = currentVelocity.fromAngleAndSpeed(30, speed);
                }
                if (((start + (5 * section)) >= collisionPoint.getX()) && ((start
                        + (4 * section)) < collisionPoint.getX())) { // 4/5 to 5/5 of the paddle hit
                    currentVelocity = currentVelocity.fromAngleAndSpeed(60, speed);
                }

            }
            return currentVelocity;

    }



    /**
     * Add this paddle to the game.
     * @param g game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
        this.game = g;
    }

    /**
     * adding keyboard to the paddle.
     * @param keyboard of player.
     */
    public void addToKeyboard(biuoop.KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

}
