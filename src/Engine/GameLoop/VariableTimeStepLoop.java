/*TODO: à implémenter*/
/*package Engine.GameLoop;

public class VariableTimeStepLoop implements GameLoop
{
    private long lastLoopTime = System.nanoTime();
    private final int TARGET_FPS = 60;
    private final long OPTIMAL_TIME = 1000000000/TARGET_FPS;

    private boolean running;

    public VariableTimeStepLoop()
    {
        running = true;
    }

    @Override
    public void start()
    {
        while(running)
        {
            long now = System.nanoTime();
            long updateLength = now-lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength/(double)OPTIMAL_TIME;

            lastLoopTime += updateLength;
            fps++;

            if(lastLoopTime >= 1000000000)
            {
                System.out.println("FPS : " + fps);
                lastLoopTime = 0;
                fps = 0;
            }

            update(delta);
            render();

            try
            {
                Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }


    //Toutes les variables relatives au temps doivent être multipliées par delta
    public void update(double delta)
    {

    }

    public void render()
    {

    }
}*/
