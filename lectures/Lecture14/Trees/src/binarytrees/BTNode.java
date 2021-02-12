package binarytrees;

public class BTNode<T> {
	private T data;
	private BTNode<T> leftChild;
	private BTNode<T> rightChild;
	private BTNode<T> parent;
	
	public BTNode(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	public BTNode(T data, BTNode<T> left, BTNode<T> right, BTNode<T> parent) {
		this.data = data;
		this.leftChild = left;
		this.rightChild = right;
		this.parent = parent;
	}

	public T getData() {
		return data;
	}
	
	public BTNode<T> getLeftChild() {
		return leftChild;
	}
	
	public BTNode<T> getRightChild() {
		return rightChild;
	}

	public BTNode<T> getParent() {
		return parent;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setLeftChild(BTNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(BTNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public void setParent(BTNode<T> parent) {
		this.parent = parent;
	}
	
	public int size() {
		int ret = 1; // one for the this
		if (leftChild != null)
			ret += leftChild.size();
		if (rightChild != null)
			ret += rightChild.size();
		return ret; 
	}

	public int height() {
		int leftHeight = -1, rightHeight = -1;
		
		if (leftChild != null)
			leftHeight = leftChild.height();
		if (rightChild != null)
			rightHeight = rightChild.height();

		return Math.max(leftHeight, rightHeight) + 1; 
	}
	
	public void preOrder() {
		// TODO implement me
	}
	
	public void inOrder() {
		// TODO implement me
	}

}
