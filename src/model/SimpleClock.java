package model;

import java.time.LocalTime;

public class SimpleClock implements ClockBehavior {
    @Override
    public void seeCurrentTime() {
        System.out.println("Current time is " + LocalTime.now());
    }
}
