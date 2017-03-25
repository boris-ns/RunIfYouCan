package engine;

import game.Game;
import game.GameObject;
import game.ObjectType;
import game.objects.Hero;
import game.objects.Wall;

import java.util.LinkedList;

/**
 * Created by boris on 11/6/16.
 */
public class CollisionHandler {
	
    private Game game;
    private Hero hero;
    private Wall wall;

    public CollisionHandler(Game game) {
        this.game = game;
        this.hero = game.getHero();
    }

    public void tick(LinkedList<GameObject> objects) {
    	collisionHeroWall(findWallObjects(objects));
    }

    private void collisionHeroWall(LinkedList<GameObject> walls) {
        for (int i = 0; i < walls.size(); ++i) {
            wall = (Wall) walls.get(i);

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
    
    private LinkedList<GameObject> findWallObjects(LinkedList<GameObject> objects) {
    	LinkedList<GameObject> walls = new LinkedList<GameObject>();
    	for (int i = 0; i < objects.size(); ++i) {
    		if (objects.get(i).getObjectType() == ObjectType.Wall)
    			walls.add(objects.get(i));
    	}
    	
    	return walls;
    }
    
    private Hero findHeroInList(LinkedList<GameObject> objects) {
        for (int i = 0; i < objects.size(); ++i)
            if(objects.get(i).getObjectType() == ObjectType.Hero)
                return (Hero) objects.get(i);

        return null;
    }
}
