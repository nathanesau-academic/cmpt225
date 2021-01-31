package assignment2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import mystack.MyStack;

// junit5 doesn't play well with vscode
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.Test;

public class MyStackOperationsTest {
    
    MyStack<Integer> arrayToMyStack(Integer[] list) {
        
        var myStack = new MyStack<Integer>();

        for (Integer element : list) {
            myStack.push(element);
        }

        return myStack;
    }

    List<Integer> myStackToList(MyStack<Integer> myStack) {

        var myList = new ArrayList<Integer>();

        // NOTE: cloneStack shouldn't modify myStack
        var clonedStack = MyStackOperations.cloneStack(myStack);

        while (!clonedStack.isEmpty()) {
            myList.add(clonedStack.pop());
        }

        return myList;
    }

    @Test
    public void testCloneStack() {

        var myStack = arrayToMyStack(new Integer[] { 5, 1, 3 });

        var clonedStack = MyStackOperations.cloneStack(myStack);

        // check size of clonedStack
        assert(MyStackOperations.size(clonedStack) == 3);

        // check elements in clonedStack
        var list = myStackToList(clonedStack);
        assert(list.equals(List.of(3, 1, 5)));

        // make sure cloneStack doesn't modify myStack (check size)
        assert(MyStackOperations.size(myStack) == 3);

        // make sure cloneStack doesn't modify myStack (check elements)
        list = myStackToList(clonedStack);
        assert(list.equals(List.of(3, 1, 5)));
    }

    @Test
    public void testSize() {

        var myStack = arrayToMyStack(new Integer[] { 5, 1, 3 });

        // check size of myStack
        assert(MyStackOperations.size(myStack) == 3);

        // make sure size doesn't modify myStack (check size)
        assert(MyStackOperations.size(myStack) == 3);

        // make sure size doesn't modify myStack (check elements)
        var list = myStackToList(myStack);
        assert(list.equals(List.of(3, 1, 5)));
    }

    @Test
    public void testReverse() {

        var myStack = arrayToMyStack(new Integer[] { 5, 1, 3 });

        // check elements before reverse
        var list = myStackToList(myStack);
        assert(list.equals(List.of(3, 1, 5)));

        // check elements after reverse
        MyStackOperations.reverse(myStack);
        list = myStackToList(myStack);
        assert(list.equals(List.of(5, 1, 3)));
    }

}
