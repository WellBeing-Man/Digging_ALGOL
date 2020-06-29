package BruteForce;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberBaseball {


    public void sorting(int[][] balls) {

        for(int i=1;i<balls.length;i++){
            int j=i-1;
            int[] temp=balls[i];
            while (j>=0  && balls[j][2]>temp[2]){
                balls[j+1]=balls[j];
                j--;
            }
            balls[j+1]=temp;
        }
    }
}
