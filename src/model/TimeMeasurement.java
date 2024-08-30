package model;

import java.io.InputStreamReader;
import java.util.Scanner;

public abstract class TimeMeasurement<T> implements ClockBehavior {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    public void startDevice() {
        boolean isExit = true;
            start();
            while (isExit) {
                String consoleCommand = scanner.next();
                if (consoleCommand.equals("start")) {
                    start();
                }
                if (consoleCommand.equals("stop")) {
                    stop();
                }
                if (consoleCommand.equals("reset")) {
                    reset();
                }
                if (consoleCommand.equals("exit")) {
                    isExit = false;
                }
            }
        }

    protected abstract void start();
    protected abstract void stop();
    protected abstract void reset();
}
