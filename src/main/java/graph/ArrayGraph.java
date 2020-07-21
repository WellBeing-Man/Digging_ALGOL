package graph;

import java.util.Scanner;


//Array Graph example
public class ArrayGraph {
    public static void main(String[] args) {
            ArrayGraph a=new ArrayGraph(6,8);
            a.printGraph();

    }

    int nV;
    int nE;
    int[][] list;
    public ArrayGraph(int nV, int nE) {
        this.nV = nV;
        this.nE = nE;

        list=new int[nV][nV];
        setGraph();
    }

    private void setGraph(){
        System.out.println("Input "+nV+ "nodes");
        int x,y;
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<nE;i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();

            list[x - 1][y - 1] = 1;
            list[y - 1][x - 1] = 1;
        }
    }

    public void printGraph(){
        for(int[] a:list){
            for(int b: a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }


}