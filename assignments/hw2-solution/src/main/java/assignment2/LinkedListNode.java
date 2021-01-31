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
	
	/**
	 * Returns the number of nodes reachable from this.
	 * 
	 * @return number of reachable nodes.
	 */
	public int countReachableNodes() {
		
		var visited = new java.util.HashSet<LinkedListNode<T>>();

		var node = this;

		while (!visited.contains(node) && node != null) {
			visited.add(node);
			node = node.next;
		}
		
		return visited.size();
	}

}

