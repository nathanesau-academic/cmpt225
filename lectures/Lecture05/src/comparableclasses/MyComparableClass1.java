package comparableclasses;

import java.util.Arrays;

/**
 * This program illustrates the Comparable interface
 *   
 * @author Igor
 *
 */
public class MyComparableClass1 implements Comparable<MyComparableClass1>{

	protected int ID;
	protected String name;
	
	public MyComparableClass1(int id, String n) {
		ID = id;
		name = n;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public int getID() {
		return ID;
	}
	
	@Override
	public int compareTo(MyComparableClass1 other) {
		if (this.ID > other.ID)
			return 1;
		else if (this.ID < other.ID)
			return -1;
		else // this.ID == other.ID
			return name.compareTo(other.name); 
	}
	
	@Override
	public String toString() {
		
		return this.name+this.ID;
	}
	
	public static void main(String[] args) {

		MyComparableClass1[] c = new MyComparableClass1[5];
		c[0] = new MyComparableClass1(0,"ABC");
		c[1] = new MyComparableClass1(1,"ABC");
		c[2] = new MyComparableClass1(2,"ABC");
		c[3] = new MyComparableClass1(1,"XYZ");
		c[4] = new MyComparableClass1(2,"ABC");

		if (c[1].compareTo(c[2]) > 0)
			System.out.printf("c[1] > c[2] \n");
		else if (c[1].compareTo(c[2]) < 0)
			System.out.printf("c[1] < c[2] \n");
		else
			System.out.printf("c[1] == c[2] \n");
	
		System.out.printf("Sorting the array:...\n");
		Arrays.sort(c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i].toString());
		}
		System.out.printf("\n");

	}
	
}
