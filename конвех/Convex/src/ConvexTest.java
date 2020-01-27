import java.awt.Color;

public class ConvexTest {
	public static void main(String[] args) throws Exception {
		Convex convex = new Convex();
		MyFrame Frame = new MyFrame(convex);
		Frame.setBackground(Color.white);
		while (true) {
			convex.add(new R2Point());
			System.out.println("S = " + convex.area() + " , P = " + convex.perimeter());
			Frame.repaint();
		}
		//Frame.repaint();
		
		}
}
