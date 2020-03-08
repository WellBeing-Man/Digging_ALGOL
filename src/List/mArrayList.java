package List;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class mArrayList<E> implements List<E>{

    int size;
    private E[] array;

    public mArrayList() {
        this.size = 0;
        this.array = (E[]) new Object[10];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(this.size==0){
        return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
    public boolean add(E e) {
        if(size>array.length){
            E[] bigger= (E[]) new Object[array.length*2];
            System.arraycopy(array,0,bigger,0,array.length);
            array=bigger;
        }
        array[size]=e;
        size++;
        return true;
    }

    @Override
        public boolean remove(Object o) {
            int index=indexOf(o);
            if(index==-1) {
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
        System.out.println(Boolean.TRUE.toString());
        System.out.println(Boolean.FALSE.toString());
        boolean flag=false;
        for(Object object:c){
            flag |=remove(object);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.array=null;
        size=0;
    }

    @Override
    public E get(int index) {
        if(index<0 || index>=array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }else {
            return array[index];
        }
    }

    @Override
    public E set(int index, E element) {
        if(index<0 || index>=this.size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            array[index]=element;
            return element;
        }
    }

    @Override
    public void add(int index, E element) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }else{
            add(element);

            for(int i=size-1;i<index;i--){
                array[i]=array[i-1];
            }
            set(index,element);

        }

    }

    @Override
    public E remove(int index) {
        E old=get(index);
        if(isOutofBound(index)){
            return null;
        }
        else{

            for(int i=index;i<size-1;i++){
                array[i]=array[i+1];
            }
            size--;
            return old;
        }
    }

    @Override
    public int indexOf(Object o) {
        int position=0;
        for(Object t: array){
                if(equals(t,o)){
                    return position;
                }
                position++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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

    private boolean equals(Object target, Object element){
        if(target==null) {
            return element == null;
        }else {
            return target.equals(element);
        }
    }

    private boolean isOutofBound(int position){
        if(position<0||position>=size){
            return true;
        }else
            return false;
    }
}

