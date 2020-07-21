package list.doublelinkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class mDoubleLinkedList<E> implements List<E> {

    DoubleLinkNode head;
    DoubleLinkNode tail;
    int size;

    public mDoubleLinkedList() {
        this.head = null;
        this.tail=null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean add(E e) {

        if(head==null){
            head=new DoubleLinkNode(e);
            tail=head;
            size++;
            return true;
        } else if(equals(tail,head)){
            tail=new DoubleLinkNode(e);
            head.next=tail;
            tail.before=head;
            size++;
            return true;
        }else{
            DoubleLinkNode newNode=new DoubleLinkNode(e);
            newNode.before=tail;
            tail.next=newNode;
            tail=newNode;
            size++;
            return true;
        }

    }


    @Override
    public int indexOf(Object o) {
        DoubleLinkNode node=head;
        for (int i = 0; i<size;i++){
            if(equals(o,node.data)){
                return i;
            }
        }
        return -1;
    }

    private boolean equals(Object o, Object t) {
    if(o==null) {
        return o==null;
    }
    else{
        return o.equals(t);
    }
    }

    private DoubleLinkNode getNode(int index){

        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException();
        }
        DoubleLinkNode node=head;
            for(int i=0;i<index;i++){
                node=node.next;
            }

        return node;
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
        DoubleLinkNode node=head;
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
        }else{
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

    }

    @Override
    public E get(int index) {
        DoubleLinkNode node=getNode(index);
        return (E)node.data;
    }

    @Override
    public E set(int index, E element) {
        DoubleLinkNode node=getNode(index);
        Object old=node.data;
        node.data=element;

        return (E)old;
    }

    @Override
    public void add(int index, E element) {
        DoubleLinkNode newNode=new DoubleLinkNode(element);
        if(index==0){
            if(size==0){
                add(element);
            }else{
            newNode.next=head;
            head=newNode;
            newNode.next.before=newNode;
            size++;}
        }else if(index==size){
             add(element);
        }else{
            DoubleLinkNode node=getNode(index);
            node.before.next=newNode;
            newNode.before=node.before;
            newNode.next=node;
            node.before=newNode;
            size++;
        }
    }

    @Override
    public E remove(int index) {
        DoubleLinkNode node=getNode(index);
        DoubleLinkNode temp;
        E tempdata;
        if(node==null){
            return null;
        }else if(index==0){
            temp=head;
            head=head.next;
            tempdata=(E)temp.data;
            temp=null;
            size--;
            return tempdata;
        }
        else if(index==size-1){
            temp=tail;
            tail.before.next=null;
            tempdata=(E)temp.data;
            temp=null;
            size--;
            return tempdata;
        }
        else{
            node.before.next=node.next;
            node.next.before=node.before;
            temp=node;
            tempdata=(E)temp.data;
            temp=null;
            size--;
            return tempdata;
        }
    }



    @Override
    public int lastIndexOf(Object o) {
        int index=-1;
        DoubleLinkNode node=head;
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
        mDoubleLinkedList<E> subList=new mDoubleLinkedList<>();

        while(fromIndex<=toIndex){
            subList.add(get(fromIndex++));
        }
        return subList;
    }
}
