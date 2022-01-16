package Engine;

import Engine.GameLoop.FixedTimeStepLoop;
import Engine.GameLoop.GameLoop;

public class Game
{
    private GameLoop gameLoop;

    public Game(GameLoop gameLoop)
    {
        this.gameLoop = gameLoop;
    }

    public void start()
    {
        this.gameLoop.loop();
    }

    public void setGameLoop(GameLoop gameLoop)
    {
        this.gameLoop = gameLoop;
    }
}
