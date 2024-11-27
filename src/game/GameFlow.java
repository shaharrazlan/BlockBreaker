package game;
import utilities.*;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;

import animations.*;
import sprites.*;
import levels.*;

import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import levels.LevelInformation;

/***
 * <p>
 * a class that in charge of the game flow.
 * </p>
 * this class will run the different levels, animations and close it.
 * @author Shahar Razlan.
 */
public class GameFlow {
    private List<LevelInformation> levels;
    private final AnimationRunner ar;
    private final KeyboardSensor ks;
    private Counter score;
    private final GUI gui;
    private ArrayList<Integer> arg = new ArrayList<>();
    /**
     * the class constructor.
     * @param ar game animation runner.
     * @param ks game keyboard.
     * @param gui game gui.
     * @param args arguments.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui, ArrayList<Integer> args) {
        this.ar = ar;
        this.ks = ks;
        this.gui = gui;
        this.arg = args;
    }
    /**
     * the class constructor.
     * @param ar game animation runner.
     * @param ks game keyboard.
     * @param gui game gui.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.ar = ar;
        this.ks = ks;
        this.gui = gui;
        this.arg.add(1);
        this.arg.add(2);
        this.arg.add(3);
        this.arg.add(4);
    }

    /**
     * this function will run the levels of the game.
     * @param levels game levels list.
     */
    public void runLevels(List<LevelInformation> levels) {
        score = new Counter(0);
        Green3 green3 = new Green3();
        WideEasy wideEasy = new WideEasy();
        DirectHit directHit = new DirectHit();
        FinalFour finalFour = new FinalFour();
        levels.add(directHit);
        levels.add(wideEasy);
        levels.add(green3);
        levels.add(finalFour);
        for (int i = 0; i < this.arg.size(); ++i) {
            GameLevel level = new GameLevel(levels.get(this.arg.get(i) - 1), this.ar, this.ks, score);
            level.initialize();
            while (!level.shouldStop()) {
                level.run();
            }
            if (level.getBallCounter() == 0) { // no more balls == losing game.
                    this.ar.run(new KeyPressStoppableAnimation(this.ks, "space",
                            new EndGameLose(this.score.getValue())));
                gui.close();
            }
        }
        this.ar.run(new KeyPressStoppableAnimation(this.ks, "space", new EndGameWin(this.score.getValue())));
        gui.close();  // finishing game == wining game.
    }
}


