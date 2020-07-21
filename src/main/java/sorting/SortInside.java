package sorting;

//BackJoon Online judge  #1427
public class SortInside {
    public static void main(String[] args) {
        String numbers="153698742";
//       Scanner scanner=new Scanner(System.in);
  //      numbers=numbers+String.valueOf(scanner.nextInt());
        for(int i:new SortInside().solution(numbers.split(""))) {
            System.out.print(i);
        }
    }
    public int[] solution(String[] numbers){

        int[] array=new int[numbers.length];
        // to Int array
       for(int i=0;i<numbers.length;i++){
           array[i]=Integer.parseInt(numbers[i]);
       }
       //insertSort(array);
       quickSort(array,0,array.length-1);
       return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if(left<right){
            int pivot=divide(array,left,right);
            quickSort(array,left,pivot-1);
            quickSort(array,pivot+1 ,right);
        }
    }


    private int divide(int[] array, int left, int right) {

        int pivot;
        int high,low;

        low=left;
        high=right+1;
        pivot=(left);
        do{
            do{
                low++;
            }while (low<=right && array[low]<pivot);
            do{
                high--;
            }while (high>=left && array[high]>pivot);
            if(left<high){
                swap(array,low,high);
            }
        }while (low<high);
        swap(array,left,high);
        return high;
    }

    private void swap(int[] array, int left, int right) {
        int temp=array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private void insertSort(int[] array) {
        int key,j;
        for(int i=1;i<array.length;i++){
            key=array[i];

            for(j=i-1;j>=0 && array[j]<key;j--){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }


}
