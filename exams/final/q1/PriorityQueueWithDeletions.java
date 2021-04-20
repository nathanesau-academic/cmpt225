import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityQueueWithDeletions<T extends Comparable<T>> {
    
    private List<T> arr;

    private Map<T, Integer> indexMap;

    private int getParent(int i) {
		return ((i+1)/2)-1;
	}

    private int getLC(int i) {
		return 2*i+1;
	}

	private int getRC(int i) {
		return 2*i+2;
	}

	private void swap(int i, int j) {
		T tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
        // update indexMap
        if (arr.get(i) != null) indexMap.put(arr.get(i), i);
        if (arr.get(j) != null) indexMap.put(arr.get(j), j);
	}

	private int minVertexOrChildren(int i) {
		int min = i;
		if (getLC(i) < arr.size() && arr.get(getLC(i)).compareTo(arr.get(min)) < 0)
            min = getLC(i); 
		if (getRC(i) < arr.size() && arr.get(getRC(i)).compareTo(arr.get(min)) < 0)
            min = getRC(i); 
		return min;
	}

    private void heapify(int i) {
		if (i < arr.size()) {
			int j = minVertexOrChildren(i);
			if (j != i) {
				swap(i,j);
				heapify(j);
			}
		}
	}

    // creates an empty priority queue
    public  PriorityQueueWithDeletions() {
        this.arr = new ArrayList<>();
        this.indexMap = new HashMap<>();
    }

    // adds a new element to the queue - returns ticket used to remove item
    public Ticket<T> enqueue(T item) {
        arr.add(item);
        // update indexMap
        indexMap.put(item, arr.size()-1);

        var i = arr.size() - 1;
        while (i > 0 && arr.get(i).compareTo(arr.get(getParent(i))) < 0) {
			swap(i, getParent(i));
            i = getParent(i);
		}
        return new Ticket<T>(item);
    }

    // removes the oldest element from the queue and returns it.
    public T dequeue() {
        T ret = arr.get(0);
		arr.set(0, arr.get(arr.size()-1));
		arr.remove(arr.size()-1);
        // update index Map
        indexMap.remove(ret);
        indexMap.put(arr.get(0), 0);

		if (size() > 0)
            heapify(0);
		return ret;
    }

    public Boolean greaterThan(T a, T b) {
        if (a == null) return false;
        if (b == null) return true;
        return a.compareTo(b) > 0;
    }

    // removes an element by ticket and returns the removed element
    public T removeByTicket(Ticket<T> t) {
        Integer index = indexMap.get(t.getValue());
        T value = arr.get(index);
        arr.set(index, null);  // treat as smallest possible value
        // update indexMap
        indexMap.remove(value);

        var i = index;
        while (i != 0 && greaterThan(arr.get(getParent(i)), arr.get(i))) {
            swap(i, getParent(i));
        }
        dequeue();
        return value;
    }

    // returns the number of elements in the queue
    public int size() {
        return arr.size();
    }

    // checks if the queue is empty
    public boolean isEmpty() {
        return arr.isEmpty();
    }

}