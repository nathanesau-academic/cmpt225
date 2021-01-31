package assignment2;

import mystack.MyStack;

/**
 * Additional operations on MyStack
 * 
 * @author Igor
 *
 */

public class MyStackOperations<T>{

	/**
	 * returns the number of elements in s.
	 * 
	 * @param <T> type of stack.
	 * @param s stack (should not be modified by function).
	 * @return the size of the stack.
	 */
	public static <T> int size(MyStack<T> s) {

		if (s == null) {
			throw new java.util.NoSuchElementException("Cannot operate on null stack");
		}

		// We don't want to modify the original stack
		// Therefore, we must clone the original stack
		// and perform operations on the cloned stack
		var clonedS = cloneStack(s);

		int length = 0;
		while (!clonedS.isEmpty()) {
			clonedS.pop();
			length += 1;
		}

		return length;
	}

	/**
	 * returns a copy of s.
	 * 
	 * @param <T> type of stack.
	 * @param s stack (should not be modified by function).
	 * @return the size of the stack.
	 */
	public static <T> MyStack<T> cloneStack(MyStack<T> s) {
		
		if (s == null) {
			throw new java.util.NoSuchElementException("Cannot operate on null stack");
		}

		// We don't want to modify the original stack
		// Therefore, we must add back elements we remove from original stack

		var clonedS = new MyStack<T>();

		class Node {

			T element;
			Node next;			
		
			Node(T element) {
				this.element = element;
			}
	
		}

		Node bottom = null;

		while (!s.isEmpty()) {
			Node node = new Node(s.pop());

			if (bottom == null) {
				bottom = node;
			}
			else {
				node.next = bottom;
				bottom = node;
			}
		}

		Node node = bottom;

		while (node != null) {
			// add back the element we removed from s
			s.push(node.element);

			// push element to clonedS
			clonedS.push(node.element);	

			node = node.next;
		}

		return clonedS;
	}

	/**
	 * reverses the order of the elements in s.
	 * 
	 * @param <T> type of stack.
	 * @param s stack (should be modified by function).
	 */
	public static <T> void reverse(MyStack<T> s) {
		
		if (s == null) {
			throw new java.util.NoSuchElementException("Cannot operate on null stack");
		}

		// Here, we do want to modify the original stack
		// First loop: remove and store all stack elements
		// Second loop: add back stack elements in reversed order

		class Node {

			T element;
			Node prev;			
		
			Node(T element) {
				this.element = element;
			}
	
		}

		Node top = null;
		Node bottom = null;

		while (!s.isEmpty()) {
			Node node = new Node(s.pop());

			if (top == null) {
				top = node;
				bottom = node;
			}
			else {
				bottom.prev = node;
				bottom = node;
			}
		}

		Node node = top;

		while (node != null) {
			s.push(node.element);
			node = node.prev;
		}
	}

	public static void main(String[] args) {
		System.out.println("cloning");
		cloneStack(null);
	}
}


	