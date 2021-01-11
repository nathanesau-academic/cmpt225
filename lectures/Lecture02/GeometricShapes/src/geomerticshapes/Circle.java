package geomerticshapes;

public class Circle extends GeometricShape{

	protected int radius;
	
	public Circle(int initX, int initY, int initR) {
		super(initX, initY);
		radius= initR;
	}
	
	public void setRadius(int newR)
	{
		radius = newR;
	}

	public void draw()
	{
		// drawing implementation...
	}

// 	Let's see what happens if we don't implement this
//	@Override
//	public String toString() {
//		return "Circle: center=(" + x + "," + y +"), radius = " + radius;
//	}

}


