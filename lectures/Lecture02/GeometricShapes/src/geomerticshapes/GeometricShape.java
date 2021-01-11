package geomerticshapes;

public abstract class GeometricShape {

	protected int x, y;
	
	public GeometricShape() {
		x  = 0 ;
		y = 0;
	}
	
	public GeometricShape(int initX, int initY) {
		x = initX;
		y = initY;
	}
	
	
	public void moveTo(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public abstract void draw();

}




