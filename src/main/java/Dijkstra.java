
import java.util.Arrays;


//Dijkstra Review
public class Dijkstra {
    int[] distance;
    boolean[] check;
    int[][] map;
    public Dijkstra(int length) {
        this.distance=new int[length];
        this.check =new boolean[length];
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public void shortestPath(int start, int end){
        distance= Arrays.copyOf(map[start-1],map[start].length);
        int nearNode=start-1;
        int currentWeight=0;
        int shortNode=0;
        for(int i=0;i<distance.length;i++){
            check[nearNode]=true;
            int max=Integer.MAX_VALUE;
            for(int j=0;j<distance.length;j++){
                if(j!=nearNode){
                    if(map[nearNode][j]+currentWeight<distance[j] && map[nearNode][j]!= Integer.MAX_VALUE){
                        distance[j]=map[nearNode][j]+currentWeight;
                    }
                    if(max>map[nearNode][j] && !check[j]){
                        max=map[nearNode][j];
                        shortNode=j;
                    }
                }
            }
            currentWeight+=map[nearNode][shortNode];
            nearNode=shortNode;

        }

        System.out.println(distance[end-1]);


    }
}
