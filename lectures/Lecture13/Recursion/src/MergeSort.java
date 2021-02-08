import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MergeSort {

	/**
	 * 
	 * @param arr
	 * @param start
	 * @param mid
	 * @param end
	 * Assumption arr[start...mid] is sorted and arr[mid+1...end] is sorted
	 * The function merges the two parts into a sorted subarray arr[start...end] 
	 */
	public static void merge(int[] arr, int start, int mid, int end) {
		int tmp[] = new int[end-start+1];
		int ptr1 = start;
		int ptr2 = mid+1;
		int next = 0;
		while (ptr1 <= mid && ptr2 <= end) {
			if (arr[ptr1] < arr[ptr2])
				tmp[next++] = arr[ptr1++];
			else
				tmp[next++] = arr[ptr2++];
		}
		
		// if the first half still has elements left, copy them to the end of the second half
		if (ptr2 == end+1) {
			int eltsLeft = mid-ptr1+1;
			System.arraycopy(arr, ptr1, arr, end-eltsLeft+1, eltsLeft);
		}
		
		// copy tmp into arr
		System.arraycopy(tmp, 0, arr, start, next);
	}
	
	/**
	 * sorts the subarray arr[start...end]
	 */
	public static void mergeSort(int[] arr, int start, int end) {
		if (start==end) 
			return;
		
		int mid = (start+end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		merge(arr, start, mid, end);
	}

	private static class Operation {
		int op;
		int[] args;
		
		Operation(int op, int[] args) {
			this.op = op;
			this.args = args;
		}
	}
	
	public static void mergeSortIterative(int[] arr) {
		final int SORT = 0;
		final int MERGE = 1;
		
		Stack<Operation> stack = new Stack<Operation>();
		stack.push(new Operation(SORT, new int[]{0, arr.length-1}));
		
		Operation cur;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (cur.op == MERGE) {
				merge(arr, cur.args[0], cur.args[1], cur.args[2]);
			}
			else // cur.op == SORT
				if (cur.args[0] < cur.args[1]) { // the subarray has length > 1
					int mid = (cur.args[0] + cur.args[1])/2;
					// push the operations onto the stack in the reverse order
					stack.push(new Operation(MERGE, new int[]{cur.args[0], mid, cur.args[1]}));
					stack.push(new Operation(SORT, new int[]{mid+1, cur.args[1]}));
					stack.push(new Operation(SORT, new int[]{cur.args[0], mid}));
				}
		}
	}

	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}

	
	public static void main(String[] args) {
		int[] arr = {1,6,2,10,-1,9,5,12,5,8,9,-2,-1};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
