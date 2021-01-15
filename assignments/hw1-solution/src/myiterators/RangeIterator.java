package myiterators;

public class RangeIterator implements IntegerIterator
{
	int a0 = 0;
	int n;
	int diff = 1;
	int a;

	/**
	 * @param n
	 * Creates an iterator with range 0,1, ..., n-1
	 */
	public RangeIterator(int n) {
		this.n = n;
		this.a = a0;
	}
	
	/**
	 * @param n
	 * Creates an iterator with range a0, a0+1, ..., n-1
	 */
	public RangeIterator(int a0, int n) {
		this.a0 = a0;
		this.n = n;
		this.a = a0;
	}
	
	/**
	 * @param n
	 * Creates an iterator with range a0, a0+diff, , a0+2*diff, ..., a0+k*diff
	 * for the maximal k such that a0+k*diff<n
	 */
	public RangeIterator(int a0, int n, int diff) {
		this.a0 = a0;
		this.n = n;
		this.diff = diff;
		this.a = a0;
	}
	
	public boolean hasNext() {
		if (a > n - diff) {
			return false;
		}
		return true;
	}
	
	public int getNext() {
		if (hasNext()) {
			int val = a;
			a += diff;
			return val;
		}
		return 0;
	}
	
	public void reset() {
		this.a = a0;
	}
}
