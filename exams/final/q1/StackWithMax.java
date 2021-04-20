import java.util.List;
import java.util.ArrayList;

public class StackWithMax<T extends Comparable<T>> {

    private List<T> s1;

    private List<T> s2;

    // creates an empty stack
    public StackWithMax() {
        this.s1 = new ArrayList<>();
        this.s2 = new ArrayList<>();
    }

    // adds a new element to the stack
    public void push(T item) {
        s1.add(0, item);
        T max = (!s2.isEmpty() && item.compareTo(s2.get(0)) < 0) ? s2.get(0) : item;
        s2.add(0, max);
    }

    // removes the element from top and returns it
    public T pop() {
        s2.remove(0);
        return s1.remove(0);
    }

    // returns the maximum of the stack (without modifying stack)
    public T getMax() {
        return s2.get(0);
    }

    // returns the number of elements in the stack
    public int size() {
        return s1.size();
    }

    // check if the stack is empty
    public boolean isEmpty() {
        return s1.isEmpty();
    }

}
