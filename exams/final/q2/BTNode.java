public class BTNode<T> {

    private T data;

    private BTNode<T> leftChild;

    private BTNode<T> rightChild;

    private BTNode<T> parent;

    public BTNode(T data, BTNode<T> parent) {
        this.data = data;
        this.parent = parent;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setLeftChild(BTNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BTNode<T> getLeftChild() {
        return leftChild;
    }

    public void setRightChild(BTNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BTNode<T> getRightChild() {
        return rightChild;
    }

    public void setParent(BTNode<T> parent) {
        this.parent = parent;
    }

    public BTNode<T> getParent() {
        return parent;
    }

}