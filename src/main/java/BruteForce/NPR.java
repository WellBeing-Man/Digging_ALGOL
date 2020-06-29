package BruteForce;



//Permutation Basic
public class NPR {

    public void doPermutaion(int[] arr, int start){
        int length=arr.length;
            if(start==length){
                for(int n:arr){
                    System.out.print(n);
                }
                System.out.println();
                return;
            }

            for(int i=start;i<length;i++){
                swap(arr,start,i);
                doPermutaion(arr,start+1);
                swap(arr,start,i);
            }
    }

    private void swap(int[] arr, int start, int i) {
            int temp=arr[i];
            arr[i]=arr[start];
            arr[start]=temp;
    }
}
