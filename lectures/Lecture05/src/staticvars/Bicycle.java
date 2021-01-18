package staticvars;

import java.awt.Color;

/**
 * @author Igor
 *
 */
public class Bicycle {
    
	// data fields
	protected int gear;
	protected int speed;
    protected Color color;

    private static int createdBicycles = 0;
     
    public Bicycle(Color c, int y, int s){ 
        color = c;
        gear = y;
        speed = s;

        createdBicycles++;
    }
     
    public static int getNumberOfCreatedBicycles()    {
    	return createdBicycles;
    }
    

}
