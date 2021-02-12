package binarytrees;
import java.util.*;

public class BinaryTree<T> {

	private BTNode<T> root;

	public BinaryTree(BTNode<T> root) {
		this.root = root;
	}

	public BTNode<T> getRoot() {
		return root;
	}

	public int size() {
		// TODO implement me
		return -1;
	}

	
	
	public int sizeIterative() {
		int size = 0;
		Stack<BTNode<T>> stack = new Stack<BTNode<T>>();
		stack.push(root);

		BTNode<T> currentNode = null;
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			size++;
			
			// push the children in the reverse order 
			if (currentNode.getRightChild() != null)
				stack.push(currentNode.getRightChild());
			if (currentNode.getLeftChild() != null)
				stack.push(currentNode.getLeftChild());
		}
		return size;
	}

	public int height() {
		return root.height();
	}

	public void inOrder() {
		// TODO implement me
	}

	public void preOrder() {
		// TODO implement me
	}

	public void preOrderIterative() {
		Stack<BTNode<T>> stack = new Stack<BTNode<T>>();
		stack.push(root);

		BTNode<T> currentNode = null;
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			System.out.println(currentNode.getData());
			
			// push the children in the reverse order 
			if (currentNode.getRightChild() != null)
				stack.push(currentNode.getRightChild());
			if (currentNode.getLeftChild() != null)
				stack.push(currentNode.getLeftChild());
		}
	}
}
