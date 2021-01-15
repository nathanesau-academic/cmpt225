package myiterators;

public class ArrayIterator implements IntegerIterator
{
	int[] ar;
	int index = 0;

	/**
	 * @param ar
	 * Creates an iterator for the array 
	 */
	public ArrayIterator(int[] ar) {
		this.ar = ar;
	}
	
	public boolean hasNext() {
		if (index > ar.length - 1) {
			return false;	
		}
		return true;
	}
	
	public int getNext() {
		if (hasNext()) {
			int val = ar[index];
			index += 1;
			return val;
		}
		return 0;
	}
	
	public void reset() {
		this.index = 0;
	}
}
