package stack;

public class mLinkedStack<E> implements Stack<E>{

    int capacity;
    StackNode<E> top;

    public mLinkedStack(int capacity) {
        this.capacity = capacity;
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public void push(E item) {
        if(isFull()){
            throw new IndexOutOfBoundsException();
        }

        StackNode newNode=new StackNode(item);
        if(equals(top,null)){
            top=newNode;
        }else{
            newNode.down=top;
            top=newNode;
        }

    }

    @Override
    public boolean isFull() {
        return capacity==countNode();
    }

    @Override
    public E pop() {
        StackNode temp=top;
        E tempdata=(E) temp.data;
        top=top.down;
        temp=null;
        return tempdata;
    }

    @Override
    public void delete() {
        StackNode temp=top;
        top=top.down;
        temp=null;
    }

    @Override
    public E peek() {
        return top.data;
    }

    private int countNode(){
        StackNode node=top;
        int count=0;
        if(top==null){
         return count;
        }else {
            for (; node.down != null; node = node.down) {
                count++;

            }
            return count;
        }
    }
    private boolean equals(Object t, Object o){
        if(t==null){
            return t==o;
        }else{
            return t.equals(o);
        }
    }
}
