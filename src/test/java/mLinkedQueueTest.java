import org.junit.Before;
import queue.mLinkedQueue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

public class mLinkedQueueTest {
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

    @Test
    public void setAdd(){
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);

        for(int i=0;i<8;i++){
            assertThat(myQueue.get(i),is(i+1));
        }
    }

    @Test
    public void setRemove(){
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        assertThat(myQueue.isEmpty(),is(true));
        try {
            myQueue.remove();
            fail();
        }catch (IndexOutOfBoundsException e){}
    }
}
