package comparableclasses;

/**
 * This program illustrates the Comparable interface
 *   
 * @author Igor
 *
 */
public class MyComparableClass3  implements  Comparable<IncomparableClass3>{

	protected int number;
	protected String str;
	
	public MyComparableClass3(int id, String n) {
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
	public int compareTo(IncomparableClass3 other) {
		if (this.number > other.getNumber())
			return 1;
		else if (this.number < other.getNumber())
			return -1;
		else // this.ID == other.ID
			return str.compareTo(other.getStr()); 
	}
	
	@Override
	public String toString() {
		
		return this.number + " " + this.str;
	}

	public static void main(String[] args) {

		MyComparableClass3[] c = new MyComparableClass3[5];
		c[0] = new MyComparableClass3(1,"ABC");
		c[1] = new MyComparableClass3(2,"ABC");
		c[2] = new MyComparableClass3(3,"ABC");
		c[3] = new MyComparableClass3(4,"ABC");
		c[4] = new MyComparableClass3(2,"XYZ");

		IncomparableClass3 i1 = new IncomparableClass3(10, "QRS");

		if (c[1].compareTo(i1) > 0)
			System.out.printf("c[1] > i1 \n");
		else if (c[1].compareTo(i1) < 0)
			System.out.printf("c[1] < i1 \n");
		else
			System.out.printf("c[1] == c[2] \n");
	}
	
}
