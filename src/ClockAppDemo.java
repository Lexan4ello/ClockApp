import model.*;

public class ClockAppDemo {
    public static void main(String[] args) throws InterruptedException {
        ClockApp clockApp = new ClockApp(new SimpleClock(), new SimpleTimer(10), new SimpleStopwatch());
        clockApp.startApp();
        clockApp.changeAppMode(ClockMode.STOPWATCH);
        clockApp.startApp();
        clockApp.changeAppMode(ClockMode.TIMER);
        clockApp.startApp();
    }
}
