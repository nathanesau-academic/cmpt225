package geomerticshapes;

public class Square extends Rectangle {

	public Square(int initX, int initY, int initL) {
		super(initX, initY, initL, initL);
	}
	
	public void setLength(int newL)
	{
		super.setLength(newL);
		setWidth(newL);
	}

	public void draw()
	{
		// drawing implementation...
	}

	@Override
	public String toString() {
		return "Square: top-left=(" + x + "," + y +"), length = " + length;
	}


}


