package me.superischroma.superawt;

import me.superischroma.superawt.logger.AWTLogger;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public abstract class AWTApplication
{
    private static AWTApplication app = null;
    public static AWTApplication getApplication()
    {
        return app;
    }

    private AWTProperties props;
    private AWTFrame frame;

    public AWTApplication()
    {
        this.props = this.getClass().getAnnotation(AWTProperties.class);
        if (props == null)
        {
            SuperAWT.shutdown(ShutdownCode.INVALID_PROPERTIES);
            return;
        }
        if (app != null)
        {
            SuperAWT.shutdown(ShutdownCode.NEW_APP_CREATED);
            return;
        }
        app = this;
        frame = new AWTFrame();
        frame.setBackground(new Color(props.backgroundBlue(), props.backgroundGreen(), props.backgroundRed()));
        this.setFrameRate(props.framesPerSecond());
        AWTLogger.DEFAULT.info("Created application.");
    }

    public void name(String name)
    {
        frame.setTitle(name);
    }

    public void resizeable()
    {
        frame.setResizable(!frame.isResizable());
    }

    public void setFrameRate(int max)
    {
        if (SuperAWT.TIMER != null)
            SuperAWT.TIMER.cancel();
        SuperAWT.TIMER = new Timer();
        SuperAWT.TIMER.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                frame.render();
            }
        }, 0, 1000 / max);
    }

    public abstract void enable();
    public abstract void disable();
    public abstract void update();
}