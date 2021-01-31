package assignment2;

import org.junit.Test;

public class LinkedListNodeTest {
    
    @Test
    public void testCountReachableNodes1() {

        var head = new LinkedListNode<String>("A");
        head.setNext(new LinkedListNode<String>("B"));
        head.getNext().setNext(new LinkedListNode<String>("C"));
        head.getNext().getNext().setNext(new LinkedListNode<String>("D"));
        head.getNext().getNext().getNext().setNext(new LinkedListNode<String>("E"));
        head.getNext().getNext().getNext().getNext().setNext(head.getNext());

        // number of nodes reachable from A
        assert(head.countReachableNodes() == 5);

        // number of nodes reachable from E
        assert(head.getNext().getNext().getNext().getNext().countReachableNodes() == 4);
    }

    @Test
    public void testCountReachableNodes2() {

        var head = new LinkedListNode<String>("X");
        head.setNext(new LinkedListNode<String>("Y"));
        head.getNext().setNext(new LinkedListNode<String>("Z"));
        head.getNext().getNext().setNext(new LinkedListNode<String>("W"));
        
        // number of nodes reachable from X
        assert(head.countReachableNodes() == 4);

        // number of nodes reachable from W
        assert(head.getNext().getNext().getNext().countReachableNodes() == 1);
    }

}
