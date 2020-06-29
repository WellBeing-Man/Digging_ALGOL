import java.util.Arrays;

public class PaperZip {

    public int[] solution(int n) {
        if(n==1){
            int [] answer={0};
            return answer;
        }
        int[] answer = new int[2*n+1];
        for(int i=2;i<=n;i++){
            int[] before=new int[i-1];
            System.arraycopy(answer,0,before,0,i-1);
            before=reverse(before);
            answer[i+1]=0;
            System.arraycopy(before,0,answer,i+2,i-1);

        }
        return answer;
    }


    private int[] reverse(int[] before) {
        int[] result=new int[before.length];
        int j=0;
        for(int i=before.length-1;i>=0;i--){
            result[j]=before[i];
            if(result[j]==0){
                result[j]=1;
            }else
            {
                result[j]=0;
            }
            j++;
        }
        return result;
    }

}
