package list;

import java.util.*;

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
        return indexOf(o)!=-1;
    }


    @Override
    public Object[] toArray() {
        return (E[])array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public boolean add(E e) {
        if(size>=array.length){
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
        for(Object object:c){
            if(!contains(object)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        boolean flag=true;
        for(Object element:c){
            flag&=add((E)element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag=false;
        for(Object object:c){
            flag |=remove(object);
        }
        return flag;
    }

    @Deprecated
    @Override
    public boolean retainAll(Collection<?> c) {
        throw  new UnsupportedOperationException();
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
        int index=-1;
        for(int i=0;i<array.length;i++){
            if(o==array[i]){
                index=i;
            }
        }
        return index;
    }


    @Override
    public Iterator<E> iterator() {
        E[] copy= Arrays.copyOf(array,size);

        return Arrays.asList(copy).iterator();
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
        mArrayList subList= new mArrayList();
        for(int i=fromIndex;i<=toIndex;i++){
            subList.add(array[i]);
        }
        return subList;
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

