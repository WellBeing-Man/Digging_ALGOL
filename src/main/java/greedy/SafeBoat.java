package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
//programmers
public class SafeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        LinkedList<Integer> list= new LinkedList<>();
        for(int p:people){
            list.add(p);
        }
        int weight=0;
        while (!list.isEmpty()){
            weight=list.pollLast();
            answer++;
                    while (!list.isEmpty() && weight+list.peekFirst()<=limit){
                            weight+=list.pollFirst();
                    }

        }

        return answer;
    }

    public static void main(String[] args) {
        new SafeBoat().solution(new int[]{70, 50, 80,50},100);
    }
}
