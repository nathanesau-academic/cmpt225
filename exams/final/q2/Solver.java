public class Solver<T> {
    
    public Boolean isAVLTreeHelper(NodePair rootP) {
        if (rootP.node == null) {
            rootP.height = 0;
            return true;
        }

        var leftP = new NodePair<T>(rootP.node.getLeftChild(), rootP.height);
        var rightP = new NodePair<T>(rootP.node.getRightChild(), rootP.height);
        var leftB = isAVLTreeHelper(leftP);  // true if left is AVL tree
        var rightB = isAVLTreeHelper(rightP);  // true if right is AVL tree

        rootP.height = 1 + Math.max(leftP.height, rightP.height);

        if (Math.abs(leftP.height - rightP.height) >= 2) {
            return false;
        }

        return leftB && rightB;
    }

    public Boolean isAVLTree(BTNode<T> root) {

        var rootP = new NodePair<T>(root, 0);
        return isAVLTreeHelper(rootP);
    }

}
