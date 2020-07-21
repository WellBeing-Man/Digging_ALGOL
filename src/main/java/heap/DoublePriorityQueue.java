package heap;

import java.util.Collections;
import java.util.PriorityQueue;


//programmers
public class DoublePriorityQueue {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> reverse=new PriorityQueue();
        PriorityQueue<Integer> queue=new PriorityQueue(Collections.reverseOrder());


        for(String s:operations){
            if(s.contains("I")){
                int input= Integer.parseInt(s.substring(2));
                queue.add(input);
                reverse.add(input);
            }else if(!queue.isEmpty()) {
                if (s.contains("D 1")) {
                    int pop = queue.poll();
                    reverse.remove(pop);
                } else {
                    int pop = reverse.poll();
                    queue.remove(pop);
                }
            }
        }


        if(queue.isEmpty()){
            answer[0]=0;
        }else {
            answer[0] = queue.poll();
        }
        if(reverse.isEmpty()){
            answer[1]=0;
        }else {
            answer[1] = reverse.poll();
        }

        return answer;
    }



}
