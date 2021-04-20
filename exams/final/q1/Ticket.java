public class Ticket<T extends Comparable<T>> {

    private T value;

    public Ticket(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
    
}
