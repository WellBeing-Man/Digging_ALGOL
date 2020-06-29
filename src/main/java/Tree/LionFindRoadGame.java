package Tree;

public class LionFindRoadGame {
    public int[][] solution(int[][] nodeinfo) {

     int[][] answer=new int[2][nodeinfo.length];
     reverseSorting(nodeinfo);
        postorder(nodeinfo,answer[1],0,0,0);

        return answer;
    }

    private void postorder(int[][] nodeinfo,int[] answer,int level,int now,int index) {
        answer[index]=nodeinfo[now][1];
    }

    private void preorder(int[][] nodeinfo, int[] answer, int remain,int index) {

    }

    private void reverseSorting(int[][] array) {

        for(int i=1;i<array.length;i++){
            int j=i-1;
            int[] temp=array[i];
            while (j>=0  && array[j][1]<temp[1]){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
    }


    private class Tree{
        mBTN root;

        public Tree(mBTN root) {
            this.root = root;
        }

        public void add(int[] item){
            mBTN node=root;
            mBTN newNode=new mBTN(item[1]);

        }
    }

    private class mBTN {
        mBTN left,right;
        private int data;

        public mBTN(int data) {
            right=left=null;
            this.data = data;
        }

    }
}
