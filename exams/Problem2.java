public class Problem2 {
    
    public class StackReverse<T> {

        class Node {
            T item;
            Node prev = null;
            Node next = null;
            Node(T item) { this.item = item; }
        }

        int length;
        Node top;
        Node bottom;
        Boolean forward;

        public StackReverse() {
            this.length = 0;
            this.top = null;
            this.bottom = null;
            this.forward = true;
        }

        public void push(T item) {
            var node = new Node(item);

            if (top == null) {
                top = node;
                bottom = node;
            }
            else if (forward) {
                top.prev = node;
                node.next = top;
                top = node;
            }
            else { // backward
                bottom.next = node;
                node.prev = bottom;
                bottom = node;
            }

            length += 1;
        }

        public T pop() { // throw Exception if empty
            T item = null;

            if (forward) {
                item = top.item;
                top = top.next;
                if (top == null) bottom = null;
                else top.prev = null;
            }
            else {
                item = bottom.item;
                bottom = bottom.prev;
                if (bottom == null) top = null;
                else bottom.next = null;
            }

            length -= 1;

            return item;
        }

        public void reverse() {
            forward = !forward;
        }

        public Boolean isEmpty() {
            return length > 0;
        }

        public int size() {
            return length;
        }
    }

}
