package me.superischroma.superawt;

import me.superischroma.superawt.logger.AWTLogger;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public abstract class AWTApplication
{
    private static AWTApplication app = null;
    public static AWTApplication getApplication()
    {
        return app;
    }

    public AWTProperties props;
    private boolean debug;
    private AWTFrame frame;
    private List<KeyPressResult> presses;

    public AWTLogger logger;

    public AWTApplication()
    {
        this.props = this.getClass().getAnnotation(AWTProperties.class);
        this.debug = props.debug();
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
        this.frame = new AWTFrame(props);
        this.frame.addKeyListener(new ApplicationKeyHandler());
        this.presses = new ArrayList<>();
        String ln = props.title();
        if (props.title().equals(""))
            ln = AWTApplication.getApplication().getClass().getSimpleName();
        this.logger = new AWTLogger(ln);
        this.setFrameRate(props.fps());
    }

    /**
     * Adds a key press result to the application.
     * @param result
     */
    public void addKeyPressResult(KeyPressResult result)
    {
        presses.add(result);
    }

    /**
     * Gets all key press results for the application.
     * @return presses
     */
    public List<KeyPressResult> getPresses()
    {
        return presses;
    }

    /**
     * Modifies the name of the application (title).
     * @param name
     */
    public void name(String name)
    {
        frame.setTitle(name);
        logger.setPrefix(name);
    }

    /**
     * Gets the name of the application (title).
     * @return name
     */
    public String getName()
    {
        return frame.getTitle();
    }

    /**
     * Modifies the application's background.
     * @param background
     */
    public void background(Color background)
    {
        frame.background(background);
    }

    /**
     * Creates a rectangle on the application with the specified dimensions and color.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public void rect(int x, int y, int width, int height, Color color)
    {
        frame.rect(x, y, width, height, color);
    }

    /**
     * Creates an image on the application with the specified dimensions.
     * @param x
     * @param y
     * @param path
     */
    public void img(int x, int y, String path)
    {
        frame.img(x, y, path);
    }

    /**
     * Determines whether debug messages are shown in console.
     * @param debug
     */
    public void debug(boolean debug)
    {
        this.debug = debug;
    }

    /**
     * Checks whether debug messages are shown in console.
     * @return debug
     */
    public boolean isDebugEnabled()
    {
        return debug;
    }

    private void setFrameRate(int max)
    {
        if (SuperAWT.TIMER != null)
            SuperAWT.TIMER.cancel();
        SuperAWT.TIMER = new Timer();
        SuperAWT.TIMER.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                if (props.clearOnUpdate())
                    frame.clear();
                for (KeyPressResult result : presses)
                {
                    if (ApplicationKeyHandler.PRESSED.contains(result.getKey()))
                    {
                        result.run();
                    }
                }
                update();
                frame.render();
            }
        }, 0, 1000 / max);
    }

    /**
     * What the application runs when it gets enabled.
     */
    public abstract void enable();
    /**
     * What the application runs when it gets disabled.
     */
    public abstract void disable();
    /**
     * What the application runs every frame.
     */
    public abstract void update();
}