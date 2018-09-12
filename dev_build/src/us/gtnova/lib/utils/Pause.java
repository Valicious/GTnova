package us.gtnova.lib.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pause {
    public boolean done = true;

    public void pause(long timeMS){
        ScheduledExecutorService coolDown = Executors.newScheduledThreadPool(1);
        done = false;
        coolDown.schedule(() -> done = true, timeMS, TimeUnit.MILLISECONDS);
    }
}
