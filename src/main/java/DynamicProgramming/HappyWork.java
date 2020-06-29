package DynamicProgramming;

public class HappyWork extends RoadToWork{
    int[][] joy;
    @Override
    public void path(int n, int m) {
        joy=new int[n][m];
        super.path(n, m);
    }

    @Override
    protected int getPathway(int[][] xy, int x, int y) {
        if(x==0 && y==0){
            return xy[x][y];
        }
        if(x==0){
            return getPathway(xy,x,y-1)+xy[x][y];
        }
        if(y==0)
            return getPathway(xy,x-1,y)+xy[x][y];

        return max(getPathway(xy,x-1,y),getPathway(xy,x,y-1))+xy[x][y];
    }

    private int max(int pathway, int pathway1) {
        if(pathway>pathway1)
            return pathway;
        else
            return pathway1;
    }

    @Override
    protected void bigPathWay(int[][] xy, int x, int y) {
       joy[0][0]=xy[0][0];
        for(int i=1;i<x;i++){
           joy[i][0]=joy[i-1][0]+xy[i][0];
       }
        for(int j=1;j<y;j++) {
            joy[0][j]=joy[0][j-1]+xy[0][j];
        }
        for(int i=1;i<x;i++){
            for( int j=1;j<y;j++){
                joy[i][j]=max(joy[i-1][j],joy[i][j-1])+xy[i][j];
            }
        }
    }

    @Override
    public void printPath() {
        System.out.println("way : "+  getPathway(xy,xy.length-1,xy[0].length-1));
        bigPathWay(xy,xy.length,xy[0].length);
        System.out.println("way " + getjoy());

    }

    public int getjoy() {
        return joy[joy.length-1][joy[0].length-1];
    }
}
