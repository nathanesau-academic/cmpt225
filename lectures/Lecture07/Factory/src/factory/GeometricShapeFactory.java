package factory;

import geomerticshapes.*;

/**
 *
 * GeometricShapeFactory
 *   
 * @author Igor
 *
 */
public class GeometricShapeFactory {

	public GeometricShape createShape(String shapeType){
		if(shapeType == null){
			return null;
		}		
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle(0,0,10); // radius 10 centered at the origin

		} else    if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle(0,0,10,20); // create rectangle with some default values

		} else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square(0,0,10); // create a square with some default values
		}

		return null;
	}



}


