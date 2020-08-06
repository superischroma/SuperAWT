package me.superischroma.superawt;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTFrame extends Frame
{
    private final AWTPanel panel;

    public AWTFrame()
    {
        super();
        this.panel = new AWTPanel(this);
        this.addWindowListener(CLOSE);
        this.add(panel);
        this.setTitle(AWTApplication.getApplication().getClass().getSimpleName());
        this.setVisible(true);
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
    }

    public void render()
    {
        panel.repaint();
    }

    public Color getBackground()
    {
        return panel.getBackground();
    }

    public void setBackground(Color color)
    {
        panel.setBackground(color);
    }

    private static WindowListener CLOSE = new WindowListener()
    {
        @Override
        public void windowOpened(WindowEvent windowEvent) {}

        @Override
        public void windowClosing(WindowEvent windowEvent)
        {
            SuperAWT.shutdown(ShutdownCode.OK);
        }

        @Override
        public void windowClosed(WindowEvent windowEvent) {}

        @Override
        public void windowIconified(WindowEvent windowEvent) {}

        @Override
        public void windowDeiconified(WindowEvent windowEvent) {}

        @Override
        public void windowActivated(WindowEvent windowEvent) {}

        @Override
        public void windowDeactivated(WindowEvent windowEvent) {}
    };
}