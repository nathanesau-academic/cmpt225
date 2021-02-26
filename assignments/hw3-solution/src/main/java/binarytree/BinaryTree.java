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

	public void invertArr(List<BTNode<T>> arr) {
		for (var node : arr) {
			var tmp = node.getLeftChild();
			node.setLeftChild(node.getRightChild());
			node.setRightChild(tmp);
		}
	}

	/**
	 * reverse the tree so that the result
	 * is a mirror image of the original tree
	 */
	public void mirrorInverse() 
	{
		var q = new ArrayList<>(Arrays.asList(new AbstractMap.SimpleImmutableEntry<>(root, 0)));
		int max_depth = 0;
		var arr = new ArrayList<BTNode<T>>();
		
		// use level order traversal
		while (!q.isEmpty()) {
			var entry = q.remove(0);
			BTNode<T> node = entry.getKey();
			int depth = entry.getValue();

			if (depth > max_depth) { // invert the previous level
				invertArr(arr);
				max_depth = Math.max(depth, max_depth);
				arr.clear();
			}

			arr.add(node);

			if (node.getLeftChild() != null) {
				q.add(new AbstractMap.SimpleImmutableEntry<>(node.getLeftChild(), depth+1));
			}
			
			if (node.getRightChild() != null) {
				q.add(new AbstractMap.SimpleImmutableEntry<>(node.getRightChild(), depth+1));
			}
		}

		invertArr(arr);		
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
