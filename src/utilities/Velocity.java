package utilities;
import game.GameLevel;
import sprites.Ball;
import sprites.CollisionInfo;
/***
 * <p>
 * a class that create velocity of a ball
 * </p>
 * the program will delta x val and delta y val define by them it velocity,
 * and set the direction and speed of the ball.
 * @author Shahar Razlan
 */
public class Velocity {
    private double dx, dy;

    /**
     * a constructor.
     * @param dx The difference in absolute value between two x coordinate.
     * @param dy The difference in absolute value between two y coordinate.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * a function that calculate the ball velocity by given angle and speed.
     * @param angle angle in degrees.
     * @param speed by pitagoras.
     * @return ball velocity.
     */
    public Velocity fromAngleAndSpeed(double angle, double speed) {
        double dy = speed * Math.cos(Math.toRadians(angle));
        double dx = speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dx, -dy);
    }

    /**
     * gets ball velocity dx.
     * @return dx.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * gets ball velocity dy.
     * @return dy.
     */

    public double getDy() {
        return this.dy;
    }


    /**
     * Take a point with position (x,y) and return a new point with position.
     * @param p center of ball.
     * @param r ball radius.
     * @param ball the ball.
     * @param game the game.
     * @return new point of destination.
     */
    public Point applyToPoint(Ball ball, Point p, int r, GameLevel game) {
        Line[] lines = new Line[4];
        double x = p.getX(), y = p.getY();
        x += this.dx;
        y += this.dy;
        lines[0] = new Line(p.getX(), p.getY(), x + r, y + r); // in order for the ball to hit on surface.
        lines[1] = new Line(p.getX(), p.getY(), x + r, y);  // of collidables.
        lines[2] = new Line(p.getX(), p.getY(), x - r, y);
        lines[3] = new Line(p.getX(), p.getY(), x - r, y - r);
        for (int i = 0; i < 4; ++i) {
            CollisionInfo co = game.getEnvironment().getClosestCollision(lines[i]); // checks every move, the ball is
            // near to collidable object.
            if (co != null) {
                Velocity v2 = co.collisionObject().hit(ball, co.collisionPoint(),
                        new Velocity(this.dx, this.dy)); // call hit
                // function of collidable obj.
                this.dx = v2.getDx();
                this.dy = v2.getDy();
            }
        }

        Point pt = new Point(x, y);
        return pt;
    }

}
