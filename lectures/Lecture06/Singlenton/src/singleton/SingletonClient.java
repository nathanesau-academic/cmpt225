/**
 *
 *SingletonClient
 *   
 * @author Igor
 *
 */
public class SingletonClient {

	

	public static void main(String[] args) {
		
		Singleton s = Singleton.getInstance();

		Singleton s2 =  Singleton.getInstance();
		
		System.out.println("the objects are equal:" + (s == s2));
	}

}


