import Stack.mLinkedStack;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class mLinkedStackTest extends mArrayStackTest {
    @Test
    public void setup() {

        myStack=new mLinkedStack<Integer>(10);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

    }

    @Override
    public void testPop() {
        assertThat(myStack.pop(),is(3));
        assertThat(myStack.pop(),is(2));
        assertThat(myStack.pop(),is(1));
        try{
            myStack.peek();
            fail();
        }catch (NullPointerException e){}
    }

    @Override
    public void testPeek() {
        assertThat(myStack.peek(),is(3));
        myStack.delete();
        assertThat(myStack.peek(),is(2));
        myStack.delete();
        assertThat(myStack.peek(),is(1));
        try {
            myStack.delete();
            myStack.peek();
            fail();

            myStack.delete();
            fail();

        }catch (NullPointerException e){}
    }
}
