package Queue;

public interface Queue<E> {
    void add(E item);
    E remove();
    boolean isEmpty();
    boolean isFull();
    E get(int index);
}
