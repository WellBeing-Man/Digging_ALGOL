package heap;

import java.util.*;

//programmers
public class FlourFactory {

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> supplyQueue=new PriorityQueue(Collections.reverseOrder());
        int index=0;

        for(int i=0;i<k;i++){
            if(index<dates.length) {
                if (i == dates[index]) {
                    supplyQueue.add(supplies[index]);
                    index++;
                }
            }
            if(stock-i<=0){
                stock+=supplyQueue.poll();
                answer++;
            }

        }

        return answer;
    }

}
