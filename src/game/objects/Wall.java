package game.objects;

import game.GameObject;
import game.ObjectType;

import java.awt.*;

/**
 * Created by zdravko on 5.11.16..
 */
public class Wall extends GameObject {
    public static final int SIZE = 32;

    public Wall(float x, float y) {
        super(x, y, 0, 0, ObjectType.Wall); // da'l ubaciti i brzinu u zidove, da budu pokretni ho ho
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        ///g.setFont(new Font("Arial black", 1, 32));
        g.fillRect((int)x, (int)y, SIZE, SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, SIZE, SIZE);
    }

    @Override
    public Rectangle getTopBounds() {
        return null;
    }

    @Override
    public Rectangle getBottomBounds() {
        return null;
    }

    @Override
    public Rectangle getLeftBounds() {
        return null;
    }

    @Override
    public Rectangle getRightBounds() {
        return null;
    }

}
