package assignment2;

/**
 * Implementation of circular linked list
 * 
 * @author Igor
 *
 */

public class CircularLinkedList<T> {

	class Node {

		T element;
		Node next; // clockwise
		Node prev; // counter-clockwise

		Node(T element) {
			this.element = element;
		}
	}

	Node current;

	/**
	 * Creates an empty circular linked list.
	 */
	public CircularLinkedList() {
		this.current = null;
	}

	/**
	 * Creates a circular linked list with initial initSize elements, all with the
	 * value initValue.
	 * 
	 * @param initSize initial size.
	 * @param initValue initial value.
	 */
	public CircularLinkedList(int initSize, T initValue) {
		current = new Node(initValue);
		var first = this.current;
		for (int i = 1; i < initSize; i++) {
			// set next for current node
			// set prev for new node
			Node node = new Node(initValue);
			current.next = node;
			node.prev = this.current;
			current = node;
		}

		if (initSize > 1) {
			// current node doesn't have next
			// set it to first
			current.next = first;

			// first node doesn't have prev
			// set it to current
			first.prev = current;
		}

	}

	/**
	 * If the list has one node, it has no effect.
	 * If the list is empty, throws java.util.NoSuchElementException.
	 */
	public void moveForward() {
		if (current == null) {
			throw new java.util.NoSuchElementException("Attempted to moveForward when list is empty");
		}

		if (current.next == null) {
			return;
		}

		current = current.next;
	}

	/**
	 * If the list has one node, it has no effect.
	 * If the list is empty, throws java.util.NoSuchElementException.
	 */
	public void moveBackward() {
		if (current == null) {
			throw new java.util.NoSuchElementException("Attempted to moveBackward when list is empty");
		}

		if (current.prev == null) {
			return;
		}

		current = current.prev;
	}

	/**
	 * Returns the value in the node under the pointer.
	 * If the list is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return The value in the node under the pointer.
	 */
	public T getValue() {
		if (current == null) {
			throw new java.util.NoSuchElementException("Attempted to getValue when list is empty");
		}

		return current.element;
	}

	/**
	 * Sets the value in the node under the pointer.
	 * Returns the previous value in the node under the pointer.
	 * If the list is empty, throws java.util.NoSuchElementException.
	 * 
	 * @param element new element value.
	 * @return the previous value of the node.
	 */
	public T setValue(T element) {
		if (current == null) {
			throw new java.util.NoSuchElementException("Attempted to setValue when list is empty");
		}

		T data = current.element;
		current.element = element;
		return data;
	}

	/**
	 * Adds a node with the given value before the pointer.
	 * If the list was empty, the pointer is set to point to the new element.
	 * 
	 * @param element The element to the add to the list.
	 */
	public void addBefore(T element) {
		if (current == null) {
			this.current = new Node(element);			
		}
		else {
			Node node = new Node(element);
			node.next = current;
			node.prev = (current.prev != null) ? current.prev : current;
			node.prev.next = node;
			current.prev = node;
			// NOTE: do not modify current
		}
	}

	/**
	 * Adds a node wit hthe given value after the pointer.
	 * If the list was empty, the pointer is set to point to the new element.
	 * 
	 * @param element The element to add to the list.
	 */
	public void addAfter(T element) {
		if (current == null) {
			this.current = new Node(element);
		}
		else {
			Node node = new Node(element);
			node.prev = current;
			node.next = (current.next != null) ? current.next : current;
			node.next.prev = node;
			current.next = node;
			// NOTE: do not modify current
		}
	}

	/**
	 * Removes the node right before the pointer.
	 * Returns the element previously in the removed node.
	 * If the list is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return the previous value of the removed node.
	 */
	public T removeBefore() {
		if (current == null) {
			throw new java.util.NoSuchElementException("Attempted to removeBefore when list is empty");
		}

		if (current.prev == null) { // since there is no node before, remove current
			T data = current.element;
			current = null;
			return data;
		}

		T data = current.prev.element;
		current.prev = current.prev.prev;

		if (current.prev != null) {
			// update both directions of link
			current.prev.next = current;
		}
		
		// special case: only one element left (no loop)
		if (current.next == current || current.prev == current) {
			current.next = null;
			current.prev = null;
		}

		return data;
	}

	/**
	 * Removes the node right after the pointer.
	 * Returns the element previously in the removed node.
	 * If the list is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return the previous value of the removed node.
	 */
	public T removeAfter() {
		if (current == null) {
			throw new java.util.NoSuchElementException("Attempted to removeAfter when list is empty");
		}
	
		if (current.next == null) { // since there is no node after, remove current
			T data = current.element;
			current = null;
			return data;
		}

		T data = current.next.element;
		current.next = current.next.next;

		if (current.next != null) {
			// update both directions of link
			current.next.prev = current;
		}

		// special case: only one element left (no loop)
		if (current.next == current || current.prev == current) {
			current.next = null;
			current.prev = null;
		}

		return data;
	}

	/**
	 * Checks if the list is empty.
	 * 
	 * @return True if list is empty, False otherwise.
	 */
	public boolean isEmpty() {
		return current == null;
	}

}
