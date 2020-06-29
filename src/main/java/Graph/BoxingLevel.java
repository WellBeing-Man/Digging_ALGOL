package Graph;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class BoxingLevel {
    private class Node{
        HashSet<Integer> win;
        HashSet<Integer> lose;

        public Node() {
            this.win = new HashSet<>();
            this.lose = new HashSet<>();
        }
    }
    public int solution(int n, int[][] results) {
        ArrayList<Node> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Node());
        }
        for(int i=0;i<results.length;i++){
            list.get(results[i][0]-1).win.add(results[i][1]-1);
            list.get(results[i][1]-1).lose.add(results[i][0]-1);
        }


        for(Node player:list){
            Iterator iteratorWin=player.win.iterator();
            Iterator iteratorLose=player.lose.iterator();
            while (iteratorWin.hasNext()){
                int loser= (int) iteratorWin.next();
                list.get(loser).lose.addAll(player.lose);
            }
            while (iteratorLose.hasNext()){
                int winner= (int) iteratorLose.next();
                list.get(winner).win.addAll(player.win);
            }
        }


        return getFinished(list);
    }

    private int getFinished(ArrayList<Node> list) {
        int result=0;
        for(Node node:list){
            if(node.lose.size()+node.win.size() == list.size()-1){
                result++;
            }
        }
        return result;
    }

    private void printnodes(ArrayList<Node> list) {
        for(Node node:list){
            System.out.println("win"+node.win);
            System.out.println("lose"+node.lose);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BoxingLevel boxingLevel=new BoxingLevel();
        int[][] a={{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.print(boxingLevel.solution(5,a));
    }

}
