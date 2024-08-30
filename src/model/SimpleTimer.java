package model;

import java.util.Timer;
import java.util.TimerTask;

public class SimpleTimer extends TimeMeasurement<SimpleTimer> implements ClockBehavior {
    int timeToStop;
    Timer timer;

    public SimpleTimer(int timeToStop) {
        this.timeToStop = timeToStop;
    }

    @Override
    public void start() {
        timer = new Timer();
        System.out.println("run timer");
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(timeToStop--);
                if (timeToStop < 0) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    @Override
    public void stop() {
        System.out.println("stop timer");
        timer.cancel();
    }

    @Override
    protected void reset() {

    }

    @Override
    public void seeCurrentTime() {

    }
}
