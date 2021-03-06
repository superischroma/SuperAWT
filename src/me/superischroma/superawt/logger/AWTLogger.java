package me.superischroma.superawt.logger;

import me.superischroma.superawt.AWTApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AWTLogger
{
    public static final AWTLogger DEFAULT = new AWTLogger("SAWT");
    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    private String prefix;

    public AWTLogger(String prefix)
    {
        this.prefix = prefix;
    }

    public void log(Object o, Level l)
    {
        System.out.println("[" + format.format(new Date()) + "] [" + prefix + " | " + l.name() + "] " + o);
    }

    public void debug(Object o)
    {
        if (AWTApplication.getApplication().isDebugEnabled())
            log(o, Level.DEBUG);
    }

    public void info(Object o)
    {
        log(o, Level.INFO);
    }

    public void warn(Object o)
    {
        log(o, Level.WARN);
    }

    public void severe(Object o)
    {
        log(o, Level.ERROR);
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }
}