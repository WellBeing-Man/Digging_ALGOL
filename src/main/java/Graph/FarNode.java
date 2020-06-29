package Graph;


import java.util.ArrayDeque;
import java.util.Queue;


//Programmers solution, BFS!!
public class FarNode {

    public int solution(int n, int[][] edge) {


        boolean[][] map=new boolean[n][n];
        int answer=0;
        int[] height=new int[n];
        int max=0;

        for(int i=0;i<edge.length;i++){
            map[edge[i][0]-1][edge[i][1]-1]=true;
            map[edge[i][1]-1][edge[i][0]-1]=true;


        }
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int now=queue.poll();
            max=height[now];
            for(int i=1;i<n;i++){
                if(map[now][i] && height[i]==0) {
                    height[i]=height[now]+1;
                    queue.add(i);
                }

            }
        }


        for(int i:height){
            if(i==max){
                answer++;
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        int[][] a={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(new FarNode().solution(6,a));
    }
}
