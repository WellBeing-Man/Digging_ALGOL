import java.util.ArrayList;

public class BaseStationSetup {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int emptySpace=0;
        int before=0;
        int stationRange=2*w+1;
        for(int i:stations){
            emptySpace=i-before-w-1;
            answer+=emptySpace /stationRange;
            if(emptySpace%stationRange>0){
                answer++;
            }
            before=i+w;
        }
        if(before<n){
            emptySpace=n-before;
            answer+=emptySpace /stationRange;
            if(emptySpace%stationRange>0){
                answer++;
            }
        }
        return answer;
    }


}
