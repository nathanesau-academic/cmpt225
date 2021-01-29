package mylinkedlists;

import myclasses.GroceryItem;

/**
 * Testing Linked Lits
 *   
 * @author Igor
 *
 */

public class TestLinkedList{
	public static void main(String[] args) {
		MyLinkedList<GroceryItem> groceryList = new MyLinkedList<GroceryItem>();
		groceryList.addToHead(new GroceryItem("Milk", 3, 4.32));
		groceryList.addToHead(new GroceryItem("Yogurt", 2, 1.17));
		groceryList.addToHead(new GroceryItem("Cheese", 3, 10.99));
		groceryList.addToHead(new GroceryItem("Pringles", 2, 2.99));
		
		System.out.println(groceryList);

		MyLinkedList<String> strings = new MyLinkedList<String>();
		strings.addToHead("ABC");
		strings.addToHead("XYZ");
		strings.addToHead("BC");
		strings.addToHead("FGC");
		strings.addToHead("ABC");
		strings.addToHead("ABC");
		strings.addToHead("123");
		strings.addToHead("456");
		strings.addToHead("ABC");
		strings.addToHead("ABC");
		strings.addToTail("000");
		strings.addToTail("111");
		strings.addToTail("222");
		
		System.out.println(strings);
		
		System.out.println("removeAllOccurences(\"ABC\");");
		strings.removeAllOccurences("ABC");
		System.out.println(strings);

		System.out.println("remove head and tail");
		System.out.println(strings);

		
		strings.set(3, "NEW-ELT");

		System.out.println("strings[0] = " +strings.get(0));
		System.out.println("strings[3] = " +strings.get(3));
	}
}