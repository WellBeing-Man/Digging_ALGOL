package BruteForce;


//Combination basic
public class NCR {

    public void doCombination(int[] combArr, int n, int r, int index,int target, int[] arr){
        if(r==0){
            for(int i=0;i<index;i++)
                System.out.print(arr[combArr[i]]);
            System.out.println();
        }else if(target==n) return;
        else {
            combArr[index]=target;
            doCombination(combArr,n,r-1,index+1,target+1,arr);
            doCombination(combArr,n,r,index,target+1,arr);

        }
    }
}