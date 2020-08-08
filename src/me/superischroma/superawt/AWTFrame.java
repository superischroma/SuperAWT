package me.superischroma.superawt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTFrame extends JFrame
{
    private final AWTPanel panel;

    public AWTFrame(AWTProperties props)
    {
        super();
        this.panel = new AWTPanel();
        this.add(panel);
        if (props.title().equals(""))
            this.setTitle(AWTApplication.getApplication().getClass().getSimpleName());
        else
            this.setTitle(props.title());
        this.setVisible(true);
        this.setSize(props.width(), props.height());
        this.setLocationRelativeTo(null);
        this.setResizable(props.resizeable());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(CLOSE);
    }

    public void clear()
    {
        panel.clear();
    }

    public void render()
    {
        panel.repaint();
    }

    public void rect(int x, int y, int width, int height, Color color)
    {
        panel.addRectangle(x, y, width, height, color);
    }

    public void background(Color color)
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