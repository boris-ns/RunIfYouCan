package game.objects.lists;

import java.awt.Graphics;
import java.util.LinkedList;
import game.objects.Wall;

public class WallList {

	private LinkedList<Wall> wallList;
	
	public WallList() {
		wallList = new LinkedList<Wall>();
	}
	
	
	public void render(Graphics g) {
		for (int i = 0; i < wallList.size(); ++i) {
			wallList.get(i).render(g);
		}
	}
	
	public LinkedList<Wall> getWallLinkedList() {
		return wallList;
	}
	
	public void addWallBlock(Wall wallBlock) {
		wallList.add(wallBlock);
	}
	
	public boolean removeWallBlock(Wall wallBlock) {
		return wallList.remove(wallBlock);
	}
}
