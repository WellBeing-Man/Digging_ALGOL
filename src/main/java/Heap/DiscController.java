package Heap;

import java.util.*;

//programmers  done!
public class DiscController{
    public int solution(int[][] jobs) {
        int answer = 0;
        int time=0;
        int next=0;
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<int[]>(((o1, o2) -> o1[1]-o2[1]));
        Arrays.sort(jobs,((o1, o2) -> o1[0]-o2[0]));



        while (next<jobs.length || !priorityQueue.isEmpty()){
            while (next<jobs.length && jobs[next][0]<=time){
                priorityQueue.offer(jobs[next++]);
            }

            if(!priorityQueue.isEmpty()){
                int[] job=priorityQueue.poll();
                answer+=((time-job[0]) + job[1]);
                time+=job[1];
                job=null;
                continue;
            }else {
                time=jobs[next][0];
            }
        }
        return answer/jobs.length;
    }
    
}
