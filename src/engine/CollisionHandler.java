package engine;

import java.util.LinkedList;

import game.Game;
import game.GameObject;
import game.objects.Bullet;
import game.objects.Hero;
import game.objects.Wall;
import game.objects.lists.BulletList;

/**
 * Created by boris on 11/6/16.
 */
public class CollisionHandler {
	
    private Game game;
    private Hero hero;
    private Wall wall;
    private Bullet bullet;
    private LinkedList<Wall> wallList;
    
    public CollisionHandler(Game game) {
        this.game = game;
        this.hero = game.getHero();
        
        wallList = game.getWallList().getWallLinkedList();
    }

    public void tick(LinkedList<GameObject> objects) {
    	collisionHeroWall();
    	collisionBulletWall();
    }

    private void collisionHeroWall() {
    	LinkedList<Wall> wallList = game.getWallList().getWallLinkedList();
    	
        for (int i = 0; i < wallList.size(); ++i) {
            wall = (Wall) wallList.get(i);

            if(wall.getBounds().intersects(hero.getTopBounds()))
                hero.setY(wall.getY() + Wall.SIZE);

            if(wall.getBounds().intersects(hero.getBottomBounds()))
                hero.setY(wall.getY() - Hero.WIDTH);

            if(wall.getBounds().intersects(hero.getRightBounds()))
                hero.setX(wall.getX() - Hero.WIDTH);

            if(wall.getBounds().intersects(hero.getLeftBounds()))
                hero.setX(wall.getX() + Wall.SIZE);
        }
    }
    
    private void collisionBulletWall() {
    	BulletList bulletList = game.getBulletList();
    	
    	for (int i = 0; i < bulletList.getBulletLinkedList().size(); ++i) {
    		for (int j = 0; j < wallList.size(); ++j) {
    			bullet = bulletList.getBulletLinkedList().get(i);
    			wall = wallList.get(j);
    			
    			if (bullet.getBounds().intersects(wall.getBounds())) {
    				bulletList.removeBullet(bullet);
    				break;
    			}
    		}
    	}
    }
}
