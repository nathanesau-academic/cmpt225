package assignment2;

import org.junit.Assert;
import org.junit.Test;

// junit5 doesn't play well with vscode
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.Test;

public class CircularLinkedListTest {

    CircularLinkedList<Integer> createCircularLinkedList(Integer[] list) {

        var circularList = new CircularLinkedList<Integer>();
        
        for(Integer element : list) {
            circularList.addAfter(element);
            circularList.moveForward();
        }

        return circularList;
    }

    CircularLinkedList<String> createCircularLinkedList(String[] list) {

        var circularList = new CircularLinkedList<String>();
        
        for(String element : list) {
            circularList.addAfter(element);
            circularList.moveForward();
        }

        return circularList;
    }

    @Test 
    public void testConstructor() {
        
        var list1 = new CircularLinkedList<Integer>();
        assert(list1.isEmpty());

        var list2 = new CircularLinkedList<Integer>(5, 1);
        assert(!list2.isEmpty());
    }

    @Test
    public void testGenericTypes() {

        var list1 = createCircularLinkedList(new Integer[] { 5, 1, 3 });
        assert !list1.isEmpty();

        var list2 = createCircularLinkedList(new String[] { "A", "C", "B" });
        assert !list2.isEmpty();
    }

    @Test
    public void testMoveForward() {

        var list1 = new CircularLinkedList<Integer>();

        try {
            list1.moveForward();
            Assert.fail("java.util.NoSuchElementException should have been thrown!");
        }
        catch (java.util.NoSuchElementException e) {
            // OK
        }

        list1.addAfter(5);
        list1.moveForward();
        list1.addAfter(1);
        list1.moveForward();
        list1.addAfter(3);
        
        // 3 -> 5 -> 1 -> (loop)
        list1.moveForward();
        assert(list1.getValue() == 3);

        // 5 -> 1 -> 3 -> (loop)
        list1.moveForward();
        assert(list1.getValue() == 5);
    }

    @Test
    public void testMoveBackward() {

        var list1 = new CircularLinkedList<Integer>();

        try {
            list1.moveBackward();
            Assert.fail("java.util.NoSuchElementException should have been thrown!");
        }
        catch (java.util.NoSuchElementException e) {
            // OK
        }

        list1.addBefore(5);
        list1.moveBackward();
        list1.addBefore(1);
        list1.moveBackward();
        list1.addBefore(3);

        // 3 -> 1 -> 5 -> (loop)
        list1.moveBackward();
        assert(list1.getValue() == 3);

        // 5 -> 3-> 1 -> (loop)
        list1.moveBackward();
        assert(list1.getValue() == 5);
    }

    @Test
    public void testGetValue() {

        var list1 = new CircularLinkedList<Integer>();

        try {
            list1.getValue();
            Assert.fail("java.util.NoSuchElementException should have been thrown!");
        }
        catch (java.util.NoSuchElementException e) {
            // OK
        }

        list1 = createCircularLinkedList(new Integer[] { 5, 1, 3});
        
        // 3 -> 5 -> 1 -> (loop)
        assert(list1.getValue() == 3);

         // 1 -> 3 -> 5 -> (loop)
        list1.moveBackward();
        assert(list1.getValue() == 1);

        // 5 -> 1 -> (loop)
        list1.removeAfter();
        list1.moveForward();
        assert(list1.getValue() == 5);
    }

    @Test
    public void testSetValue() {

        var list1 = new CircularLinkedList<Integer>();

        try {
            list1.setValue(5);
            Assert.fail("java.util.NoSuchElementException should have been thrown!");
        }
        catch (java.util.NoSuchElementException e) {
            // OK
        }

        list1 = createCircularLinkedList(new Integer[] { 5, 1, 3});

        // 3 -> 5 -> 1 -> (loop)
        assert(list1.getValue() == 3);

        // 7 -> 5 -> 1 -> (loop)
        list1.setValue(7);
        assert(list1.getValue() == 7);

        // 5 -> 1 -> 7 -> (loop)
        list1.moveForward();
        assert(list1.getValue() == 5);

        // 9 -> 1 -> 7 -> (loop)
        list1.setValue(9);
        assert(list1.getValue() == 9);

        // 7 -> 1 -> 9 -> (loop)
        list1.moveBackward();
        assert(list1.getValue() == 7);
    }

