package Queue;

public class mCircularlQueue<E> implements Queue<E>{
    private int capacity;
    private int head,tail;
    private E[] circularQueue;

    public mCircularlQueue(int capacity) {
        this.capacity = capacity+1;
        circularQueue=(E[]) new Object[capacity];
        head=0;
        tail=0;
    }

    @Override
    public void add(E item) {
        if(isFull()){
            throw new IndexOutOfBoundsException();
        }
        else if(isEmpty()){
            circularQueue[head]=item;
            tail++;
        }else{
            circularQueue[tail++]=item;
        }
    }

    @Override
    public E remove() {
        E temp;
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        else{
            temp=circularQueue[head];
            circularQueue[head++]=null;
        }
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return (tail+1)%capacity==head;
    }


    public E get(int index){
        return circularQueue[index];
    }
}