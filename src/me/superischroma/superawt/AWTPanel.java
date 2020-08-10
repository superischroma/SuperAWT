package me.superischroma.superawt;

import javax.swing.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.awt.*;

public class AWTPanel extends JPanel
{
    private static AWTApplication app = AWTApplication.getApplication();

    private final List<ColoredRectangle> rectangles;
    private final List<AWTImage> images;
    private Color background;

    public AWTPanel()
    {
        super();
        this.rectangles = new ArrayList<>();
        this.images = new ArrayList<>();
        this.background = Color.BLACK;
    }

    public void setBackground(Color background)
    {
        this.background = background;
    }

    public void clear()
    {
        rectangles.clear();
        images.clear();
    }

    public int getObjectCount()
    {
        return rectangles.size() + images.size();
    }

    public Color getBackground()
    {
        return background;
    }

    public void addRectangle(ColoredRectangle rectangle)
    {
        app.logger.debug("Created a new rectangle at X: " + rectangle.getX() + ", Y: " + rectangle.getY() + " with a width of " + rectangle.getWidth() +
                ", a height of " + rectangle.getHeight() + ", and with a color with " + rectangle.getColor().getRed() +
                ", " + rectangle.getColor().getGreen() + ", " + rectangle.getColor().getBlue() + ".");
        rectangles.add(rectangle);
    }

    public void addRectangle(Rectangle rectangle, Color color)
    {
        addRectangle(new ColoredRectangle(rectangle, color));
    }

    public void addRectangle(int x, int y, int width, int height, Color color)
    {
        addRectangle(new ColoredRectangle(x, y, width, height, color));
    }

    public void addImage(AWTImage image)
    {
        app.logger.debug("Created a new image at X: " + image.getX() + ", Y: " + image.getY() + " with a width of " + image.getWidth() +
                ", and a height of " + image.getHeight() + ".");
        images.add(image);
    }

    public void addImage(int x, int y, String path)
    {
        addImage(new AWTImage(x, y, path));
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        this.setOpaque(true);
        this.setBackground(background);
        Graphics2D g2d = (Graphics2D) g;
        Paint cP = g2d.getPaint();
        if (getObjectCount() >= app.props.objectClearLimit())
        {
            if (app.props.objectClearLimit() >= 0)
            {
                clear();
                app.logger.debug("All objects have been cleared from the application because the amount exceeded its object limit.");
            }
        }
        try
        {
            for (ColoredRectangle rectangle : rectangles)
            {
                g2d.setPaint(rectangle.getColor());
                g2d.fillRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
            }
            for (AWTImage image : images)
            {
                g2d.drawImage(image.getImage(), image.getX(), image.getY(), null);
            }
        }
        catch (ConcurrentModificationException ex)
        {
            app.logger.severe("Rendering failed! Are you creating massive amounts of objects?");
        }
        g2d.setPaint(cP);
    }
}