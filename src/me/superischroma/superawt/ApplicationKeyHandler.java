package me.superischroma.superawt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

public class ApplicationKeyHandler implements KeyListener
{
    public static List<Integer> PRESSED = new ArrayList<>();

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (!PRESSED.contains(e.getKeyCode()))
            PRESSED.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        PRESSED.remove(new Integer(e.getKeyCode()));
    }
}