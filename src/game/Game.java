package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import engine.CollisionHandler;
import engine.map.MapGenerator;
import game.objects.Hero;
import game.objects.Wall;

/**
 * Created by zdravko on 4.11.16..
 */
public class Game {

    private LinkedList<GameObject> objects = new LinkedList<>();

    private ArrayList<ArrayList<GameObject>> map;

    private Hero hero;

    private CollisionHandler collisionHandler;

    public Game()
    {

        hero = new Hero(170, 100);
        objects.add(hero);

        collisionHandler = new CollisionHandler(this);

        //initMap(30, 30);
        map = MapGenerator.generateMap(objects);
    }

//    private void initMap(int verticalBlocks, int horisontalBlocks/*, file */)
//    {
//        map = new GameObject[horisontalBlocks][verticalBlocks];
//
//        for (int i = 0; i < horisontalBlocks; i++)
//        {
//            for (int j = 0; j < verticalBlocks; j++)
//            {
//            	if(i == j){
//            		map[i][j] = new Wall(j*Wall.width, i*Wall.height); // kopija mozda nece trebati ->
//            		objects.add(map[i][j]); // -> nego direkt dodavanje novog zida u objekte!?
//            	}else if(i % 2 == 0){
//            		objects.add(new Wall(j*Wall.width, i*Wall.height));
//            	}
//            }
//        }
//
//        // Za debagovanje getbounds i kolizije
//        objects.add(new Wall(5*Wall.width, 5*Wall.height));
//    }

    public void tick()
    {
        for (GameObject object : objects)
            object.tick();

        collisionHandler.tick(objects);
    }


    public void render(Graphics g) {
        for (GameObject object : objects) {
            object.render(g);
        }
    }


    public Hero getHero() {
        return hero;
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
