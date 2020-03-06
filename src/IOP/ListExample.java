package IOP;

import java.util.LinkedList;
import java.util.List;

public class ListExample {
    protected List list;
    public ListExample() {
        list=new LinkedList();
    }
    private List getList() {
        return list;
    }
    public static void main(String[] args){
        ListExample listExample=new ListExample();
        List list= listExample.getList();
        System.out.println(list);
    }
}

