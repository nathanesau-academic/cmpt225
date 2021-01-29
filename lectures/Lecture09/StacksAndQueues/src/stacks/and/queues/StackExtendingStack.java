package stacks.and.queues;

/**
 * Implementing a Stack by inheriting from ArrayList
 * This is essentially an adapter
 *   
 * @author Igor
 *
 */

import java.util.ArrayList;

public class StackExtendingStack<T> extends ArrayList<T> implements Stack<T>{

	private static final long serialVersionUID = 6341562563374611333L;

	public StackExtendingStack() {
		super();
	}

	public void push(T item) {
		super.add(item);
	}
	
	public T pop() {
		return super.remove(size()-1);
	}
	
//	public boolean isEmpty() already defined in ArrayList
	
}


	