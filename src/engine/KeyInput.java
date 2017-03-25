package engine;

import game.Game;
import game.objects.Hero;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by zdravko on 6.11.16..
 */
public class KeyInput extends KeyAdapter
{
    Game game;
    Integer key;

    private boolean keyDown[] = new boolean[4]; // 0-up 1-down 2-right 3-left

    public KeyInput(Game g)
    {
        game = g;

        for(int i = 0; i < keyDown.length; ++i)
            keyDown[i] = false;
    }


    public void keyPressed(KeyEvent e)
    {
        key = e.getKeyCode();
        Hero hero = game.getHero();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) { hero.setVelX(-4); keyDown[3] = true; }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) { hero.setVelX(4); keyDown[2] = true;}
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) { hero.setVelY(-4); keyDown[0] = true; }
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) { hero.setVelY(4); keyDown[1] = true; }


        if(key == KeyEvent.VK_ESCAPE)
            System.exit(1);
    }


    public void keyReleased(KeyEvent e)
    {
        key = e.getKeyCode();
        Hero hero = game.getHero();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) keyDown[3] = false;
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) keyDown[2] = false;
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) keyDown[0] = false;
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) keyDown[1] = false;

        //vertical movement
        if(!keyDown[0] && !keyDown[1]) hero.setVelY(0);

        //horizontal movement
        if(!keyDown[2] && !keyDown[3]) hero.setVelX(0);

        key = null;
    }
}
