import java.awt.Graphics;

public class Convex {
	private Figure fig;
	private int Count = 0;
	
	public Convex() {
		fig = new Void();
	}
	
	public void add(R2Point p) {
		fig = fig.add(p);
		Count += 1;
		System.out.println("Точка номер " + Count + ".");
	}
	
	public double area() {
		return fig.area();
	}
	
	public double perimeter() {
		return fig.perimeter();
	}
	public void draw (Graphics g) {
		fig.draw(g);
	}
	
}
