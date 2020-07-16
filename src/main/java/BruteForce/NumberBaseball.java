package BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NumberBaseball {


    public int solution(int[][] balls) {
        ArrayList possible=new ArrayList();

        Arrays.sort(balls, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]-o2[1]<0){
                    return o1[2]-o2[2];
                }else

                return o1[1]-o2[2];
            }
        });

        getPossible(balls,0,possible);

        return possible.size();
    }

    private void getPossible(int[][] balls,int now, ArrayList possible) {

        if(now>balls.length){
            possible.add(now);
            return;
        }


        while (true){
            String throwing="";
        //    throwing+=getStrike(balls[now],);
        }




    }


}
