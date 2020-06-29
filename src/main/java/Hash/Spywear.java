package Hash;

import java.util.HashMap;
//programmers problem
public class Spywear {
    //think smart...
    public int solution(String[][] clothes) {

        HashMap<String,Integer> combination=new HashMap<>();
        int answer=1;
        for(String[] clothe:clothes){
            combination.put(clothe[1],combination.getOrDefault(clothe[1],0)+1);
        }
        for(Integer combos:combination.values()){
            answer*=(combos+1);
        }

        return answer-1;
    }
// using combination.. it is failed time-over
    private int combination(String[][] clothes, HashMap<String, String> combi, int now,int remain) {
       int combo = 0;
       if(remain==0){
           return 0;
       }else {
           for (int i = now; i < clothes.length; i++) {
               HashMap<String, String> nowComb = (HashMap) combi.clone();
               if (!nowComb.containsKey(clothes[i][1])) {
                   nowComb.put(clothes[i][1], clothes[i][1]);
                   combo++;
                   combo += combination(clothes, nowComb, i + 1, remain - 1);
               }
           }

       }
            return combo;
    }

    public static void main(String[] args) {
        String[][] s={{"yellow_hat","headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.print(new Spywear().solution(s));
    }
}
