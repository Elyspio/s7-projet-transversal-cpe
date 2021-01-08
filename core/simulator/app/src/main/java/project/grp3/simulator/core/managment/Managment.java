package project.grp3.simulator.core.managment;

import project.grp3.simulator.config.ManagmentConfig;

import java.util.Timer;
import java.util.TimerTask;

public class Managment
{
    private static Managment instance;
    private final Timer timer;


    private Managment()
    {
        this(ManagmentConfig.timebetweenRuns);
    }

    private Managment(Integer timebetweenRuns)
    {
        FireManagment fireManagment = new FireManagment();

        this.timer = new Timer();
        this.timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                doTurn(fireManagment);
            }
        }, 0, timebetweenRuns);
    }


    public static void stop() throws Exception
    {
        if (instance == null)
        {
            throw new Exception("Core Managment was not init");
        }
        else
        {
            Managment.instance.timer.cancel();
            Managment.instance = null;
        }
    }

    /**
     * Will start the managment system
     *
     * @return
     * @throws Exception
     */
    public static Managment init() throws Exception
    {
        if (instance == null)
        {
            instance = new Managment();
        }
        else
        {
            throw new Exception("Core Managment is already inited");
        }
        return instance;
    }

    private void doTurn(IManagment... managments)
    {
        for (var m : managments)
        {
            m.doTurn();
        }
    }
}
