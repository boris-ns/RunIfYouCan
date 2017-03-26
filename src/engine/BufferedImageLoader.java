package engine;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Created by boris on 11/11/16.
 * edited by nmikovic
 */

// Klasa koja sluzi za ucitavanje slike u BufferedImage objekat na osnovu putanje koja se prosledi
public class BufferedImageLoader
{
    private BufferedImage image;

    public BufferedImage loadImage(String path)
    {
        try
        {
            image = ImageIO.read(getClass().getResource(path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return image;
    }
}