package sorting;


//Written by LDG
public class Insert implements mSorting {

    int[] input;

    public Insert(int[] array) {
        this.input = array;
    }

    @Override
    public int[] ascending() {
        int[] array=input;
        for(int i=1;i<array.length;i++){
            int j=i-1;
            int temp=array[i];
            while (j>=0  && array[j]>temp){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
        return array;
    }

    @Override
    public int[] descending() {
        int[] array=input;
        for(int i=1;i<array.length;i++){
            int j=i-1;
            int temp=array[i];
            while (j>=0  && array[j]<temp){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=temp;
        }
        return array;
    }
}
