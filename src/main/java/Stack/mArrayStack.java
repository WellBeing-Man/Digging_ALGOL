package Stack;


public class mArrayStack<E> implements Stack<E> {

    private int capacity;
    private int top;
    private E[] arrayStack;

    public mArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.arrayStack = (E[])new Object[this.capacity];
    }

    @Override
    public boolean isFull() {
        return top==capacity-1;
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public void push(E item) {
        if(isFull()){
            throw new IndexOutOfBoundsException();
        }
        arrayStack[++top]=item;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        E data=null;
        data=(E) arrayStack[top];
        arrayStack[top--]=null;
        return data;
    }

    @Override
    public void delete(E item) {
        top--;
     }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return (E)arrayStack[top];
    }

    private void printStack(){
        for(int i=0;i<top;i++){
            System.out.println(arrayStack[i]);
        }
    }
}
