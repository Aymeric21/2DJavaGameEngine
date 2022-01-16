package Engine.GameLoop;

public class FixedTimeStepLoop implements GameLoop
{
    private final int UPDATES_PER_SECOND;
    private final int MAX_FRAMES_PER_SECOND;

    private final double NANOSECONDS_PER_UPDATE;
    private final double NANOSECONDS_PER_FRAMES;

    private int ups;
    private int fps;

    public FixedTimeStepLoop(int updatesPerSecond, int maxFramesPerSecond)
    {
        this.UPDATES_PER_SECOND = updatesPerSecond;
        this.MAX_FRAMES_PER_SECOND = maxFramesPerSecond;

        this.NANOSECONDS_PER_UPDATE = 1e9 / this.UPDATES_PER_SECOND;
        this.NANOSECONDS_PER_FRAMES = 1e9 / this.MAX_FRAMES_PER_SECOND;

        this.ups = 0;
        this.fps = 0;
    }

    @Override
    public void loop()
    {
        long currentTime;
        long lastUpdateTime = System.nanoTime();
        long lastRenderTime = lastUpdateTime;
        long passedUpdateTime;
        long passedRenderTime;

        long lastSecond = lastUpdateTime;

        int updateCount = 0;
        int frameCount = 0;

        while(true)
        {
            currentTime = System.nanoTime();
            passedUpdateTime = currentTime - lastUpdateTime;
            passedRenderTime = currentTime - lastRenderTime;

            if(passedUpdateTime >= this.NANOSECONDS_PER_UPDATE)
            {
                this.update();
                updateCount++;
                lastUpdateTime = System.nanoTime();
            }

            if(passedRenderTime >= this.NANOSECONDS_PER_FRAMES)
            {
                this.render();
                frameCount++;
                lastRenderTime = System.nanoTime();
            }

            currentTime = System.nanoTime();
            if(currentTime - lastSecond >= 1e9)
            {
                this.ups = updateCount;
                updateCount = 0;

                this.fps = frameCount;
                frameCount = 0;

                lastSecond = currentTime;
            }

            while(currentTime-lastUpdateTime <= NANOSECONDS_PER_UPDATE && currentTime-lastRenderTime <= NANOSECONDS_PER_FRAMES)
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                currentTime = System.nanoTime();
            }
        }
    }

    public void update()
    {
        //System.out.println("Fixed time step loop update");
        System.out.println("\tUPS : " + this.ups);

        /*long time = System.currentTimeMillis();
        int second = (int)(time/1000);
        int ms = (int)(time%1000);

        System.out.println("\t\t" + second + "s " + ms + "ms");*/
    }

    public void render()
    {
        //System.out.println("Fixed time step loop rendering");
        System.out.println("\tFPS : " + this.fps);

        /*long time = System.currentTimeMillis();
        int second = (int)(time/1000);
        int ms = (int)(time%1000);

        System.out.println("\t\t" + second + "s " + ms + "ms");*/
    }
}
