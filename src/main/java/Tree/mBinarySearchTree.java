package Tree;


// Binary Search Tree written by LDG
// Dusty code... Sorry
public class mBinarySearchTree<E>  {


    mBTN root;

    public mBinarySearchTree(mBTN root) {
        this.root = root;
    }

        //Search by key
    public mBTN search(int key){
        mBTN node=root;
        while(node!=null) {
            if(node.key==key){
                return node;
            }else if(node.key> key){
            }else {
                node=node.right;
            }
                    }
        return null;
    }

    //Add method returning boolean
    public boolean add(E data, int key){
        mBTN curNode=root;
        mBTN parent = null;
        mBTN newNode=new mBTN(data, key);

        while (curNode!=null){
            if(curNode.key==key){
                return false;
            }else if(curNode.key>key){
                parent=curNode;
                curNode=curNode.left;
            }else{
                parent=curNode;
                curNode=curNode.right;
            }
        }

        if(parent.key<key){
            parent.right=newNode;
        }else{
            parent.left=newNode;
        }

        return true;
    }


    //The hardest part
   public E remove(int key){
        mBTN node=root;
        mBTN parent=getParent(node);       //find parent
        boolean isLeft=false;               //it is direction from parent

        E tempdata;

        if(root==null || search(key)==null){                     //case of non-root and none-key
            throw new NullPointerException();
        }
        while (node.key!=key){          //find parent and direction
            parent=node;
            if(node.key>key) {
                isLeft=true;
                node=node.left;
            }else if(node.key<key){
                isLeft=false;
                node=node.right;
            }else{
                return null;
            }
        }

        int childCase=howManySubtree(node);         // there are three cases of subtree
        switch (childCase){

            case 0 :
                tempdata=(E)node.getNode();         //easy one
                node=null;
                break;

            case 1:
                tempdata=(E)node.getNode();         //need to know direction and current node's child
                if(isLeft && node.left!=null){
                    parent.left=node.left;
                }else if(isLeft && node.right!=null){
                    parent.left=node.right;
                }else if(!isLeft&&node.left!=null){
                    parent.right=node.left;
                }else{
                    parent.right=node.right;
                }
                break;

            case 2:
                tempdata=(E)node.getNode();
                mBTN minNode=findMinkeyNode(node);              //should find minimum node on right child
                if(node==root){
                    minNode.left=root.left;
                    minNode.right=root.right;
                    root=minNode;
                }
                else if(isLeft){
                    parent.left=minNode;
                    minNode.left=node.left;
                    minNode.right=node.right;
                }else{
                    parent.right=minNode;
                    minNode.left=node.left;
                    minNode.right=node.right;
                }
            default:
                tempdata=(E)node.getNode();
        }

            return tempdata;

   }

    private mBTN findMinkeyNode(mBTN node) {            // finding minimum
        mBTN targetNode=node.right;
        mBTN parnt=null;
        while (targetNode.left!=null){
            parnt=targetNode;
            targetNode=targetNode.left;
        }
        parnt.left=null;

        return targetNode;

    }


    private int howManySubtree(mBTN node) {         //counting how many subtrees are

        if(node.left==null && node.right==null){
            return 0;
        }else if(node.right!=null && node.left==null){
            return 1;
        }else if(node.right==null && node.left!=null){
            return 1;
        }else{
            return 2;
        }

    }

    private mBTN getParent(mBTN node) {     //finding parent same mechanism of add
     int targetKey=node.key;
     mBTN currnetNode=node;
     mBTN parent=null;

     while(currnetNode!=null){
         if(currnetNode.key==targetKey){
             return null;
         }else if(node.key> targetKey){
             parent=node;
             node=node.left;
         }else {
             parent=node;
             node=node.right;
         }
     }
     return parent;
    }

    public void printInoder(mBTN node){
            if(node!=null) {
                System.out.print(node.getNode());
                printInoder(node.left);
                printInoder(node.right);
            }
    }

    public mBTN getRoot(){
        return root;
    }

}
