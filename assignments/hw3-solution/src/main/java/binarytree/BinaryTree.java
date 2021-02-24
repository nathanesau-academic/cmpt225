package binarytree;

import java.util.*;
import java.util.stream.IntStream;

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
	 * @param <T> the data type for the tree.
	 * @param preOrder pre-order traversal for the tree.
	 * @param inOrder in-order traversal for the tree.
	 * @return the binary tree corresponding to the in-order and pre-order traversal.
	 */
	public static <T> BinaryTree<T> createFromPreorderInorder(List<T> preOrder, List<T> inOrder) {
		
		class Helper {
			BTNode<T> construct_tree(List<T> preOrder, List<T> inOrder, BTNode<T> parent) {
				if (inOrder.isEmpty()) {
					return null;
				}
				
				T data = preOrder.remove(0);
				BTNode<T> root = new BTNode<T>(data);		
				int index = IntStream.range(0, inOrder.size())
					.filter(i -> inOrder.get(i) == data).findFirst().orElse(-1);
				if (index != -1 && index > 0) {
					root.setLeftChild(construct_tree(preOrder, inOrder.subList(0, index), root));
				}
				if (index != -1 && index + 1 < inOrder.size()) {
					root.setRightChild(construct_tree(preOrder, inOrder.subList(index+1, inOrder.size()), root));
				}
				return root;
			}
		}

		Helper helper = new Helper();
		ArrayList<T> preOrderClone = new ArrayList<T>(preOrder);
		ArrayList<T> inOrderClone = new ArrayList<T>(inOrder);
		BTNode<T> root = helper.construct_tree(preOrderClone, inOrderClone, null);
		return new BinaryTree<T>(root);
	}

	/**
	 * creates an inOrder iterator for this.
	 * the iterator is dynamic in the following sense:
	 * If after the iterator is created, and the tree changes in some part
	 * that has not been processed by the iterator, then the iterator will see these changes
	 * and output the values in the updated tree 
	 * @return the in-order iterator for the tree.
	 */
	public Iterator<T> inOrderIterator() {
		
		@SuppressWarnings("hiding")
		class InOrderIterator<T> implements Iterator<T> {

			BTNode<T> node;

			Set<BTNode<T>> visited = new HashSet<BTNode<T>>();

			public InOrderIterator(BinaryTree<T> tree) {				
				this.node = tree.getRoot();
			}

			// returns the next node (would be static if allowed)
			public BTNode<T> advance(BTNode<T> node, Set<BTNode<T>> visited) {
				if (node == null) {
					return null;
				}

				while (node.getLeftChild() != null && !visited.contains(node.getLeftChild())) {
					node = node.getLeftChild();
				}

				if (!visited.contains(node)) {
					return node;
				}

				// NOTE: left no longer an option
				if (node.getRightChild() != null && !visited.contains(node.getRightChild())) {
					return advance(node.getRightChild(), visited);
				}

				// NOTE: right no longer an option
				if (node.getParent() != null && !visited.contains(node.getParent())) {
					node = node.getParent();
				}

				if (!visited.contains(node)) {
					return node;
				}

				if (node.getParent() != null) {
					return advance(node.getParent(), visited);
				}

				return null;
			}

			@Override
			public boolean hasNext() {
				BTNode<T> next = advance(node, visited);
				return next != null;
			}

			@Override
			public T next() { // note: returns null if no next element
				node = advance(node, visited);
				if (node == null) {
					return null;
				}
				visited.add(node);
				return node.getData();
			}

		}

		Iterator<T> it = new InOrderIterator<T>(this);
		return it;
	}

}
