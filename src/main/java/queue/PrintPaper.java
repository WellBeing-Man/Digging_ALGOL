package queue;


import java.util.ArrayDeque;
import java.util.Arrays;

//programmers problem
public class PrintPaper {
    private class RotationQueue extends ArrayDeque{

        public void rotation(){
            this.add(this.poll());
        }
    }
    private class Paper{
        int order;
        int priority;

        public Paper(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }

        public int getOrder() {
            return order;
        }

        public int getPriority() {
            return priority;
        }
    }
    public int solution(int[] priorities, int location) {
        RotationQueue papers=new RotationQueue();
        int current=priorities.length-1;
        //making paper object queue
        for(int i=0;i<priorities.length;i++){
            papers.add(new Paper(i,priorities[i]));
        }
        //sort priorities
        Arrays.sort(priorities);
        while (!papers.isEmpty()){
            Paper nowPaper= (Paper) papers.peek();
            if(nowPaper.getPriority() == priorities[current]){
                papers.poll();
                current--;
                if(location==nowPaper.getOrder()){
                    break;
                }
            }else {
                papers.rotation();
            }

        }
        return priorities.length-current-1;
    }
    public static void main(String[] args) {
        int[] p={2,1,3,2};
        int locatio=2;
        new PrintPaper().solution(p,locatio);
    }
}
