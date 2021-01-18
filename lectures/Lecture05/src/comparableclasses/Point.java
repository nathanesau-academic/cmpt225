package comparableclasses;


/**
 *   
 * @author Igor
 *
 */
public class Point implements Comparable<Point>{

	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	@Override
	/**
	 * compares the points according to the distance to the origin
	 */
	public int compareTo(Point o) {
		int squareRadius = x*x+y*y;
		int otherSquareRadius = o.x*o.x + o.y*o.y;
		
		return  otherSquareRadius-squareRadius;
	}

	@Override
	public boolean equals(Object obj) {
		if (this==obj)
			return true;
		if (obj==null)
			return false;
		if (!(obj instanceof Point))
			return false;

		Point other = (Point) obj;
		if ((this.x == other.x) && (this.y == other.y))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public static void main(String[] args) {
		Point p1 = new Point(1,4);
		Point p2 = new Point(0,2);
		if (p1.compareTo(p2) > 0)
			System.out.println("dist(" + p1 + ",origin) < dist(" + p2 + ",origin)");
		else if  (p1.compareTo(p2) < 0)
			System.out.println("dist(" + p1 + ",origin) > dist(" + p2 + ",origin)");
		else
			System.out.println("dist(" + p1 + ",origin) < dist(" + p2 + ",origin)");
		
		Point p3 = new Point(0,2);
		System.out.println("-------------");
		if (p2 == p3)
			System.out.println("p2 and p3 are the same point");
		else
			System.out.println("p2 and p3 are different points");

		System.out.println("-------------");
		if (p2.equals(p3))
			System.out.println("p2.equals(p3) = true");
		else
			System.out.println("p2.equals(p3) = false");
	}
}

