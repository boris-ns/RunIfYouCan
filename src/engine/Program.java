package engine;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;

import game.Game;

public class Program extends Canvas implements Runnable
{
	public static final int WIDTH = 640, HEIGHT = 480;
	
	private static final long serialVersionUID = 1L;	
	private boolean running = false;
	private Thread thread;
	
	private Game game;
	private Camera camera;
	
	public Program()
	{
		System.setProperty("sun.java2d.opengl", "true");
		game = new Game();
		camera = new Camera(0,0);
		new Window(WIDTH, HEIGHT, "Run If You Can", this);
		this.addKeyListener(new KeyInput(game));
	}
	
	public void tick()
	{
		game.tick();
		camera.tick(game.getHero());
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
        // zbog kamere, pozadinu mora crtati ovde
        g.setColor(Color.RED);
        g.fillRect(0, 0, Program.WIDTH, Program.HEIGHT);

        g2d.translate(camera.getX(), camera.getY());
		
		game.render(g);

        g2d.translate(-camera.getX(), -camera.getY());
		
		g2d.dispose();
		g.dispose();
		bs.show();
	}
	
	public synchronized void start()
	{
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		try 
		{
			thread.join();
			running = false;
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	@Override
	public void run() 
	{
		Toolkit.getDefaultToolkit().sync();
		requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				updates++;
				delta--;
			}
			if(running)
				render();
		
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public static void main(String[] args)
	{
		new Program();
	}
}
