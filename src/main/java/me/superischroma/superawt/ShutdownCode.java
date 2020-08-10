package me.superischroma.superawt;

import me.superischroma.superawt.logger.Level;

public enum ShutdownCode
{
    OK(0, "Shutting down...", Level.INFO),
    INVALID_CODE(-1, "Invalid shutdown code. Shutting down...", Level.ERROR),
    NEW_APP_CREATED(-2, "There can't be 2 applications at the same time! Shutting down...", Level.ERROR),
    INVALID_PROPERTIES(-3, "Application provided does not have properties! Shutting down...", Level.ERROR),
    APP_NOT_FOUND(-4, "SuperAWT could not identify an application! Shutting down...", Level.ERROR),
    COULD_NOT_ACCESS_APP(-5, "SuperAWT was unable to access the application! Shutting down...", Level.ERROR);

    private final int code;
    private final String message;
    private final Level level;

    ShutdownCode(int code, String message, Level level)
    {
        this.code = code;
        this.message = message;
        this.level = level;
    }

    public int getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

    public Level getLevel()
    {
        return level;
    }

    public static ShutdownCode findByCode(int code)
    {
        ShutdownCode c = null;
        for (ShutdownCode sc : ShutdownCode.values())
        {
            if (code == sc.getCode())
            {
                c = sc;
            }
        }
        return ShutdownCode.INVALID_CODE;
    }
}