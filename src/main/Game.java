package main;

import java.util.ArrayList;
import java.util.List;
import levels.LevelInformation;
import animations.AnimationRunner;
import animations.DrawAnimationHelp;
import game.GameFlow;
import utilities.*;
/***
 * <p>
 *Game main class
 * </p>
 * the main class will run the game and initialize it.
 * @author Shahar Razlan.
 */
public class Game {
    /**
     * this function will gets the arguments, run the game.
     * @param args arguments.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        biuoop.GUI gui = new biuoop.GUI("Game", 800, 600);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        AnimationRunner ar  = new AnimationRunner(gui);
        DrawAnimationHelp h =  new DrawAnimationHelp();
        ArrayList<Integer> mylist  = h.stringToInt(args);
        if (mylist.size() > 0) {
            GameFlow gameFlow = new GameFlow(ar, keyboard, gui,  mylist);
            gameFlow.runLevels(levels);
        } else {
            GameFlow gameFlow = new GameFlow(ar, keyboard, gui);
            gameFlow.runLevels(levels);
        }
    }
}
