package game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.GameObject;
import game.ObjectType;

public class Bullet extends GameObject {
	
	public static final int SIZE = 10;
	
	private static final int BULLET_SPEED = 10;
	
	public Bullet(float x, float y, float lastHeroVelX) {
		this(x, y, 0.0f, 0.0f);
		
		// TODO vidi zasto nece da radi ako se stavi > 0
		if (lastHeroVelX >= 0)
			this.velX = BULLET_SPEED;
		else
			this.velX = -BULLET_SPEED;
	}
	
	public Bullet(float x, float y, float velX, float velY) {
		super(x, y, velX, velY, ObjectType.Bullet);
	}
	
	

	@Override
	public void tick() {
		x += velX;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, SIZE, SIZE);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, SIZE, SIZE);
	}

	/*
	 * It's not necessary to define other getBounds methods, because Bullet objects is too small
	 * @see game.GameObject#getTopBounds()
	 */
	@Override
	public Rectangle getTopBounds() {
		return getBounds();
	}

	@Override
	public Rectangle getBottomBounds() {
		return getBounds();
	}

	@Override
	public Rectangle getLeftBounds() {
		return getBounds();
	}

	@Override
	public Rectangle getRightBounds() {
		return getBounds();
	}

}
