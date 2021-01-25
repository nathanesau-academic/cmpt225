package builder;

import java.util.Iterator;
import java.util.LinkedList;

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
		LinkedList<GeometricShape> list = new LinkedList<GeometricShape>();

		GeometricShapeBuilder builder = new GeometricShapeBuilder();
		GeometricShape geomShape = null;

		geomShape = builder.setShapeType("Circle")
										.setX(0)
										.setY(0)
										.setRadius(100)
										.createShape();
		list.add(geomShape);

		
		geomShape = builder.setShapeType("Square").setX(10)
												.setY(20)
												.setLength(50)
												.createShape();
		list.add(geomShape);

		Iterator<GeometricShape> iterator = null;
		for (iterator = list.iterator(); iterator.hasNext();)
			System.out.println(iterator.next());
			
	}
	
}


