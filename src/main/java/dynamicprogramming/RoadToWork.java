package dynamicprogramming;

import java.util.Scanner;

public class RoadToWork {
    int[][] xy;
    public void path(int n,int m) {
        xy = new int[n][m];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input" + n + "x" + m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                xy[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        printPath();
    }

    //recursive way
    protected int getPathway(int[][] xy, int x, int y) {
      if(xy[x][y]==0){
          return 0;
      }
      if(x==0 && y==0){
          return 1;
      }

      return ((x>0) ? getPathway(xy,x-1,y) :0 )+
              ((y>0) ? getPathway(xy,x,y-1) : 0);
    }

    //dynamic way
    protected void bigPathWay(int[][] xy, int x, int y){
        if(xy[x][y]!=0){
            xy[x][y]=xy[x-1][y]+xy[x][y-1];
        }
        if(x<xy.length-1) {
            bigPathWay(xy, x + 1, y);
        }else if(y<xy[0].length-1){
            bigPathWay(xy,1,y+1);
        }else{
            return;
        }
    }


    public void printPath(){
        System.out.println("way : "+  getPathway(xy,xy.length-1,xy[0].length-1));
        bigPathWay(xy,1,1);
        System.out.println("way " + xy[xy.length-1][xy[0].length-1]);

    }
}
