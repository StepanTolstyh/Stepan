import java.awt.Graphics;

class Polygon extends Deq implements Figure {
	private double s, p;
	
	private void grow(R2Point a, R2Point b, R2Point t) {
		p -= R2Point.dist(a, b);
		s += Math.abs(R2Point.area(a, b, t));
	}
	public Polygon(R2Point a, R2Point b, R2Point c) {
		pushFront(b);
		
		if (b.light(a, c)) {
			pushFront(a); pushBack(c);
		} else {
			pushFront(c); pushBack(a);
		}
		p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
		s = Math.abs(R2Point.area(a, b, c));
	}
	public double perimeter() {
		return p;
	}
	public double area() {
		return s;
	}
	public Figure add(R2Point t) {
		int i;
		// ���� ���������� �����, ������������ �� ���� �� ������.
		for (i=length(); i>0 && !t.light(back(),front()); i--)
		pushBack(popFront());
		// �����������: ���� ����� [back(),front()] �������� �� t,
		// ���� ���������� ����� ��� ������.
		if (i>0) {
		R2Point x;
		grow(back(), front(), t);
		
		// ������� ��� ���������� ����� �� ������ ����.
		for (x = popFront(); t.light(x, front()); x = popFront())
		grow(x, front(), t );
		pushFront(x);
		// ������� ��� ���������� ����� �� ����� ����.
		for (x = popBack(); t.light(back(), x); x = popBack())
		grow(back(), x, t);
		pushBack(x);
		// ��������� ��������� ����������� �����.
		p += R2Point.dist(back(), t) + R2Point.dist(t, front());
		pushFront(t);
		}
		if (i <= 0) System.out.println("����� �� ������ � ��������� ������ �������� ��������.");
		return this;
	}
	
	public void draw(Graphics g) {
		for(int i = length(); i > 0; i--) {
			g.fillOval((int)(front().x - 5), (int)(-front().y -5), 10, 10);
			g.drawLine((int)front().x, (int)-front().y, (int)back().x, (int)-back().y);
			pushFront(popBack());
		}
		
	}
}