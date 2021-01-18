package searchsort;

import java.util.ArrayList;
import java.util.Random;

import comparableclasses.MyComparableClass1;

/**
 * This program search for an element in a given array
 * 
 *   
 * @author Igor
 *
 */
public class SearchUnsorted {


	/**
	 * search for an element in the given array of integers
	 * 
	 * @param a - an array
	 * 
	 * @param element - an integer
	 * 
	 * @return
	 * 		the index in the array that contains the given element
	 * 		if element is not in the array, returns -1
	 */
	public static <E> int findElement(ArrayList<E> a, E element) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).equals(element))
				return i;
		}
		return -1;
	}

	
	public static <E> void printArray(ArrayList<E> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print("a[" + i + "]=" + a.get(i).toString() + " ");
		}
		System.out.println("");
	}

	
	public static ArrayList<MyComparableClass1> getRandomArray(int size) {
		ArrayList<MyComparableClass1> randArray = new ArrayList<MyComparableClass1>(size);

		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			randArray.add(new MyComparableClass1(rand.nextInt(10), "Str"));
		}
		return randArray;
	}
	
	

	public static void main(String[] args) {

		int size = 20;
		ArrayList<MyComparableClass1> a = getRandomArray(size);
		
		printArray(a);
	
		
		for (int j = 0; j < 10; j++) {
			MyComparableClass1 element = new MyComparableClass1(j, "Str");
			int ind = findElement(a, element);
			if (ind>-1)
				System.out.println("found " + element + ": a[" + ind + "] = " + element);
			else
				System.out.println("element " + element + " not found");
		}
	}
}
