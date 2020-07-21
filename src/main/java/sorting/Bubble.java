package sorting;


// Written by LDG

public class Bubble implements mSorting{
    int[] input;

    public Bubble(int[] input) {
        this.input = input;
    }

    public int[] ascending(){
        int temp=-99999;            //if temp -99999, the array is already sorted..
        int[] array=input;
        for(int j=0;j<array.length-1;j++) {
            for (int i = 0; i < array.length -1 - j; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                }
            }
            if(temp==-99999){
                break;                  //so break loop
            }
        }
        return array;
    }

    @Override
    public int[] descending() {         //just descending
        int temp=-99999;
        int[] array=input;
        for(int j=0;j<array.length-1;j++) {
            for (int i = 0; i < array.length -1 - j; i++) {
                if (array[i] < array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                }
            }
            if(temp==-99999) {
                break;
            }
        }
        return array;
    }

}
