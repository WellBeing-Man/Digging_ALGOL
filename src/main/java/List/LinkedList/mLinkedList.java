package List.LinkedList;

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
        for(int i=0;i<size;i++){
            if(equals(o,node.data)){
                return i;
            }
            node=node.next;
        }
        return -1;
    }

    private boolean equals(Object o, Object data) {
        if(o==null){
            return o==data;
        }else {
            return o.equals(data);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)!=-1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array=(E[]) new Object[size];
        ListNode node=head;
        for(int i=0;i<size;i++){
            array[i]=node.data;
            node=node.next;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        int index=indexOf(o);
        if(index==-1){
            return false;
        }else {
            remove(index);
            return true;
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
        boolean flag=false;
        for(Object object:c.toArray()){
            remove(object);
        }
        return flag;
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
        ListNode node=getNode(index);
        return (E)node.data;
    }


    @Override
    public E set(int index, E element) {
        ListNode node=getNode(index);
        node.data=element;
        return (E)node.data;
    }

    @Override
    public void add(int index, E element) {
        ListNode newNode=new ListNode(element);
        if(index==0){
            newNode.next=head;
            head=newNode;
            size++;
        }else{
        ListNode node=getNode(index-1);
        newNode.next=node.next;
        node.next=newNode;
        size++;
        }
    }

    @Override
    public E remove(int index) {
        E value;
        ListNode delnode;
        if(index==0){
            value=(E)head.data;
            delnode=head;
            head=head.next;
            delnode=null;
            size--;
            return value;
        }
        else {
            ListNode node = getNode(index - 1);
            delnode = node.next;
            value = (E) delnode.data;
            node.next = node.next.next;
            delnode = null;
            size--;
            return value;
        }
    }



    @Override
    public int lastIndexOf(Object o) {
        int index=-1;
        ListNode node=head;
        for(int i=0;i<size;i++){
            if(node.data==o){
                index=i;
            }
            node=node.next;
        }
        return index;
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
        mLinkedList<E> subList=new mLinkedList<E>();

        while(fromIndex<=toIndex){
            subList.add(get(fromIndex++));
        }
        return subList;
    }

    private ListNode getNode(int index) {
        if(index<0 || index>size-1){
            throw new IndexOutOfBoundsException();
        }
        ListNode node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }

}
