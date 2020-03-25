package Stack;

public class StackNode<E> {
    StackNode<E> down;
    E data;

    public StackNode(E data) {
        this.data = data;
    }
}
