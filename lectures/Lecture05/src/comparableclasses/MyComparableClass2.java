package comparableclasses;


/**
 * This program illustrates the Comparable interface
 *   
 * @author Igor
 *
 */
public class MyComparableClass2  implements Comparable<MyComparableClass1>{

	protected int number;
	protected String str;
	
	public MyComparableClass2(int id, String n) {
		number = id;
		str = n;
	}

	public void setName(String name) {
		this.str = name;
	}
	public String getName() {
		return str;
	}

	public void setID(int iD) {
		number = iD;
	}
	
	public int getID() {
		return number;
	}
	
	@Override
	public int compareTo(MyComparableClass1 other) {
		if (this.number > other.ID)
			return 1;
		else if (this.number < other.ID)
			return -1;
		else // this.ID == other.ID
			return str.compareTo(other.name); 
	}
	
	@Override
	public String toString() {
		
		return this.number + " " + this.str;
	}
	public static void main(String[] args) {

		MyComparableClass2 c = new MyComparableClass2(2,"ABC");

	
		MyComparableClass1 other = new MyComparableClass1(1, "RST");
		if (c.compareTo(other) > 0)
			System.out.printf("c > other \n");
		else if (c.compareTo(other) < 0)
			System.out.printf("c < other \n");
		else
			System.out.printf("c == other \n");
		
//		if (c.compareTo(c) > 0) 			 // Does not compile
//			System.out.printf("c > c \n");
		
	}
	
}
