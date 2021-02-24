package arithmetic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import binarytree.BTNode;

// junit5 doesn't play well with vscode
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.Test;

public class ArithmeticExpressionsTest {

    @Test
    public void testInfix2Prefix1() {

        String infix = "+ 1 6";
        String prefix = ArithmeticExpressions.infix2Prefix(infix);
        assert(prefix == "( 1 + 6 )");
    }

    @Test
    public void testInfix2Prefix2() {

        String infix = "* 10.5 / + 8.6 2.4 5.5";
        String prefix = ArithmeticExpressions.infix2Prefix(infix);
        assert(prefix == "( 10.5 * ( ( 8.6 + 2.4 ) / 5.5 ) )");
    }

    @Test
    public void testInfix2Prefix3() {

        String infix = "/ + 6 3 - 6 / 9 3";
        String prefix = ArithmeticExpressions.infix2Prefix(infix);
        assert(prefix == "( ( 6 + 3 ) / ( 6 - ( 9 / 3 ) ) ) ");
    }

    @Test
    public void testInfix2Prefix4() {

        String infix = "/ + 1.1 0.4 - + 7.9 0.0 ";
        String prefix = ArithmeticExpressions.infix2Prefix(infix);
        assert(prefix == "( ( 1.1 + 0.4 ) / ( ( 7.9 + 0 )  - ( 13.25 + 18.04 ) ) ) ");
    }

    @Test
    public void testPostfix2BinaryTree1() {

        BTNode<Double> root = ArithmeticExpressions.postfix2BinaryTree("1 6 +");
        assert(root != null);
        assert(root.getData() == ArithmeticExpressions.PLUS);
        assert(root.getLeftChild() != null);
        assert(root.getLeftChild().getData() == 1);
        assert(root.getRightChild() != null);
        assert(root.getRightChild().getData() == 6);
    }

    @Test
    public void testPostfix2BinaryTree2() {

        BTNode<Double> root = ArithmeticExpressions.postfix2BinaryTree("4.5 0.2 * 6.0 /");
        assert (root != null);
        assert (root.getData() == ArithmeticExpressions.DIV);
        assert(root.getRightChild() != null);
        assert(root.getRightChild().getData() == 0);
        assert(root.getLeftChild() != null);
        assert(root.getLeftChild().getData() == ArithmeticExpressions.MULT);
        assert(root.getLeftChild().getLeftChild() != null);
        assert(root.getLeftChild().getLeftChild().getData() == 4.5);
        assert(root.getLeftChild().getRightChild() != null);
        assert(root.getLeftChild().getRightChild().getData() == 0.2);
    }

}
