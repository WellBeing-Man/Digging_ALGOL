import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import List.*;

import org.junit.Before;
import org.junit.Test;
public class mArrayListTest {

    protected List<Integer> mylist;
    protected List<Integer> list;



    @Before
    public void setup() throws Exception{
        list=new mArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);


    }

    @Test
    public void testSize(){
        assertThat (list.size(), is(3));
    }

    @Test
    public void addIntT(){
        for(int i=4;i<20;i++){
            list.add(i);
            assertThat(list.get(list.size()-1),is(i));
        }

    }

    @Test
    public void testIndexAddIntiT(){
        list.add(1,5);
        assertThat(list.get(1),is(5));
        assertThat(list.size(),is(4));

        try {
            list.set(-1,0);
            fail();
        }catch (IndexOutOfBoundsException e){}

        try {
            list.set(4,0);
            fail();
        }catch (IndexOutOfBoundsException e){}

        list.add(0,6);
        assertThat(list.get(0),is(6));
        list.add(5,7);
        assertThat(list.get(5),is(7));
    }

    @Test
    public void isEmptyTest(){
        assertThat(list.isEmpty(),is(false));
        list.removeAll(list);
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void containsTest(){
        assertThat(list.contains(1),is(true));
        assertThat(list.contains(55),is(false));
    }

    @Test
    public void toArrayTest(){
        Object[] listArray = list.toArray();

        assertThat(listArray[0],is(1));
        assertThat(listArray[1],is(2));
        assertThat(listArray[2],is(3));
    }


    @Test
    public void removeTest(){
        list.remove(new Integer(1));
        assertThat(list.contains(1),is(false));
        assertThat(list.size(),is(2));
        assertThat(list.get(1),is(3));

        list.remove(0);
        assertThat(list.get(0),is(3));
        assertThat(list.size(),is(1));

    }

    @Test
    public void indeOflastTest(){
        list.add(1);
        assertThat(list.lastIndexOf(1),is(3));

        list.add(2);
        list.add(2);
        assertThat(list.lastIndexOf(2),is(5));

    }

    @Test
    public void subListTest(){
        list.add(4);
        list.add(5);
        List subList=list.subList(1,3);

        assertThat(subList.size(),is(3));
        assertThat(subList.get(0),is(2));
        assertThat(subList.get(2),is(4));
    }
}
