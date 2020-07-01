package Queue;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//programmers problem
public class FunctionDeveloping {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> functions=new ArrayDeque();
        int day=0;
        int order=0;
        ArrayList<Integer> result = new ArrayList();
        int[] answer;
        for(int p:progresses){
            functions.add(p);
        }

        while (!functions.isEmpty()){
            int dayDone=0;
            day++;
            while (functions.peek()+ day*speeds[order] >100){
                functions.poll();
                dayDone++;
                order++;
                if(functions.isEmpty()){
                    break;
                }
            }
            if(dayDone!=0)
                result.add(dayDone);

        }

        answer=new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a={93,30,55};
        int[] b={1,30,5};
        new FunctionDeveloping().solution(a,b);
    }
}
