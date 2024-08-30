package model;

public class ClockApp {
    private static ClockMode clockAppMode = ClockMode.CLOCK;
    //private final Map<model.ClockMode, model.Clock> CLOCK_MODE_OBJECTS = new HashMap<>();
    private final ClockBehavior clock;
    private final TimeMeasurement<SimpleTimer> timer;
    private final TimeMeasurement<SimpleStopwatch> stopwatch;


    public ClockApp(ClockBehavior clock, TimeMeasurement<SimpleTimer> timer, TimeMeasurement<SimpleStopwatch> stopwatch) {
        this.clock = clock;
        this.timer = timer;
        this.stopwatch = stopwatch;

        /*CLOCK_MODE_OBJECTS.put(model.ClockMode.CLOCK, clock);
        CLOCK_MODE_OBJECTS.put(model.ClockMode.TIMER, timer);
        CLOCK_MODE_OBJECTS.put(model.ClockMode.STOPWATCH, stopwatch);*/
    }

    public void changeAppMode(ClockMode clockMode) {
        if (clockMode == clockAppMode) {
            throw new IllegalArgumentException("This mode is already activated");
        }
        clockAppMode = clockMode;
    }

    public void startApp() throws InterruptedException {
        switch (clockAppMode) {
            case CLOCK -> seeCurrentTime();
            case TIMER -> start(timer);
            case STOPWATCH -> start(stopwatch);
        }
    }

    private void seeCurrentTime() {
        if (clockAppMode != ClockMode.CLOCK) {
            throw new IllegalArgumentException("Change mode on TIMER or STOPWATCH");
        }

        clock.seeCurrentTime();
    }

    private <T> void start(TimeMeasurement<? extends TimeMeasurement<T>> timeMeasurement) throws InterruptedException {
        timeMeasurement.startDevice();
    }
}
