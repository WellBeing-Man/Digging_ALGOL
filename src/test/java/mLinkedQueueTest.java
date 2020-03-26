import org.junit.Before;
import Queue.mLinkedQueue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
public class LinkedQueueTest {
    mLinkedQueue myQueue;
    @Before
    public void setup(){
        myQueue=new mLinkedQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
    }

    @Test
    public void setTest(){
        assertThat(myQueue.get(0),is(1));
        assertThat(myQueue.get(1),is(2));
        assertThat(myQueue.get(2),is(3));
        assertThat(myQueue.get(3),is(4));

    }
}
