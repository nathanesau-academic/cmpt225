package stacks.and.queues;

public interface Queue<T> {
	
	public void enqueue(T item);
	
	public T dequeue();
	
	public boolean isEmpty();


}


	