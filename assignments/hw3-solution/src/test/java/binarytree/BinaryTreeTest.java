package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.lang.Math;

import org.junit.Test;

public class BinaryTreeTest {

    void printTree(BinaryTree<Integer> tree) {
        /**
         * algorithm:
         * - get row for each node [1, 2, 2, 3, 3]
         * - get col for each node [3, 2, 4, 1, 3]
         * - get adj_row for each node [1, 3, 3, 5, 5]
         * - get adj_col for each node [5, 3, 7, 1, 5]
         * - fill max(adj_row) * max(adj_col) grid
         * 
         * requires one vertical and one level order traversal for tree
         */
        class BinaryTreeHelper {

            class NDPair {
                BTNode<Integer> node;
                int depth;

                NDPair(BTNode<Integer> node, int depth) {
                    this.node = node;
                    this.depth = depth;
                }
            }

            Map<BTNode<Integer>, Integer> _get_rows(BTNode<Integer> root) {
                Map<BTNode<Integer>, Integer> rows = new HashMap<BTNode<Integer>, Integer>();
                // level_order traversal
                List<NDPair> q = new ArrayList<NDPair>();
                q.add(new NDPair(root, 1));
                while (!q.isEmpty()) {
                    NDPair ndPair = q.remove(0);
                    rows.put(ndPair.node, ndPair.depth);
                    
                    if (ndPair.node.getLeftChild() != null) {
                        q.add(new NDPair(ndPair.node.getLeftChild(), ndPair.depth+1));
                    }

                    if (ndPair.node.getRightChild() != null) {
                        q.add(new NDPair(ndPair.node.getRightChild(), ndPair.depth+1));
                    }
                }

                return rows;
            }

            void _find_min_max(BTNode<Integer> node, Integer hd, Integer[] min_hd, Integer[] max_hd) {
                if (node == null) {
                    return;
                }

                min_hd[0] = Math.min(min_hd[0], hd);
                max_hd[0] = Math.max(max_hd[0], hd);
                _find_min_max(node.getLeftChild(), hd-1, min_hd, max_hd);
                _find_min_max(node.getRightChild(), hd+1, min_hd, max_hd);
            }

            void _fill_column(BTNode<Integer> node, Integer col, Integer hd, Map<BTNode<Integer>, Integer> cols) {
                if (node == null) {
                    return;
                }

                if (hd == col) {
                    cols.put(node, col);
                }

                _fill_column(node.getLeftChild(), col, hd-1, cols);
                _fill_column(node.getRightChild(), col, hd+1, cols);
            }

            Map<BTNode<Integer>, Integer> _get_cols(BTNode<Integer> root) {
                Map<BTNode<Integer>, Integer> cols = new HashMap<BTNode<Integer>, Integer>();
                // vertical-order traversal
                Integer[] min_hd = {0};
                Integer[] max_hd = {0};
                _find_min_max(root, 0, min_hd, max_hd);
                for(Integer col = min_hd[0]; col <= max_hd[0]; col++) {
                    _fill_column(root, col, 0, cols);
                }

                return cols;
            }
        }

        BinaryTreeHelper helper = new BinaryTreeHelper();
        Map<BTNode<Integer>, Integer> rows = helper._get_rows(tree.getRoot()); 
        Map<BTNode<Integer>, Integer> cols = helper._get_cols(tree.getRoot());
        Integer col_offset = Math.abs(Collections.min(cols.values())) + 1;
        for (BTNode<Integer> k : rows.keySet()) {
            int row = rows.get(k);
            rows.put(k, row + (row - 1));
        }
        for (BTNode<Integer> k : cols.keySet()) {
            int col = cols.get(k) + col_offset;
            cols.put(k, col + (col - 1));
        }

        Character[][] arr = new Character[Collections.max(rows.values())][Collections.max(cols.values())];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = '.';
            }
        }

        for (Entry<BTNode<Integer>, Integer> entry: rows.entrySet()) {
            BTNode<Integer> k = entry.getKey();
            Integer rv = entry.getValue();
            Integer cv = cols.get(k);
            arr[rv-1][cv-1] = String.valueOf(k.getData()).toCharArray()[0];
            if (k.getParent() != null) {
                Integer prv = rows.get(k.getParent());
                Integer pcv = cols.get(k.getParent());
                if (pcv > cv) {
                    arr[prv][pcv-2] = '/';
                }
                else {
                    arr[prv][pcv] = '\\';
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    BinaryTree<Integer> createTree() {
        // creating the tree
        //       5
		//      / \
		//     2   6
		//    / \   \
		//   1   4   8
        BTNode<Integer> node8 = new BTNode<Integer>(8);
        BTNode<Integer> node6 = new BTNode<Integer>(6, null, node8, null);
		BTNode<Integer> node1 = new BTNode<Integer>(1);
		BTNode<Integer> node4 = new BTNode<Integer>(4);
		BTNode<Integer> node2 = new BTNode<Integer>(2, node1, node4, null);
		BTNode<Integer> node5 = new BTNode<Integer>(5, node2, node6, null);
		return new BinaryTree<Integer>(node5);
    }

    @Test
    public void testMirrorInverse() {
        System.out.println("testMirrorInverse");
        BinaryTree<Integer> tree = createTree();
        printTree(tree);
        tree.mirrorInverse();
        printTree(tree);
        assert(tree != null && tree.getRoot().getData() == 5);
        assert(tree.getRoot().getLeftChild() != null && tree.getRoot().getLeftChild().getData() == 6);
        assert(tree.getRoot().getLeftChild().getLeftChild() != null
            && tree.getRoot().getLeftChild().getLeftChild().getData() == 8);
    }

    @Test
    public void testTreeFromTraversal1() {
        // creating the tree
        //       3
		//      / \
		//     2   5
		//    /   / \
		//   1   4   6   
        List<Integer> preorder = Arrays.asList(3,2,1,5,4,6);
        List<Integer> inorder = Arrays.asList(1,2,3,4,5,6);
        BinaryTree<Integer> tree = BinaryTree.createFromPreorderInorder(preorder, inorder);

        printTree(tree);

        assert(tree != null);
        assert(tree.getRoot() != null && tree.getRoot().getData() == 3);
        assert(tree.getRoot().getLeftChild() != null && tree.getRoot().getLeftChild().getData() == 2);
        assert(tree.getRoot().getLeftChild().getRightChild() == null);
    }

    @Test
    public void testInOrderIterator1() {
        BinaryTree<Integer> tree = createTree();
        Iterator<Integer> inOrderIt = tree.inOrderIterator();
        List<Integer> vals = Arrays.asList(new Integer[] {1, 2, 4, 5, 6, 8});

        for (Iterator<Integer> it = vals.iterator(); it.hasNext(); ) {
            int expected = (int) it.next();
            assert(inOrderIt.hasNext() && inOrderIt.next() == expected);
        }

        assert(!inOrderIt.hasNext());
    }

    @Test
    public void testInOrderIterator2() {
        BinaryTree<Integer> tree = createTree();
        Iterator<Integer> inOrderIt = tree.inOrderIterator();

        // initial values
        List<Integer> vals = Arrays.asList(new Integer[] {1, 2});

        for (Iterator<Integer> it = vals.iterator(); it.hasNext(); ) {
            int expected = (int) it.next();
            assert(inOrderIt.hasNext() && inOrderIt.next() == expected);
        }

        // modify tree
        tree.getRoot().getRightChild().getRightChild().setData(9);

        // final values
        vals = Arrays.asList(new Integer[] {4, 5, 6, 9});

        for (Iterator<Integer> it = vals.iterator(); it.hasNext(); ) {
            int expected = (int) it.next();
            assert(inOrderIt.hasNext() && inOrderIt.next() == expected);
        }

        assert (!inOrderIt.hasNext());
    }

}