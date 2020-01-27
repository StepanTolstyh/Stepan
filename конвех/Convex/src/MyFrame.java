import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	protected static int width = 600;
	protected static int height = 600;
	private Convex n;
	
	public MyFrame(Convex n) {
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Convex");
		this.setVisible(true);
		this.n = n;
	}
	
	public void paint(Graphics g) {
		Rectangle s = this.getBounds();
		width = s.width;
		height = s.height;
		
		g.translate(width / 2, height / 2);
		g.setColor(Color.black);
		g.clearRect( - s.width / 2, - s.height / 2, s.width, s.height);
		g.drawLine(-width / 2, 0, width / 2, 0);
		g.drawLine(0, height / 2, 0, -height / 2);
		double x, y, r;
		do {
			x = Math.random();
			y = Math.random();
		}
		while (x * x + y * y > 1);
		r = Math.sqrt(x * x + y * y);
		
		
		g.drawOval((int)-r, (int)-r, (int)r * 2, (int)r * 2);
		n.draw(g);
	
	}
}
	

