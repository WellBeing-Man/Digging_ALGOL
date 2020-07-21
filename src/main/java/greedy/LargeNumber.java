package greedy;




public class LargeNumber {

    public String solution(String number, int k) {
       int index=0;
       char max;
       StringBuilder answer=new StringBuilder();

       if(number.charAt(0)=='0') return "0";
       for(int i=0;i<number.length()-k;i++){
           max='0';
           for(int j=index;j<=k+i;j++){
               if(max<number.charAt(j)){
                   max=number.charAt(j);
                   index=j+1;
               }
           }
           answer.append(max);
       }

       return answer.toString();
    }


    public static void main(String[] args) {
        new LargeNumber().solution("1924",2);
    }
}
