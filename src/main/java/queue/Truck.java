package queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;


//programers
public class Truck {
    private class DumpTruck{
        private int position;
        private int weight;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getWeight() {
            return weight;
        }

        public DumpTruck(int weight) {
            position=0;
            this.weight = weight;
        }

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<DumpTruck> wait=new ArrayDeque();
        Queue<DumpTruck> bridge=new ArrayDeque();
        Queue<DumpTruck> arrived=new ArrayDeque();
        int brigeWeight=0;

        for(int i=0;i<truck_weights.length;i++){
            wait.add( new DumpTruck(truck_weights[i]) );
        }

        while (arrived.size()!=truck_weights.length){
            moveTrcuks(bridge);
            if(!bridge.isEmpty() && bridge.peek().getPosition()>bridge_length){
                DumpTruck dumpTruck=bridge.poll();
                brigeWeight-=dumpTruck.getWeight();
                arrived.add(dumpTruck);
            }

            if(!wait.isEmpty() && brigeWeight+wait.peek().getWeight()<=weight){
                DumpTruck dumpTruck=wait.poll();
                dumpTruck.setPosition(0);
                bridge.add(dumpTruck);
                brigeWeight+=dumpTruck.getWeight();
            }
            answer++;
        }

        return answer;
    }

    private void moveTrcuks(Queue<DumpTruck> bridge) {
    Iterator iterator=bridge.iterator();
    while (iterator.hasNext()){
        DumpTruck dumpTruck= (DumpTruck) iterator.next();
        dumpTruck.setPosition(dumpTruck.getPosition()+1);
    }
    }


}
