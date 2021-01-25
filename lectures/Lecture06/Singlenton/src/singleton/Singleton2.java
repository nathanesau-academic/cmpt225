
/**
 * Singleton - lazy initialization
 *   
 * @author Igor
 *
 */
public class Singleton2 {

	int val;
	
	//
	private static Singleton2 theUniqueInstance = null;
	
	private Singleton2() {
		val = 10;
	}
	
	public void printVal()	{
		System.out.println("val = " + val);
	}
	
	public static Singleton2 getInstance()	{
		// not safe for multhitreading
		if (theUniqueInstance == null)
			theUniqueInstance = new Singleton2();
			
		return theUniqueInstance;
	}
}


