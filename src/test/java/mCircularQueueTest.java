import org.junit.Before;
import Queue.*;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

public class mCircularQueueTest {
    Queue<Integer> myQueue;
    @Before
    public void setup(){
        myQueue= new mCircularlQueue<Integer>(8);

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);

    }

    @Test
    public void setupTest(){
        assertThat(myQueue.remove(),is(1));
        assertThat(myQueue.remove(),is(2));
        assertThat(myQueue.remove(),is(3));
        assertThat(myQueue.remove(),is(4));
    }
    @Test
    public void fulltest(){
        try {
            myQueue.add(5);
            myQueue.add(6);
            myQueue.add(7);
            myQueue.add(8);
            assertThat(myQueue.isFull(),is(true));
            myQueue.add(9);
            fail();
        }catch (IndexOutOfBoundsException e){}
    }
    @Test
    public void emptyTest(){
        try {
            myQueue.remove();
            myQueue.remove();
            myQueue.remove();
            myQueue.remove();
            assertThat(myQueue.isEmpty(),is(true));
            myQueue.remove();
            fail();
        }catch (IndexOutOfBoundsException e){}
    }
    @Test
    public void getTest(){
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);
        for(int i=0;i<8;i++) {
            assertThat(myQueue.get(i),is(i+1));
        }
    }

}
