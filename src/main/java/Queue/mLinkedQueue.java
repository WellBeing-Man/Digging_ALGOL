package Queue;

public class mLinkedQueue implements Queue {

    QueueNode head,tail;
    int count;

    public mLinkedQueue() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public void add(Object item) {
        QueueNode node=new QueueNode(item);
        if(isEmpty()){
            head=node;
            tail=head;
            count++;
        }else{
            tail.next=node;
            tail=node;
            count++;
        }
    }

    @Override
    public Object remove() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        QueueNode temp=head;
        Object tempdata=temp.data;
        head=head.next;
        temp=null;
        return tempdata;
    }

    @Override
    public boolean isEmpty() {
        return equals(head,null);
    }

    private boolean equals(Object t, Object o) {
        if(t==null){
            return t==o;
        }else{
            return t.equals(o);
        }
    }

    @Deprecated
    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Object get(int index) {
        QueueNode node=head;
        for(int i=0;i<count;i++){
            if(i==index) {
                return node.data;
            }
            node=node.next;
        }
        return null;
    }
}