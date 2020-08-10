package me.superischroma.superawt;

import me.superischroma.superawt.logger.AWTLogger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AWTImage
{
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;

    public AWTImage(int x, int y, String path)
    {
        try { this.image = ImageIO.read(new File(path)); }
        catch (IOException ex)
        {
            AWTLogger.DEFAULT.warn("Failed to find image!");
            return;
        }
        this.x = x;
        this.y = y;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public Image getImage()
    {
        return image;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
}