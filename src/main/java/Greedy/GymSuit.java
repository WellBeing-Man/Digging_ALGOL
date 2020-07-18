package Greedy;


import java.util.*;


//programers done
public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
      ArrayList<Integer> lostList=new ArrayList<>();
      ArrayList<Integer> reserveList=new ArrayList<>();
      for(int l:lost){
            lostList.add(l);
      }
        for(int r:reserve){
            if(!lostList.contains(r)){
                reserveList.add((Integer)r);
            }else{
                lostList.remove(((Integer)r));
            }
        }
        reserveList.forEach((it)->{
          if(!lostList.remove((Object)(it-1))){
           lostList.remove((Object)(it+1));
          } });



        return n-lostList.size();
    }

}
