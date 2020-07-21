package sorting;


import java.util.Arrays;
import java.util.Comparator;


public class BiggestNumber {

        public static void main(String[] args) {
            String answer="";
            int[] numbers={6,10,2};
            Integer[] array=new Integer[numbers.length];
            for(int i=0;i<numbers.length;i++){
                array[i]=numbers[i];
            }
            Arrays.sort(array, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String temp1= o1.toString();
                    String temp2= o2.toString();

                    return (temp2+temp1).compareTo(temp1+temp2);
                }
            });

            for(Integer i : array){
              System.out.print(i);
            }


        }

}
