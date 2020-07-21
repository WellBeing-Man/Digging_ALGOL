package list;

import list.doublelinkedlist.mDoubleLinkedList;
import list.linkedList.mLinkedList;
import org.jfree.data.xy.XYSeries;

import java.util.List;

public class ProfilerListAdd {
    public static void main(String[] args){

      //  profileArrayListAddEnd();
      //  profileArrayListAddBeggining();
      //  profileLinkedListAddEnd();
    //    profileLinkedListAddBeggining();
       profileDoubleLinkedListAddBeggining();
      // profileDoubleLinkedListAddEnd();

    }

    private static void profileDoubleLinkedListAddEnd() {
        Profiler.Timeable timeable=new Profiler.Timeable() {
            List<Integer> list;
            @Override
            public void setup(int n) {
                list=new mDoubleLinkedList<>();
            }

            @Override
            public void timeMe(int n) {
                for(int i=0;i<n;i++){
                    list.add(i);
                }
            }
        };

        String title="Double LinkedList add end";
        Profiler profiler=new Profiler(title,timeable);

        int starN=4000;
        int endMillis=1000;
        XYSeries series=profiler.timingLoop(starN,endMillis);
        profiler.plotResults(series);

    }

    private static void profileDoubleLinkedListAddBeggining() {
        Profiler.Timeable timeable=new Profiler.Timeable() {
            List<Integer> list;
            @Override
            public void setup(int n) {
                list=new mDoubleLinkedList<>();
            }

            @Override
            public void timeMe(int n) {
                for(int i=0;i<n;i++){
                    list.add(0,i);
                }
            }
        };

        String title="DoubleLinkedList add begin";
        Profiler profiler=new Profiler(title,timeable);

        int starN=4000;
        int endMillis=1000;
        XYSeries series=profiler.timingLoop(starN,endMillis);
        profiler.plotResults(series);
    }

    private static void profileLinkedListAddBeggining() {
        Profiler.Timeable timeable=new Profiler.Timeable() {
            List<Integer> list;
            @Override
            public void setup(int n) {
                list=new mLinkedList<Integer>();
            }

            @Override
            public void timeMe(int n) {
                for(int i=0;i<n;i++){
                    list.add(0,i);
                }
            }
        };

        String title="LinkedList add begin";
        Profiler profiler=new Profiler(title,timeable);

        int starN=4000;
        int endMillis=100;
        XYSeries series=profiler.timingLoop(starN,endMillis);
        profiler.plotResults(series);
    }

    private static void profileLinkedListAddEnd() {
        Profiler.Timeable timeable=new Profiler.Timeable() {
            List<Integer> list;
            @Override
            public void setup(int n) {
                list=new mLinkedList<Integer>();
            }

            @Override
            public void timeMe(int n) {
                for(int i=0;i<n;i++){
                    list.add(i);
                }
            }
        };

        String title="LinkedList add end";
        Profiler profiler=new Profiler(title,timeable);

        int starN=4000;
        int endMillis=1000;
        XYSeries series=profiler.timingLoop(starN,endMillis);
        profiler.plotResults(series);
    }

    private static void profileArrayListAddBeggining() {

        Profiler.Timeable timeable=new Profiler.Timeable() {
            List<Integer> list;
            @Override
            public void setup(int n) {
                list=new mArrayList<Integer>();
            }

            @Override
            public void timeMe(int n) {
                for(int i=0;i<n;i++){
                    list.add(0,i);
                }
            }
        };

        String title="ArrayList add begin";
        Profiler profiler=new Profiler(title,timeable);

        int starN=4000;
        int endMillis=1000;
        XYSeries series=profiler.timingLoop(starN,endMillis);
        profiler.plotResults(series);
    }

    public static void profileArrayListAddEnd(){
        Profiler.Timeable timeable= new Profiler.Timeable() {
            List<String> list;
            @Override
            public void setup(int n) {
                list=new mArrayList<String>();
            }

            @Override
            public void timeMe(int n) {
                    for(int i=0;i<n;i++){
                        list.add("a String");

                    }

            }
        };

        String title="ArrayList add end";
        Profiler profiler=new Profiler(title,timeable);

        int starN=4000;
        int endMillis=1000;
        XYSeries series=profiler.timingLoop(starN,endMillis);
        profiler.plotResults(series);
    }
}
