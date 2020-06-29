import Sorting.Bubble;
import Sorting.mSorting;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
public class BubbleSortingTest {
    mSorting sorting;

    @Before
    public void setup(){
        int[] array={5,4,3,2,1};
        sorting=new Bubble(array);
    }

    @Test
    public void ascendingTest(){
        int[] after={1,2,3,4,5};
        assertThat(sorting.ascending(),is(after));

        int[] before={7,3,5,6,2,1};
        after= new int[]{1, 2, 3, 5, 6, 7};
        sorting=new Bubble(before);
        assertThat(sorting.ascending(),is(after));


    }

    @Test
    public void descendingTest(){
        int[] before={1,2,3,4,5};
        int[] after={5,4,3,2,1};
        sorting=new Bubble(before);
        assertThat(sorting.descending(),is(after));

        before= new int[]{4,2,7,5,8,1,6};
        after= new int[]{8,7,6,5,4,2,1};
        sorting=new Bubble(before);
        assertThat(sorting.descending(),is(after));

    }
}
