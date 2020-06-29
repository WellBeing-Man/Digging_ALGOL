package Queue;

public class ArrayQueue implements Queue {
    int[] queue;
    int size;
    int head,tail;

    public ArrayQueue(int size) {
        this.size = size;
        queue=new int[size];
        head=0;
        tail=0;
    }

    @Override
    public void add(Object item) {
        if(isFull()){
            throw new IndexOutOfBoundsException();
        }
        tail++;
        queue[tail]=(int)item;
    }

    @Override
    public Object remove() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int r=queue[head];
        queue[head]=-99999;
        head++;
        return r;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return tail==7;
    }

    @Override
    public Object get(int index) {
        return queue[index];
    }
}
