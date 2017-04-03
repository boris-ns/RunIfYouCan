package game.objects.lists;

import java.awt.Graphics;
import java.util.LinkedList;
import game.objects.Zombie;

public class ZombieList {

	private LinkedList<Zombie> zombieList;
	
	public ZombieList() {
		zombieList = new LinkedList<Zombie>();
	}
	
	public void tick() {
		for (int i = 0; i < zombieList.size(); ++i) {
			zombieList.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < zombieList.size(); ++i) {
			zombieList.get(i).render(g);
		}
	}
	
	public LinkedList<Zombie> getZombieLinkedList() {
		return zombieList;
	}
	
	public void addZombie(Zombie zombie) {
		zombieList.add(zombie);
	}
	
	public boolean removeZombie(Zombie zombie) {
		return zombieList.remove(zombie);
	}
}
