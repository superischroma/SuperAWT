package me.superischroma.superawt;

import me.superischroma.superawt.logger.AWTLogger;

import java.util.Timer;

public class SuperAWT
{
    public static Timer TIMER;

    public static void main(String[] args)
    {
        AWTLogger.DEFAULT.info("Enabling application");
        // instance your application here
        AWTApplication.getApplication().enable();
    }

    public static void shutdown(ShutdownCode code)
    {
        if (AWTApplication.getApplication() != null)
        {
            AWTLogger.DEFAULT.info("Disabling application");
            AWTApplication.getApplication().disable();
        }
        AWTLogger.DEFAULT.log(code.getMessage(), code.getLevel());
        System.exit(code.getCode());
    }
}