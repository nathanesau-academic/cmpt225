package comparableclasses;


/**
 * This program illustrates the Comparable interface
 *   
 * @author Igor
 *
 */
public class IncomparableClass3{

	protected int number;
	protected String str;
	
	public IncomparableClass3(int num, String s) {
		number = num;
		str = s;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
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
	
}
