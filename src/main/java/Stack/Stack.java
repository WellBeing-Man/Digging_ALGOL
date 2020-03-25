package Stack;

public interface Stack<E> {
    boolean isEmpty();
    void push(E item);
    boolean isFull();
    E pop();
    void delete(E item);
    E peek();

}
