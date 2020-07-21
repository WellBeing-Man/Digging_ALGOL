package bruteforce;

import java.util.Arrays;
import java.util.Comparator;

public class NumberGame {

    public int solution(int[] A, int[] B) {
        Integer[] a=new Integer[A.length];
        Integer[] b=new Integer[B.length];
        for(int i=0;i<a.length;i++){
            a[i]=A[i];
            b[i]=B[i];
        }
        Arrays.sort(a,Comparator.reverseOrder());
        Arrays.sort(b,Comparator.reverseOrder());

        int answer=playGame(a,b);
        return answer;
    }
    public int playGame(Integer[] ATeam, Integer[] BTeam){
        int result=0;
        int j=0;
        for(int i=0;j<BTeam.length;i++){
                    while (j<ATeam.length){
                        if(BTeam[i]>ATeam[j++]) {
                            result++;
                            i++;
                            continue;
                        }

                    }
        }
        return result;

    }


}
