package BruteForce;


//programmers problem
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer=new int [2];

        int sum=brown+yellow;

        for(int row=sum;row>0;row--){
            if(sum%row ==0) {
                int column = sum / row;
                if((column+row)*2 -4 ==brown){
                    answer[0]=column;
                    answer[1]=row;
                }

            }

        }


        return answer;
    }

}
