package binarytree;

import java.util.*;

public class BinaryTree<T> {

	private BTNode<T> root;

	public BinaryTree(BTNode<T> root) {
		this.root = root;
	}

	public BTNode<T> getRoot() {
		return root;
	}

	/**
	 * reverse the tree so that the result
	 * is a mirror image of the original tree
	 */
	public void mirrorInverse() {
		class NDPair {
			BTNode<T> node;
			int depth;

			NDPair(BTNode<T> node, int depth) {
				this.node = node;
				this.depth = depth;
			}
		};

		class Helper {
			void invertLevel(List<BTNode<T>> levelNodes) {
				int left = 0;
				int right = levelNodes.size() - 1;
				while (left < right) {
					BTNode<T> leftNode = levelNodes.get(left);
					BTNode<T> rightNode = levelNodes.get(right);
					T tmp = leftNode.getData();
					leftNode.setData(rightNode.getData());
					rightNode.setData(tmp);
					left += 1;
					right -= 1;
				}
			}
		}

		Helper helper = new Helper();

		// uses level order traversal
		int level = 0;
		List<BTNode<T>> levelNodes = new ArrayList<BTNode<T>>();
		List<NDPair> q = new ArrayList<NDPair>();
		q.add(new NDPair(root, 0));
		while (!q.isEmpty()) {
			NDPair ndPair = q.remove(0);
			if (ndPair.depth > level) { // invert the previous level
				helper.invertLevel(levelNodes);
				level += 1;
				levelNodes.clear();
			}

			// visit the node
			levelNodes.add(ndPair.node);

			if (ndPair.node.getLeftChild() != null) {
				q.add(new NDPair(ndPair.node.getLeftChild(), ndPair.depth+1));
			}
			
			if (ndPair.node.getRightChild() != null) {
				q.add(new NDPair(ndPair.node.getRightChild(), ndPair.depth+1));
			}
		}

		helper.invertLevel(levelNodes);
	}

	/**
	 * 
	 * gets inOrder and preOrder of a binary tree and recovers the tree
	 * @param inOrder
	 * @param preOrder
	 * @return
	 */
	public static <T> BinaryTree<T> createFromPreorderInorder(List<T> inOrder, List<T> preOrder) {
		// TODO implement me
		return null;
	}

	/**
	 * creates an inOrder iterator for this.
	 * the iterator is dynamic in the following sense:
	 * If after the iterator is created, and the tree changes in some part
	 * that has not been processed by the iterator, then the iterator will see these changes
	 * and output the values in the updated tree 
	 * @return
	 */
	public Iterator<T> inOrderIterator() {
		// TODO implement me
		// may use an inner class or a standalone class in a separate file
		return null;
	}

}
