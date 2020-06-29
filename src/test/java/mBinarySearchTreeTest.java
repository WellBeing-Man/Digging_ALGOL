import Tree.mBTN;
import Tree.mBinarySearchTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

public class mBinarySearchTreeTest {
    mBinarySearchTree<String> myTree;

    @Before
    public void setup(){
        mBTN<String> root=new mBTN("a",10);
        myTree=new mBinarySearchTree<>(root);
        myTree.add("b", 5);
        myTree.add("c", 15);
        myTree.add("d", 3);
        myTree.add("e", 13);
        myTree.add("f",7);
        myTree.add("g",17);

    }
    @Test
    public void setupTest(){
        myTree.printInoder(myTree.getRoot());  //it should be "abdfceg"
        System.out.println(" setupTest");
    }

    @Test
    public void deleteTest(){
        assertThat(myTree.remove(10),is("a"));
        myTree.printInoder(myTree.getRoot());  /// it should be "ebdfcg"
        System.out.println(" deleteTest");
        try {
            myTree.remove(1);
            fail();
        }catch (NullPointerException e){}
    }

    @Test
    public void addTest(){
        assertThat(myTree.add("h",2),is(true));
        assertThat(myTree.add("i",6),is(true));
        assertThat(myTree.add("j",2),is(false));
        myTree.printInoder(myTree.getRoot());           // it should be "ebdhifceg"
        System.out.println(" addTest");


    }
}
