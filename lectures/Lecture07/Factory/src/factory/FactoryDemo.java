package factory;

import java.util.Iterator;
import java.util.LinkedList;

import geomerticshapes.*;

/**
 *
 * Geometric Shape Factory Demo
 *   
 * @author Igor
 *
 */
public class FactoryDemo {

	public static void main(String[] args) {
		GeometricShapeFactory factory = new GeometricShapeFactory();
		
		LinkedList<GeometricShape> list = new LinkedList<GeometricShape>();
		list.add(factory.createShape("circle"));
		list.add(factory.createShape("square"));
		list.add(factory.createShape("rectangle"));
		
		Iterator<GeometricShape> iterator = null;
		for (iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
			
		}
	}
	
}


