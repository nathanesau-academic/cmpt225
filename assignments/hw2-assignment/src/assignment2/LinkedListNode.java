package assignment2;

/**
 * Implementation of linked list
 *   
 * @author Igor
 *
 */

public class LinkedListNode<T> {

	private T data;
	private LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public LinkedListNode(T data, LinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public LinkedListNode<T> getNext() {
		return next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
	public int countReachableNodes( ) {
		// TODO implement me
		return 0;
	}

}

