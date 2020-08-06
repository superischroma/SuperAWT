package me.superischroma.superawt;

import me.superischroma.superawt.logger.AWTLogger;
import org.example.awtexample.Example;

import java.util.Timer;

public class SuperAWT
{
    public static Timer TIMER;

    public static void main(String[] args)
    {
        AWTLogger.DEFAULT.info("Enabling application");
        // instance your main class here
        new Example();
        AWTApplication.getApplication().enable();
    }

    public static void shutdown(ShutdownCode code)
    {
        AWTLogger.DEFAULT.info("Disabling application");
        AWTApplication.getApplication().disable();
        AWTLogger.DEFAULT.log(code.getMessage(), code.getLevel());
        System.exit(code.getCode());
    }

    private static Thread sd = new Thread(() ->
            shutdown(ShutdownCode.OK));
}