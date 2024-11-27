package game;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import utilities.*;
import listeners.*;
import indicators.*;
import levels.LevelInformation;
import sprites.*;
import animations.*;
import levels.LevelName;



/***
 * <p>
 * class that will hold the sprites and the collidables, and will be in charge of the animation.
 * </p>
 * the program will set up the game, Initialize it and run the game.
 * @author Shahar Razlan.
 */
public class GameLevel implements Animation {
        private SpriteCollection sprites;
        private GameEnvironment environment;
        private biuoop.Sleeper sleeper;
        private int borderSize;
        private BlockRemover blockremover;
        private Counter blockcounter;
        private Counter ballcounter;
        private ScoreTrackingListener scorelistener;
        private final AnimationRunner runner;
        private final Counter score;
        private boolean running;
        private boolean first = true;
        private boolean sec = false;
        private final KeyboardSensor keyboard;
        private final LevelInformation lvl;
        private final int leftLives = 7;


        /**
         * game level constructor.
         * @param lvl game level.
         * @param runner game animation runner.
         * @param keyboard game keyboard.
         * @param score game score.
         */
        public GameLevel(LevelInformation lvl, AnimationRunner runner, KeyboardSensor keyboard, Counter score) {
                this.lvl = lvl;
                this.keyboard = keyboard;
                this.runner = runner;
                this.score = score;
        }

        /**
         * getter.
         * @return environment of the game.
         */
        public GameEnvironment getEnvironment() {
                return environment;
        }

        /**
         * a function  that add collidable objects to the game.
         * @param c  collidable object.
         */
        public void addCollidable(Collidable c) {
                environment.addCollidable(c);
        }

        /**
         * a function that add sprites to the game.
         * @param s sprite;
         */
        public void addSprite(Sprite s) {
           sprites.addSprite(s);
        }

        /**
         * a function for removing collidable from game.
         * @param c collidable.
         */
        public void removeCollidable(Collidable c) {
                environment.removeCollidable(c);
        }
        /**
         * a function for removing spirits from game.
         * @param s spirite.
         */
        public void removeSprite(Sprite s) {
                sprites.removeSprite(s);

        }

        /**
         * stopping condition of every level.
         * @return true for stop, false otherwise.
         */
        public boolean shouldStop() {
                int blockStop = lvl.blocks().size() - lvl.numberOfBlocksToRemove();
                if (blockcounter.getValue() == blockStop && sec) { // if all block removed.
                        sleeper.sleepFor(100);
                        return this.running;
                }
                if (blockcounter.getValue() == blockStop && first) {
                        score.increase(100); // all blocks removed == score increase by 100.
                        first = false;
                        sec = true;
                        return !this.running;
                }
                if (ballcounter.getValue() == 0) { // no more balls left.
                      return this.running;
                }
                return !this.running;
        }

        /**
         * number of balls that left.
         * @return number of balls.
         */
        public int getBallCounter() {
                return ballcounter.getValue();
        }
        /**
         * the function in charge of doing one frame of animation.
         * @param d the surface of one frame of animation.
         */
        public void doOneFrame(DrawSurface d) {
                this.sprites.drawAllOn(d);
                this.sprites.notifyAllTimePassed();
                if (this.keyboard.isPressed("p")) {
                        this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space", new PauseScreen()));
                }
        }

        private void genargateBlocks() {
                for (int j = 0; j < lvl.blocks().size(); ++j) { // add blocks.
                        Block b = lvl.blocks().get(j);
                        b.addToGame(this);
                        blockcounter.increase(1);
                        b.addHitListener(scorelistener);
                        b.addHitListener(blockremover);
                        }
                }


        private void genargateBorders(int size) {
                try {
                        if (size <= 0) {
                                throw new BadInitialize("size of border cant be non positive... ");
                        }
                        if (runner.getGuiHeight() > runner.getGuiwidth()) {
                                if (size > runner.getGuiwidth() / 10) {
                                        throw new BadInitialize("size of border too big... ");
                                }
                        }
                        if ((runner.getGuiHeight()) <= runner.getGuiwidth()) {
                                if (size > runner.getGuiHeight() / 10) {
                                        throw new BadInitialize("size of border too big... ");
                                }
                        }
                } catch (BadInitialize z) {
                        System.out.println(z);
                }
                Borders borderUp = new Borders(new Point(0, 20), runner.getGuiwidth(), size, Color.GRAY);
                borderUp.addToGame(this);
                Borders borderLeft = new Borders(new Point(0, size), size,
                        (runner.getGuiHeight() - size), Color.GRAY);
                borderLeft.addToGame(this);
                Borders borderRight = new Borders(new Point(runner.getGuiwidth() - size, size), size,
                        (runner.getGuiHeight() - size), Color.GRAY);
                borderRight.addToGame(this);
        }

        /**
         * this function in charge of genarating game balls.
         * @param numOfBalls number of balls.
         */
        public void generateBalls(int numOfBalls) {
                for (int i = 0; i < numOfBalls; i++) {
                        Ball ball1 = new Ball(new Point(400, 500), 5, Color.WHITE);
                        ball1.setVelocity(lvl.initialBallVelocities().get(i));
                        ball1.addToGame(this);
                        ballcounter.increase(1);

                }
        }
        /**
         * Initialize a new game: create the Blocks and Ball (and Paddle)
         * and add them to the game.
         */
        public void initialize() {
                sleeper = new biuoop.Sleeper();
                environment = new GameEnvironment(800, 600);
                sprites = new SpriteCollection();
                sprites.addSprite(lvl.getBackground());
                borderSize = 20;
                blockcounter = new Counter(0);
                ballcounter = new Counter(0);
                blockremover = new BlockRemover(this, blockcounter);
                BallRemover ballremover = new BallRemover(this, ballcounter);
                scorelistener = new ScoreTrackingListener(score);
                ScoreIndicator scoreIndicator = new ScoreIndicator(new Point(0, 0),
                        800, borderSize, Color.LIGHT_GRAY, score);
                scoreIndicator.addToGame(this);
                genargateBorders(borderSize);
                genargateBlocks();
                Borders borderDown = new Borders(new Point(borderSize, (runner.getGuiHeight() - borderSize)),
                       800, borderSize, Color.GRAY);
                environment.addCollidable(borderDown);
                borderDown.addHitListener(ballremover);
                Paddle paddle = new Paddle(new Point((400 - (lvl.paddleWidth() / 2)), 560),
                        lvl.paddleWidth(), 20, Color.ORANGE, lvl.paddleSpeed());
                paddle.addToGame(this);
                paddle.addToKeyboard(this.keyboard);
                LevelName name = new LevelName(lvl.levelName());
                name.addToGame(this);
                Lives lives = new Lives(leftLives, ballcounter);
                lives.addToGame(this);
        }
        /**
         * getter.
         * @return size of borders.
         */
        public int getBorderSize() {
                return borderSize;
        }


        /**
         * Run the game -- start the animation loop.
         */
        public void run() {
                generateBalls(this.lvl.numberOfBalls()); // or a similar method
                this.runner.run(new CountdownAnimation(2, 3, this.sprites));
                this.running = true;
                // use our runner to run the current animation -- which is one turn of
                this.runner.run(this);
        }

}


