import java.util.Random;

/**
 *   
 * @author Igor
 *
 */
public class Singleton {

	int val;
	// other data fields
	
	// the unique instance
	private static Singleton theUniqueInstance = new Singleton();
	
	private Singleton()	{
		//init
		val = new Random().nextInt(100);
	}
	
	public static Singleton getInstance()	{
		return theUniqueInstance;
	}

	public void printVal()
	{
		System.out.println("val = " + val);
	}
	
}


