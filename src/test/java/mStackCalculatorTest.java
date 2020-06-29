import Stack.mStackCalculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class mStackCalculatorTest {
    mStackCalculator mStackCalculator;
    @Before
    public void setup(){
        String expression="132*-";
        mStackCalculator=new mStackCalculator(expression);
        mStackCalculator.calculating();
    }

    @Test
    public void setupTest(){
        assertThat(mStackCalculator.getResult(),is(-5));
    }

    @Test
    public void variousTest(){
        String expression="15+";
        mStackCalculator=new mStackCalculator(expression);
        mStackCalculator.calculating();
        assertThat(mStackCalculator.getResult(),is(6));


        expression="26-";
        mStackCalculator=new mStackCalculator(expression);
        mStackCalculator.calculating();
        assertThat(mStackCalculator.getResult(),is(-4));


        expression="15-26*+";
        mStackCalculator=new mStackCalculator(expression);
        mStackCalculator.calculating();
        assertThat(mStackCalculator.getResult(),is(8));


        expression="42/42*+";
        mStackCalculator=new mStackCalculator(expression);
        mStackCalculator.calculating();
        assertThat(mStackCalculator.getResult(),is(10));
    }
}
