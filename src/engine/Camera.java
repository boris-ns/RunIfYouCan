package engine;

import game.GameObject;

/**
 * Created by zdravko on 11.11.16..
 */
public class Camera
{

    private float x, y;

    public Camera(float x, float y)
    {
        this.x = x;
        this.y = y;
    }


    public void tick(GameObject player) {
        // blin
        x = -player.getX() + Program.WIDTH/2;
        y = -player.getY() + Program.HEIGHT/2;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
