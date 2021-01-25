package builder;

import java.util.ArrayList;

import geomerticshapes.*;

/**
 *
 * Geometric Shape Builder Demo
 *   
 * @author Igor
 *
 */
public class BuilderDemo {

	public static void main(String[] args) {
		ArrayList<GeometricShape> list = new ArrayList<GeometricShape>();

		GeometricShapeBuilder builder = new GeometricShapeBuilder();
		GeometricShape geomShape = null;

		geomShape = builder.setShapeType("Circle")
				.setX(0)
				.setY(0)
				.setRadius(100)
				.createShape();
		list.add(geomShape);

		builder.setRadius(200);	// modify our previous specifications
		list.add(builder.createShape()); // add it to the list


		geomShape = builder.setShapeType("Square").setX(10)
				.setY(20)
				.setLength(50)
				.createShape();
		list.add(geomShape);


		geomShape = builder.setShapeType("Rectangle").setX(40)
				.setY(50)
				.setLength(50)
				.setWidth(100)
				.createShape();
		list.add(geomShape);


		System.out.println("--- Printing the list ---");
		list.stream()	
			.forEach(obj ->System.out.println(obj));


		System.out.println("\n--- Printing only the circles --- ");
		list.stream()
			.filter(obj -> obj instanceof Circle)	
			.forEach(obj ->System.out.println(obj));
	}

}


