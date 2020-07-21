package tree;

public class mBTN<E> {
    mBTN left,right;
    private E data;
    int key;

    public mBTN(E data) {
        right=left=null;
        this.data = data;
    }

    public mBTN(E data, int key) {
        this.data = data;
        this.key = key;
    }

    public E getNode(){
        return data;
    }

}
