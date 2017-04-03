package game;

import java.awt.Graphics;

import engine.CollisionHandler;
import engine.map.MapGenerator;
import game.objects.Hero;
import game.objects.lists.BulletList;
import game.objects.lists.WallList;
import game.objects.lists.ZombieList;

public class Game {

    private Hero hero;

    private CollisionHandler collisionHandler;
    private BulletList bulletList;
    private ZombieList zombieList;
    private WallList wallList;

    public Game()
    {  	
    	wallList = new WallList();
    	zombieList = new ZombieList();
    	bulletList = new BulletList();

    	MapGenerator.generateMap(this);

        if (hero == null) {
        	System.out.println("Hero isn't initialized. The game will stop...");
        	System.exit(-1);
        }
        
        collisionHandler = new CollisionHandler(this);
    }

    public void tick()
    {
    	hero.tick();
    	zombieList.tick();
        bulletList.tick();
        collisionHandler.tick();
    }


    public void render(Graphics g) {
        hero.render(g);
        zombieList.render(g);
        bulletList.render(g);
        wallList.render(g);
    }
    
    public BulletList getBulletList() {
    	return bulletList;
    }
    
    public WallList getWallList() {
    	return wallList;
    }

    public ZombieList getZombieList() {
    	return zombieList;
    }

    public Hero getHero() {
        return hero;
    }
    
    public void setHero(Hero hero) {
    	this.hero = hero;
    }
    
/*    private Hero findHero() {
    	for (int i = 0; i < objects.size(); ++i) {
    		if (objects.get(i).getObjectType() == ObjectType.Hero) {
    			return (Hero) objects.get(i);
    		}
    	}
    	
    	return null;
    }*/
    /*public void addGameObject(GameObject gameObject)
    {
        objects.add(gameObject);
    }*/


    /*public void removeGameObject(GameObject gameObject)
    {
        objects.remove(gameObject);
    }*/
}
