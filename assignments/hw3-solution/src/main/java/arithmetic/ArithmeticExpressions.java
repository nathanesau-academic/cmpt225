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

	private static String reverse(String expression) {

		StringBuilder builder = new StringBuilder(expression);
		builder.reverse();
		return builder.toString();
	}

	private static String invertParentheses(String expression) {

		StringBuilder builder = new StringBuilder(expression);
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				builder.setCharAt(i, ')');
			}
			else if (expression.charAt(i) == ')') {
				builder.setCharAt(i, '(');
			}
		}
		return builder.toString();
	}

	public static String infix2Postfix(String infixExpression) {

		java.util.Stack<String> stack = new java.util.Stack<String>();
		String postfix = "";
		for (String s : infixExpression.split(" ")) {
			if (ArithmeticExpressions.isNumber(s)) { // s is a number
				postfix += s + " ";
			}
			else if (s.equals("(")) {
				stack.push(s);
			}
			else if (s.equals(")")) {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					postfix += stack.pop() + " ";
				}

				if (!stack.isEmpty()) {
					stack.pop(); // remove "("
				}
			}
			else { // s is an operator
				while (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals(")")) {
					postfix += stack.pop() + " ";
				}

				stack.push(s);
			}
		}

		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}

		return postfix;
	}

	/**
	 * converts infix notation to prefix notation
	 * @param infixExpression the infix arithmetic expression.
	 * @return the prefix arithmetic expression.
	 */
	public static String infix2Prefix(String infixExpression) {
		// 1. reverse infix
		// 2. invert parentheses
		// 3. convert to postfix
		// 4. reverse postfix
		String infix = invertParentheses(reverse(infixExpression));
		String postfix = infix2Postfix(infix);
		String prefix = reverse(postfix);
		return prefix.strip();
	}

	/**
	 * converts postfix notation to binary tree representation of an arithmetic expression
	 * @param postfixExpression the postfix arithmetic expression.
	 * @return the tree corresponding to the expression.
	 */
	public static BTNode<Double> postfix2BinaryTree(String postfixExpression) {
		// traverse expression from start to end
		// add number to stack
		// add operators to tree as parent nodes
		java.util.Stack<BTNode<Double>> stack = new java.util.Stack<BTNode<Double>>();
		for (String s : postfixExpression.split(" ")) {
			if (ArithmeticExpressions.isNumber(s)) { // s is a number
				Double d = Double.parseDouble(s);
				BTNode<Double> node = new BTNode<Double>(d);
				stack.push(node);
			}
			else { // s is an operator
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
