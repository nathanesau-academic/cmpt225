import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem3 {

    public class BinaryTree<T> {

        public class BTNode<T> {
            public T data;
            public BTNode<T> leftChild;
            public BTNode<T> rightChild;
            public BTNode<T> parent; 
        
            public BTNode(T data) {
                this.data = data;
                this.leftChild = null;
                this.rightChild = null;
                this.parent = null;
            }
            
            public BTNode(T data, BTNode<T> left, BTNode<T> right, BTNode<T> parent) {
                this.data = data;
                if (left!=null)
                    setLeftChild(left);
                if (right!=null)
                    setRightChild(right);
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
                if (leftChild != null) {
                    leftChild.parent = this;
                }
            }
        
            public void setRightChild(BTNode<T> rightChild) {
                this.rightChild = rightChild;
                if (rightChild != null) {
                    rightChild.parent = this;
                }
            }
        
            public void setParent(BTNode<T> parent) {
                this.parent = parent;
            }
        
        }

        public BTNode<T> root;

        public BinaryTree(BTNode<T> root) {
            this.root = root;
        }

        public BTNode<T> getRoot() {
            return root;
        }

        public void _preOrder(BTNode<T> node) {
            if (node == null) {
                return;
            }

            System.out.println(node.getData());
            _preOrder(node.getLeftChild());
            _preOrder(node.getRightChild());
        }

        public void preOrder() {
            _preOrder(root);
        }

        public boolean equalsHelper(BTNode<T> node1, BTNode<T> node2) {
            if (node1 == null && node2 == null) {
                return true;
            }

            if (node1 != null && node2 != null) {
                System.out.printf("%s = %s ?\n", node1.getData(), node2.getData());

                return node1.getData().equals(node2.getData()) && 
                    equalsHelper(node1.getLeftChild(), node2.getLeftChild()) &&
                    equalsHelper(node1.getRightChild(), node2.getRightChild());
            }

            return false;
        }

        @Override
        public boolean equals(Object other) {

            if (!other.getClass().equals(getClass())) {
                return false;
            }
            
            var otherTree = BinaryTree.class.cast(other);
            var otherRoot = BTNode.class.cast(otherTree.getRoot());
            return equalsHelper(root, otherRoot);
        }

        public int depthOfSwallowestLeaf() { // assume root is not null
            var q = new ArrayList<Map.Entry<BTNode<T>, Integer>>();
            q.add(new AbstractMap.SimpleEntry<BTNode<T>, Integer>(root, 1));
            while (!q.isEmpty()) {
                Map.Entry<BTNode<T>, Integer> entry = q.remove(0);
                BTNode<T> node = entry.getKey();
                Integer depth = entry.getValue();
                
                if (node.getLeftChild() == null && 
                    node.getRightChild() == null) {
                    return depth;
                }

                if (node.getLeftChild() != null) {
                    q.add(new AbstractMap.SimpleEntry<BTNode<T>, Integer>(
                        node.getLeftChild(), depth + 1));
                }

                if (node.getRightChild() != null) {
                    q.add(new AbstractMap.SimpleEntry<BTNode<T>, Integer>(
                        node.getRightChild(), depth + 1));
                }
            }

            return 0;
        }
    }

}
