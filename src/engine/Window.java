package engine;

import java.awt.Dimension;
import javax.swing.JFrame;

// Klasa koja kreira prozor
public class Window extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title, Program program)
	{
		Dimension size = new Dimension(width, height);
		
		this.setTitle(title);
		this.setMaximumSize(size);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.pack();
		this.add(program);
		this.setVisible(true);
		
		program.start();
	}
}