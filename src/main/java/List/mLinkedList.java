package List;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class mLinkedList<E> implements List<E> {

    ListNode head;
    int size;

    public mLinkedList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public boolean add(E e) {
        if(head==null){
            head=new ListNode(e);
    }
        else{
            ListNode node=head;
            for(;node.next!=null;node=node.next){}
            node.next=new ListNode(e);
        }
        size++;
        return true;
    }
    @Override
    public int indexOf(Object o) {
        ListNode node=head;
        int index=0;
        for(;node.next!=null;node=node.next){
            if(node.data==o){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        if(indexOf(o)==-1){
            return false;
        }else
        {
            return true;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        ListNode node=head;
        ListNode delnode;
        if(indexOf(o)==-1){
            return false;
        }else
        {
            for(;node.next!=null;node=node.next){
                if(node.next.data==o){
                    delnode=node.next;
                    node.next=node.next.next;
                    delnode=null;
                }
            }
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        ListNode node=head;
        while (node.next!=null){
            ListNode temp=node;
            node=node.next;
            temp=null;
        }
    }

    @Override
    public E get(int index) {
        ListNode node=head;
        int count=0;
        for(;node.next!=null;node=node.next){
            if(count==index){
                return (E)node.data;
            }
            count++;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        ListNode node=head;
        int count=0;
        for(;node.next!=null;node=node.next){
            if(count==index){
                node.data=element;
            }
            count++;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        int count=0;
        ListNode newnode=new ListNode(element);
        for(ListNode node=head;node.next!=null;node=node.next){
            if(index==count){
                newnode.next=node.next;
                node.next=newnode;
            }
            count++;
        }

    }

    @Override
    public E remove(int index) {
        ListNode node=head;
        int count=0;
        for(;node.next!=null;node=node.next){
            if(count+1==index){
                ListNode temp=node.next;
                node.next=node.next.next;
                return (E)temp.data;
            }
        }
        return null;
    }



    @Override
    public int lastIndexOf(Object o) {
        int count=0;
        ListNode node=head;
        for(;node.next!=null;node=node.next){
            if(node.data == o){
                return count;
            }
            count++;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
