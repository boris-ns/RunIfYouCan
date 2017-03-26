package game;

import java.awt.Graphics;
import java.util.LinkedList;

import engine.CollisionHandler;
import engine.map.MapGenerator;
import game.objects.Hero;
import game.objects.lists.BulletList;
import game.objects.lists.WallList;

public class Game {

    private LinkedList<GameObject> objects = new LinkedList<>();

    private Hero hero;

    private CollisionHandler collisionHandler;
    private BulletList bulletList;
    private WallList wallList;

    public Game()
    {  	
    	wallList = new WallList();
    	bulletList = new BulletList();

    	MapGenerator.generateMap(this);
        hero = findHero();
        if (hero == null) {
        	System.out.println("Hero isn't initialized. The game will stop...");
        	System.exit(-1);
        }
        
        collisionHandler = new CollisionHandler(this);
    }

    public void tick()
    {
        for (int i = 0; i < objects.size(); ++i)
        	objects.get(i).tick();

        bulletList.tick();
        collisionHandler.tick(objects);
    }


    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); ++i) {
        	objects.get(i).render(g);
        }
        
        bulletList.render(g);
        wallList.render(g);
    }
    
    public BulletList getBulletList() {
    	return bulletList;
    }
    
    public WallList getWallList() {
    	return wallList;
    }

    public LinkedList<GameObject> getObjects() {
    	return objects;
    }

    public Hero getHero() {
        return hero;
    }
    
    public void setHero(Hero hero) {
    	this.hero = hero;
    }
    
    private Hero findHero() {
    	for (int i = 0; i < objects.size(); ++i) {
    		if (objects.get(i).getObjectType() == ObjectType.Hero) {
    			return (Hero) objects.get(i);
    		}
    	}
    	
    	return null;
    }
    /*public void addGameObject(GameObject gameObject)
    {
        objects.add(gameObject);
    }*/


    /*public void removeGameObject(GameObject gameObject)
    {
        objects.remove(gameObject);
    }*/
}
