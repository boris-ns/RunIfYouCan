package game.objects.lists;

import java.awt.Graphics;
import java.util.LinkedList;

import game.objects.Bullet;

public class BulletList {
	
	private LinkedList<Bullet> bullets;
	
	public BulletList() {
		bullets = new LinkedList<Bullet>();
	}
	
	public void tick() {
		for (int i = 0; i < bullets.size(); ++i) {
			bullets.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < bullets.size(); ++i) {
			bullets.get(i).render(g);
		}
	}

	public LinkedList<Bullet> getBulletLinkedList() {
		return bullets;
	}
	
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}
	
	public boolean removeBullet(Bullet bullet) {
		return bullets.remove(bullet);
	}
}
