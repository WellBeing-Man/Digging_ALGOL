package Heap;

import java.util.*;

//programmers  not done yet!
public class DiscController{
    private class Request{
        int time;
        int exec;

        public Request(int time, int exec) {
            this.time = time;
            this.exec = exec;
        }

        public int getTime() {
            return time;
        }

        public int getExec() {
            return exec;
        }
    }

    public int solution(int[][] jobs) {
        int answer=0;
        PriorityQueue<Request> requestQueue=new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Request r1=(Request)o1;
                Request r2=(Request)o2;
                return r1.getExec()-r2.getExec();
            }
        });
        ArrayList<Request> jobList=new ArrayList<>();
        int time=0;

        for(int[] job:jobs){
            jobList.add(new Request(job[0],job[1]));
        }

        Collections.sort(jobList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Request r1=(Request) o1;
                Request r2=(Request) o2;
                int time=r1.getTime()-r2.getTime();
                int exec=r1.getExec()-r2.getExec();
                if(time<0)
                    return exec;
                 else
                     return time;
            }
        });

        while ( !(jobList.isEmpty() && requestQueue.isEmpty())){


            //insert queue
            if(!jobList.isEmpty()) {
                while (time > jobList.get(0).getTime()) {
                    requestQueue.add(jobList.get(0));
                    jobList.remove(0);
                    if (jobList.isEmpty()) {
                        break;
                    }
                }
            }


            if(requestQueue.isEmpty()){
                Request request=jobList.get(0);
                jobList.remove(request);
                time+=+request.getExec();
                answer+=request.getExec();
            }else{
                Request request=requestQueue.poll();
                answer+= (time-request.getTime()+request.getExec());
                time+=request.getExec();
            }

        }


        return answer/jobs.length;
    }


}
