package arithmetic;

import java.util.*;

import binarytree.BTNode;

public class ArithmeticExpressions {

	final public static int PLUS = 0;
	final public static int MINUS = 1;
	final public static int MULT = 2;
	final public static int DIV = 3;
	static final List<String> opsStr = Arrays.asList("+", "-", "*", "/");

	public static boolean isOperation(String str) {
		return opsStr.contains(str);
	}

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * converts infix notation to prefix notation
	 * @param infixExpression
	 * @return
	 */
	public static String infix2Prefix(String infixExpression) {
		// TODO implement me
		return null;
	}

	/**
	 * converts postfix notation to binary tree representation of an arithmetic expression
	 * @param infixExpression
	 * @return
	 */
	public static BTNode<Double> postfix2BinaryTree(String postfixExpression) {
		// traverse expression from start to end
		// add number to stack
		// add operators to tree as parent nodes
		java.util.Stack<BTNode<Double>> stack = new java.util.Stack<BTNode<Double>>();
		for (String s : postfixExpression.split(" ")) {
			try { // s is a number
				Double d = Double.parseDouble(s);
				BTNode<Double> node = new BTNode<Double>(d);
				stack.push(node);
			}
			catch (NumberFormatException e) { // s is an operator
				Double d  = Double.valueOf(opsStr.indexOf(s));
				BTNode<Double> node = new BTNode<Double>(d);
				BTNode<Double> right = stack.pop();
				right.setParent(node);
				node.setRightChild(right);
				BTNode<Double> left = stack.pop();
				left.setParent(node);
				node.setLeftChild(left);
				stack.push(node);
			}
		}

		BTNode<Double> root = stack.pop();
		return root;
	}
}