    @Test
    public void testAddBefore() {

        var list1 = new CircularLinkedList<Integer>();
        list1.addBefore(5);
        list1.removeBefore();
        list1.addBefore(7);

        assert(list1.getValue() == 7);

        list1.addBefore(3);
        list1.addBefore(5);
        assert(list1.getValue() == 7);

        // iterate backwards through circle
        list1.moveBackward();
        assert(list1.getValue() == 5);
        list1.moveBackward();
        assert(list1.getValue() == 3);
        list1.moveBackward();
        assert(list1.getValue() == 7);
        list1.moveBackward();
        assert(list1.getValue() == 5);

        // iterate forwards through circle
        list1.moveForward();
        assert(list1.getValue() == 7);
        list1.moveForward();
        assert(list1.getValue() == 3);
        list1.moveForward();
        assert(list1.getValue() == 5);
        list1.moveForward();
        assert(list1.getValue() == 7);
    }

    @Test
    public void testAddAfter() {
        
        var list1 = new CircularLinkedList<Integer>();
        list1.addAfter(5);
        list1.removeAfter();
        list1.addAfter(7);

        assert(list1.getValue() == 7);

        list1.addAfter(3);
        list1.addAfter(5);
        assert(list1.getValue() == 7);

        // iterate forwards through circle
        list1.moveForward();
        assert(list1.getValue() == 5);
        list1.moveForward();
        assert(list1.getValue() == 3);
        list1.moveForward();
        assert(list1.getValue() == 7);
        list1.moveForward();
        assert(list1.getValue() == 5);

        // iterate backwards through circle
        list1.moveBackward();
        assert(list1.getValue() == 7);
        list1.moveBackward();
        assert(list1.getValue() == 3);
        list1.moveBackward();
        assert(list1.getValue() == 5);
        list1.moveBackward();
        assert(list1.getValue() == 7);
    }

    @Test
    public void testRemoveBefore() {

        var list1 = new CircularLinkedList<Integer>();

        try {
            list1.removeBefore();
            Assert.fail("java.util.NoSuchElementException should have been thrown!");
        }
        catch (java.util.NoSuchElementException e) {
            // OK
        }

        list1.addAfter(5);
        list1.removeBefore();
        assert(list1.isEmpty());

        try {
            list1.removeBefore();
            Assert.fail("java.util.NoSuchElementException should have been thrown!");
        }
        catch (java.util.NoSuchElementException e) {
            // OK
        }

        // 1 -> 3 -> 5 -> loop
        list1 = createCircularLinkedList(new Integer[] { 5, 1, 3} );
        list1.moveBackward();
        assert(list1.getValue() == 1);

        // 1 -> 3 -> loop
        list1.removeBefore();
        list1.moveBackward();
        assert(list1.getValue() == 3);

        // iterate backwards through circle
        list1.moveBackward();
        assert(list1.getValue() == 1);
        list1.moveBackward();
        assert(list1.getValue() == 3);

        // iterate forwards through circle
        list1.moveForward();
        assert(list1.getValue() == 1);
        list1.moveForward();
        assert(list1.getValue() == 3);
    }

    @Test
    public void testRemoveAfter() {

        var list1 = new CircularLinkedList<Integer>();

        try {
            list1.removeAfter();
            Assert.fail("java.util.NoSuchElement exception should have been thrown!");
        }
        catch (java.util.NoSuchElementException e) {
            // OK
        }

        list1.addBefore(5);
        list1.removeAfter();
        assert(list1.isEmpty());

        try {
            list1.removeAfter();
            Assert.fail("java.util.NoSuchElementException should have been thrown!");
        }
        catch (java.util.NoSuchElementException e) {
            // OK
        }

        // 1 -> 3 -> 5 -> loop
        list1 = createCircularLinkedList(new Integer[] { 5, 1, 3 });
        list1.moveBackward();
        assert(list1.getValue() == 1);

        // 1 -> 5 -> loop
        list1.removeAfter();
        list1.moveForward();
        assert(list1.getValue() == 5);

        // iterate forwards through circle
        list1.moveForward();
        assert(list1.getValue() == 1);
        list1.moveForward();
        assert(list1.getValue() == 5);

        // iterate backwards through circle
        list1.moveBackward();
        assert(list1.getValue() == 1);
        list1.moveBackward();
        assert(list1.getValue() == 5);
    }

    @Test
    public void testIsEmpty() {

        var list1 = new CircularLinkedList<Integer>();
        assert(list1.isEmpty());

        list1.addAfter(5);
        assert(!list1.isEmpty());
        
        list1.removeBefore();
        assert(list1.isEmpty());
    }

}
