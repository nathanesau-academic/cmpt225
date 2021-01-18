package searchsort;

import java.util.ArrayList;
import java.util.Random;

import comparableclasses.MyComparableClass1;


/**
 * This program search for an element in a sorted array using BinarySearch
 * 
 *   
 * @author Igor
 *
 */
public class SearchSorted {


	/**
	 * search for an element in the given array of integers
	 * Prerequisite: the array is sorted in the increasing order 
	 * 
	 * @param a - an array
	 * 
	 * @param element - an integer
	 * 
	 * @return
	 * 		the index in the array that contains the given element
s	 * 		if element is not in the array, returns -1
	 */
	public static <E extends Comparable<E>>  int findElement(ArrayList<E> a, E element) {
		int left = 0;
		int right = a.size()-1;
		int mid = (left+right)/2;
		
		while(!(a.get(mid)).equals(element) && left < right)
		{
			if ((a.get(mid)).compareTo(element) > 0)
				right = mid-1;
			else // a[mid] < element
				left = mid+1;				
			
			mid = (left+right)/2;
		}
		
		if ((a.get(mid)).equals(element))
			return mid;
		else
			return -1;
	}

	
	public static <E> void printArray(ArrayList<E> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print("a[" + i + "]=" + a.get(i).toString() + " ");
		}
		System.out.println("");
	}

	
	public static ArrayList<MyComparableClass1> getRandomArray(int size)
	{
		ArrayList<MyComparableClass1> randArray = new ArrayList<MyComparableClass1>(size);

		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			randArray.add(new MyComparableClass1(rand.nextInt(10), "Str"));
		}
		return randArray;
	}
	
	
	
		
	public static void main(String[] args)
	{
		int size = 50;
		ArrayList<MyComparableClass1> a = getRandomArray(size);

		System.out.println("Orig a:");
		printArray(a);
	
		MergeSort.mergeSort(a);

		System.out.println("Sorted a:");
		printArray(a);
	
		MyComparableClass1 element = new MyComparableClass1((new Random()).nextInt(1000),"Str");

		System.out.println(element);
		int ind = findElement(a, element);
		if (ind>-1)
			System.out.println("found " + element + " at index " + ind);
		else
			System.out.println("element " + element + " not found");
	}

}
//