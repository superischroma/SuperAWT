package me.superischroma.superawt;

import java.awt.*;

public class ColoredRectangle extends Rectangle
{
    private final Color color;

    public ColoredRectangle(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height);
        this.color = color;
    }

    public ColoredRectangle(Rectangle rectangle, Color color)
    {
        super(rectangle);
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }
}