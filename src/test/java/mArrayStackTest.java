import Stack.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

public class mArrayStackTest {
    protected Stack<Integer> myStack;
    @Before
    public void setup(){
        myStack=new mArrayStack<Integer>(10);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
    }

    @Test
    public void testStackSet(){
        assertThat(myStack.peek(),is(3));
        assertThat(myStack.pop(),is(3));
        assertThat(myStack.pop(),is(2));
        assertThat(myStack.pop(),is(1));
    }

    @Test
    public void testPush(){
        try{
            myStack.push(1);
            myStack.push(1);
            myStack.push(1);
            myStack.push(1);
            myStack.push(1);
            myStack.push(1);
            myStack.push(1);
            myStack.push(1);
            myStack.push(1);
            fail();
        }catch (IndexOutOfBoundsException e){ }
    }
}
