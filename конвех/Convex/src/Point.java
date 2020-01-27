import java.awt.Graphics;

class Point implements Figure {
	private R2Point p;
	
	public Point(R2Point p) {
		this.p = p;
	}
	public double perimeter() {
		return 0.0;
	}
	public double area() {
		return 0.0;
	}
	public Figure add(R2Point q) {
		if (!R2Point.equal(p,q)) return new Segment(p, q);
		else return this;
	}
	public void draw(Graphics g) {
		g.fillOval((int)(p.x - 5), (int)(-p.y - 5), 10, 10);
	}
}

