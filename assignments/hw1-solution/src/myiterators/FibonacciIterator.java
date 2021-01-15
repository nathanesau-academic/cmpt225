package myiterators;

public class FibonacciIterator implements IntegerIterator
{
	int a0 = 0;
	int a1 = 1;
	int a = 0;
	int b = 0;
	int n = 0;

	public FibonacciIterator() {
		this.a = 0;
		this.b = 0;
	}
	
	/**
	 * @param a0 the zero element of the sequence 
	 * @param a1 the first element of the sequence
	 */
	public FibonacciIterator(int a0, int a1) {
		this.a0 = a0;
		this.a1 = a1;
	}

	public boolean hasNext() {
		// the fibonacci sequence does not terminate
		return true;
	}
	
	public int getNext() {
		if (n == 0) {
			b = a0;
			n += 1;
			return a0;
		}
		else if (n == 1) {
			b = a1;
			a = a0;
			n += 1;
			return a1;
		}
		else { // n >= 2
			int c = b + a;
			a = b;
			b = c;
			n += 1;
			return c;
		}
	}
	
	public void reset() {
		a = 0;
		b = 0;
		n = 0;
	}
	
}
