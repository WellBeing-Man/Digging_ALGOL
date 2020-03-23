import List.mLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
public class mLinkedListTest extends mArrayListTest{
    @Override
    public void setup() throws Exception {
        list=new mLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

}
