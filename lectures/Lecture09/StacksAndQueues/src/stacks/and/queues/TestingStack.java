package stacks.and.queues;
/**
 * Testing stacks 
 *   
 * @author Igor
 *
 */

public class TestingStack {

	public static <T> void printStack(Stack<T> stack) {
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}


	public static void main(String[] args) {
		Stack<Integer> s = new StackArrayBased<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println("printing s: ");
		printStack(s);

		s.push(6);
		System.out.println("added6, printing s: ");
		printStack(s);

	}
	
}


