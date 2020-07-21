package recursive;

public class Numdivide {
    int numdivide2(int n, int[] array, int length){
        int count=0;

        for(int i=1;i<n;i++){
            array[length]=i;
            count+=numdivide2(n-i,array,length+1);
        }
        array[length]=n;
        printArray(array,length+1);
        return count+1;
    }

    int numdivide(int n, int m, int[] array,int length){
        int count=0;

        if(n==0){
            printArray(array,length);

            return 1;
        }
        if(m>n){
            m=n;
        }

        for(int i=1;i<=m;i++){
            array[length]=i;
            count+=numdivide(n-i,i,array,length+1);

        }

        return count;
    }

    private void printArray(int[] array,int length) {
        for(int i=0;i<length;i++){
            if(i==length-1){
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i]+"+");
        }
    }


}
