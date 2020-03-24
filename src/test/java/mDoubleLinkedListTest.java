import List.DoubleLinkedList.mDoubleLinkedList;

public class mDoubleLinkedListTest extends mArrayListTest {
    @Override
    public void setup() throws Exception {
        list=new mDoubleLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

    }
}
