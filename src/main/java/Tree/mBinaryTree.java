package Tree;

public class mBinaryTree<E>{
    mBTN root;

    public mBinaryTree() {
        this.root = null;
    }

   public void add(E item){
        mBTN node=root;
        if(node==null){
            root=new mBTN(item);
        }else if(node.left==null){
            node=node.left;
        }else{
            node=node.right;
        }
   }



}
