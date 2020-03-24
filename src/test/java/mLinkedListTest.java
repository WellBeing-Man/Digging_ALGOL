import List.LinkedList.mLinkedList;

import static org.junit.Assert.assertThat;

public class mLinkedListTest extends mArrayListTest{
    @Override
    public void setup() throws Exception {
        list=new mLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

}
