package me.superischroma.superawt;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class AWTPanel extends Panel
{
    private final List<ColoredRectangle> rectangles;
    private final AWTFrame parent;

    public AWTPanel(AWTFrame parent)
    {
        super();
        this.rectangles = new ArrayList<>();
        this.parent = parent;
        this.addRectangle(0, 0, parent.getWidth(), parent.getHeight(), Color.WHITE);
    }

    public Color getBackground()
    {
        if (rectangles.size() == 0)
            return Color.BLACK;
        return rectangles.get(0).getColor();
    }

    public void setBackground(Color color)
    {
        if (rectangles.size() == 0)
        {
            addRectangle(0, 0, parent.getWidth(), parent.getHeight(), color);
            return;
        }
        rectangles.set(0, new ColoredRectangle(0, 0, parent.getWidth(), parent.getHeight(), color));
    }

    public void addRectangle(ColoredRectangle rectangle)
    {
        rectangles.add(rectangle);
    }

    public void addRectangle(Rectangle rectangle, Color color)
    {
        rectangles.add(new ColoredRectangle(rectangle, color));
    }

    public void addRectangle(int x, int y, int width, int height, Color color)
    {
        rectangles.add(new ColoredRectangle(x, y, width, height, color));
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Paint cP = g2d.getPaint();
        for (ColoredRectangle rectangle : rectangles)
        {
            g2d.setPaint(rectangle.getColor());
            g2d.fillRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        }
        g2d.setPaint(cP);
    }
}