package stacks.and.queues;

/**
 * Implementing a stack using ArrayList
 *   
 * @author Igor
 *
 */

import java.util.ArrayList;

public class StackArrayBased<T> implements Stack<T> {

	private ArrayList<T> list;
	
	public StackArrayBased() {
		list = new ArrayList<T>();
	}
	
	public void push(T item) {
		list.add(item);
	}
	
	public T pop() {
		return list.remove(list.size()-1);
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
}


	