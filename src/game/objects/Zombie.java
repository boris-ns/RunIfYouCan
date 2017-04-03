package game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.GameObject;
import game.ObjectType;

public class Zombie extends GameObject {
	
	public static final int SIZE = 32;

	private Zombie(float x, float y, float velX, float velY, ObjectType objectType) {
		super(x, y, velX, velY, objectType);
	}

	public Zombie(float x, float y) {
		this(x, y, 1.0f, 1.0f, ObjectType.Zombie);
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) x, (int) y, SIZE, SIZE);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, SIZE, SIZE);
	}

	// getBounds top,right,left,bottom vracaju full getBounds
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
