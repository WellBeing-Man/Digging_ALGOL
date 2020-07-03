package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;


//programmers Problem
public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilleQueue=new PriorityQueue();
        Arrays.sort(scoville);

        //Min Heap
        for(int i=0;i<scoville.length;i++){
            if(scoville[i]<K)
            scovilleQueue.add(scoville[i]);
        }

        while (!scovilleQueue.isEmpty()){

            if(scovilleQueue.peek()<K){
                int first=scovilleQueue.poll();
                int second=scovilleQueue.poll();
                int newFood=first + (second * 2);
                scovilleQueue.add(newFood);
                answer++;
            }else{
                scovilleQueue.poll();
            }

            if(scovilleQueue.size()==1 && scovilleQueue.peek()<K){
                return -1;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a={1, 2, 3, 9, 10, 12};
        new Scoville().solution(a,7);
    }
}
