public class Main {
    public static void main(String[] args) {

        // part a
        PriorityQueueWithDeletions<Integer> pq = new PriorityQueueWithDeletions<>();
        Ticket<Integer> t1 = pq.enqueue(5); // 5 page document (gets printed first)
        Ticket<Integer> t2 = pq.enqueue(10); // 10 page document (gets printed second)
        Ticket<Integer> t3 = pq.enqueue(8);
        Ticket<Integer> t4 = pq.enqueue(7);
        Ticket<Integer> t5 = pq.enqueue(15);
        Ticket<Integer> t6 = pq.enqueue(3);

        pq.removeByTicket(t1);
        pq.removeByTicket(t6);

        // part b
        StackWithMax<Integer> stack = new StackWithMax<>();
        stack.push(3);
        stack.push(15);
        stack.push(8);
        stack.push(12);
        stack.push(17);
        System.out.println(stack.getMax());
        System.out.println(stack.pop());
        System.out.println(stack.getMax());
        System.out.println(stack.pop());
    }
}
