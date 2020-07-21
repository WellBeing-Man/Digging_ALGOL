package stack;

import java.util.Stack;

//programmers problem
public class IronPipe {
    public int solution(String arrangement) {

        Stack<Character> pipes=new Stack<>();
        int answer=0;
        arrangement=arrangement.replace("()","0");
        for(int i=0;i<arrangement.length();i++) {
            char now=arrangement.charAt(i);
            if(now=='0'){
                answer+=pipes.size();
            }else if(now=='('){
                pipes.add(now);
            }else{
                pipes.pop();
                answer+=1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        new IronPipe().solution("()(((()())(())()))(())");
    }
}
