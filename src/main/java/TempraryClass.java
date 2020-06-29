import java.util.ArrayList;

public class TempraryClass {
    public long solution(int N) {

        long answer=0;
        long[] history=new long[N];
        history[0]=1;
        history[1]=1;
            for(int i=2;i<N;i++){
                history[i]=history[i-1]+history[i-2];
            }
            answer=(history[history.length-1]+history[history.length-2])*2+
                    (history[history.length-2]+history[history.length-3])*2;
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(new TempraryClass().solution(5));
    }
}
