package stack;

import java.util.Stack;


//programmers coding-test practice
public class Tower {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack towers=new Stack();
        for(int i=0;i<heights.length;i++){
            towers.push(heights[i]);
            answer[i]=search(towers,heights[i]);
            System.out.print(answer[i]);
        }


        return answer;
    }

    private int search(Stack towers, int height) {
        Stack<Integer> t=new Stack<>();
        t.addAll(towers);
        Integer h=new Integer(height);
        while (!t.empty()){
            if(t.pop()>h){
                return t.size()+1;
            }

        }
        return 0;
    }

}
