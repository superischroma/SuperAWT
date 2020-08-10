/*
package org.example.awtexample;

import me.superischroma.superawt.AWTApplication;
import me.superischroma.superawt.AWTProperties;
import me.superischroma.superawt.KeyPressResult;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

@AWTProperties(title = "An Example Application", width = 500, height = 500, resizeable = false, clearOnUpdate = false)
public class Example extends AWTApplication
{
    private static final Random RANDOM = new Random();
    private static final Color BASE = new Color(228, 220, 136);

    @Override
    public void enable() // Code here will be ran when the application starts.
    {
        background(BASE);
        addKeyPressResult(new KeyPressResult(KeyEvent.VK_F)
        {
            @Override
            public void run()
            {
                background(new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255)));
            }
        });
        logger.info("Enabled");
    }

    @Override
    public void disable() // Code here will be ran when the application ends.
    {
        logger.info("Disabled");
    }

    @Override
    public void update() // Code here will be ran every frame of the application.
    {
        rect(RANDOM.nextInt(450), RANDOM.nextInt(450), 50, 50, new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255)));
    }
}
*/