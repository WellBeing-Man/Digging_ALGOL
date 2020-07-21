package sorting;

import java.util.Arrays;

//Programmers Solution
class Solution {


    public int solution(int[] citations) {

        Arrays.sort(citations);

        int score=0;
         for(int i=0;i<citations.length;i++){
            int temp=0;
            for(int j=0;j<=i;j++){
                if(score+1<=citations[j]){
                    temp++;
                }
            }
            if(temp>=score+1){
                score++;
            }
        }

        return score;
    }
}