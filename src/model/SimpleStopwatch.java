package model;

import java.time.Duration;
import java.time.Instant;

public class SimpleStopwatch extends TimeMeasurement<SimpleStopwatch> implements ClockBehavior {
    private Instant startTime, endTime;
    private Duration duration;
    private boolean isRunning = false;

    @Override
    protected void start() {
        System.out.println("Stopwatch turned on. Enter stop or reset");

        if (isRunning) {
            throw new RuntimeException("Stopwatch is already running.");
        }

        this.isRunning = true;
        startTime = Instant.now();
    }

    @Override
    protected void stop() {
        System.out.println("Stopwatch stopped. Enter start or reset");
        if (!isRunning) {
            throw new RuntimeException("Stopwatch is already stopped.");
        }

        endTime = Instant.now();
        isRunning = false;
        Duration result = Duration.between(startTime, endTime);

        if (this.duration == null) {
            this.duration = result;
        } else {
            this.duration = duration.plus(result);
        }

        getElapsedTime();
    }

    private void getElapsedTime() {
        System.out.println(duration.toMillis() / 1000.0);
    }

    public void reset() {
        if (isRunning) {
            this.stop();
        }
        this.duration = null;
    }

    @Override
    public void seeCurrentTime() {

    }
}
