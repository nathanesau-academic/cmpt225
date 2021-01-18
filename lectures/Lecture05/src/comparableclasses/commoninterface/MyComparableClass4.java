package comparableclasses.commoninterface;

import java.util.Arrays;

/**
 * This program illustrates the Comparable interface
 *   
 * @author Igor
 *
 */
public class MyComparableClass4  implements MyInterface,  Comparable<MyInterface> {

	protected int number;
	protected String str;
	
	public MyComparableClass4(int num, String s) {
		number = num;
		str = s;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}
	
	public String toString() {
		
		return this.number + " " + this.str;
	}
	
	@Override

	public int compareTo(MyInterface other) {
		if (this.number > other.getNumber())
			return 1;
		else if (this.number < other.getNumber())
			return -1;
		else // this.ID == other.ID
			return str.compareTo(other.getStr()); 
	}
	
	public static void main(String[] args) {

		MyComparableClass4[] c = new MyComparableClass4[5];
		c[0] = new MyComparableClass4(0,"ABC");
		c[1] = new MyComparableClass4(1,"ABC");
		c[2] = new MyComparableClass4(2,"EFG");
		c[3] = new MyComparableClass4(4,"ABC");
		c[4] = new MyComparableClass4(2,"EFG");

		MyInterface inc1 = new IncomparableClass4(1, "QRS");
		IncomparableClass4 inc2 = new IncomparableClass4(3, "ABC");

		if (c[1].compareTo(inc1) > 0)
			System.out.printf("c[1] > inc1 \n");
		else if (c[1].compareTo(inc1) < 0)
			System.out.printf("c[1] < inc1 \n");
		else
			System.out.printf("c[1] == inc1 \n");
		

		if (c[2].compareTo(inc2) > 0)
			System.out.printf("c[2] > inc2 \n");
		else if (c[2].compareTo(inc2) < 0)
			System.out.printf("c[2] < inc2 \n");
		else
			System.out.printf("c[2] == inc2 \n");

//		on the other hand:		
//		inc1.compareTo(c[0]) //Will not compile
//		inc2.compareTo(c[0]) //Will not compile
		
		//*********************************************//
		System.out.printf("Sorting the array:...\n");
		Arrays.sort(c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i].toString());
		}
		System.out.printf("\n");
	
	}
	
}
