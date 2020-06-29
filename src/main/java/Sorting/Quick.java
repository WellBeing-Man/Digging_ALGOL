package Sorting;

public class Quick{

    static int divide(int[] input, int left, int right){
            int[] array=input;
            int pivot= array[(left+right)/2];

            while (array[left]<pivot && left<right){
                    left++;
            }
            while (array[right]>pivot && left<right){
                right--;
            }

            if(left< right){
                swap(array,left, right);
            }

            return left;
    }

    public static void sorting(int[] input,int left,int right){
            if(left>right){
                int pivot=divide(input,left,right);
                sorting(input,left,pivot-1);
                sorting(input,pivot+1,right);
            }

    }
    private static int[] swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
        return array;
    }


}
