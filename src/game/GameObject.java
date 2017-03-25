package game;

import java.awt.*;

/**
 * Created by boris on 10/25/16.
 */
public abstract class GameObject
{
    protected float x = 0.0f, y = 0.0f;             // X, Y koordinate
    protected float velX = 0.0f, velY = 0.0f;       // brzina kretanja po X,Y koordinati
    protected ObjectType objectType;

    public GameObject(float x, float y, float velX, float velY, ObjectType objectType)
    {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
        this.objectType = objectType;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();          // Get full bounds
    public abstract Rectangle getTopBounds();       // Get top bounds
    public abstract Rectangle getBottomBounds();    // Get bottom bounds
    public abstract Rectangle getLeftBounds();      // Get left bounds
    public abstract Rectangle getRightBounds();     // Get right bounds

    // Getters
    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getVelX()
    {
        return velX;
    }

    public float getVelY()
    {
        return velY;
    }

    public ObjectType getObjectType() { return objectType; }

    // Setters
    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setVelX(float velX)
    {
        this.velX = velX;
    }

    public void setVelY(float velY)
    {
        this.velY = velY;
    }
}
