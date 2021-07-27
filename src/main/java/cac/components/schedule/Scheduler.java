package cac.components.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final ScheduledExecutorService rep;

    public Scheduler() {
        rep = Executors.newSingleThreadScheduledExecutor();
    }

    public void schedule(Runnable command, long delay, TimeUnit unit) {
        rep.schedule(command, delay, unit);
    }

    public void scheduleAtFixedRate(Runnable command, long delay, long period, TimeUnit unit) {
        rep.scheduleAtFixedRate(command, delay, period, unit);
    }

    public void scheduleWithFixedDelay(Runnable command, long delay, long period, TimeUnit unit) {
        rep.scheduleWithFixedDelay(command, delay, period, unit);
    }
}
