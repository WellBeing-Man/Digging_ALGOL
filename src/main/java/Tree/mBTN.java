package Tree;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class mTreeNode<E> implements TreeNode{
    mTreeNode left,right;
    E data;

    public mTreeNode(E data) {
        right=left=null;
        this.data = data;
    }


    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return null;
    }
}
