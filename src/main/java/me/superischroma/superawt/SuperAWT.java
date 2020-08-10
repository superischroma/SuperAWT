package me.superischroma.superawt;

import me.superischroma.superawt.logger.AWTLogger;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class SuperAWT
{
    public static Timer TIMER;

    public static void main(String[] args)
    {
        AWTLogger.DEFAULT.info("Enabling application");
        instantiateFirstApplication();
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

    public static void instantiateFirstApplication()
    {
        Reflections r = new Reflections();
        List<Class<? extends AWTApplication>> applications = new ArrayList<>(r.getSubTypesOf(AWTApplication.class));
        if (applications.size() == 0)
            shutdown(ShutdownCode.APP_NOT_FOUND);
        try
        {
            applications.get(0).newInstance();
        }
        catch (InstantiationException | IllegalAccessException ex)
        {
            shutdown(ShutdownCode.COULD_NOT_ACCESS_APP);
        }
    }
}