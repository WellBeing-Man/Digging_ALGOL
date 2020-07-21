import sorting.Insert;

public class InsertSortingTest extends BubbleSortingTest {
    @Override
    public void setup(){
        int[] array={5,4,3,2,1};
        sorting=new Insert(array);
    }
}
