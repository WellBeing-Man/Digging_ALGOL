package Stack;
import java.util.ArrayDeque;

//Programmers Level2
public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer= new int[prices.length];
        ArrayDeque stocks=new ArrayDeque();
        for(int stock:prices){
            stocks.add(stock);
        }
        int time=0;
        int stockN=0;
        for(int i=0;i<prices.length;i++){
            int a=(Integer)stocks.peekFirst();
            if(a>prices[i] || i+1==prices.length){
                answer[stockN++]=time;
                i=stockN;
                time=1;
                stocks.pop();
            }else{
            time++;
            }

            if(stocks.isEmpty()){
                break;
            }
        }
        return answer;
    }
}
