package Test;

import Engine.Game;
import Engine.GameLoop.FixedTimeStepLoop;

public class Main {

    public static void main(String[] args)
    {
        Game game = new Game(new FixedTimeStepLoop(0, 60));
        game.start();
    }
}
