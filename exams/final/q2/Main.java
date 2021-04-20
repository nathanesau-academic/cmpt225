public class Main {

    public static void main(String[] args) {
        //var root = new BTNode<Integer>(4, null);
        //root.setLeftChild(new BTNode<Integer>(2, root));
        //root.setRightChild(new BTNode<Integer>(9, root));
        //root.getRightChild().setLeftChild(new BTNode<Integer>(8, root.getRightChild()));
        //root.getRightChild().setRightChild(new BTNode<Integer>(10, root.getRightChild()));

        var root = new BTNode<Integer>(4, null);
        root.setLeftChild(new BTNode<Integer>(2, root));
        root.setRightChild(new BTNode<Integer>(10, root));
        root.getRightChild().setLeftChild(new BTNode<Integer>(8, root.getRightChild()));
        root.getRightChild().getLeftChild().setRightChild(new BTNode<Integer>(8, root.getRightChild()));

        Solver<Integer> solver = new Solver<>();
        Boolean result = solver.isAVLTree(root);
        System.out.println(result);
    }
}
