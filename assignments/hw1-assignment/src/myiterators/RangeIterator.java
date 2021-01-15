package myiterators;

public class RangeIterator implements IntegerIterator
{
	/**
	 * @param n
	 * Creates an iterator with range 0,1, ..., n-1
	 */
	public RangeIterator(int n) {
		// TODO implement me
	}
	
	/**
	 * @param n
	 * Creates an iterator with range a0, a0+1, ..., n-1
	 */
	public RangeIterator(int a0, int n) {
		// TODO implement me
	}
	
	/**
	 * @param n
	 * Creates an iterator with range a0, a0+diff, , a0+2*diff, ..., a0+k*diff
	 * for the maximal k such that a0+k*diff<n
	 */
	public RangeIterator(int a0, int n, int diff) {
		// TODO implement me
	}
	
	public boolean hasNext() {
		// TODO implement me
		return false;
	}
	
	public int getNext() {
		// TODO implement me
		return 0;
	}
	
	public void reset() {
		// TODO implement me
	}
}
