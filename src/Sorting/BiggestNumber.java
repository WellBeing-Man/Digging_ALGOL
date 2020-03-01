package Sorting;

public class BiggestNumber {



    private int number;

    public BiggestNumber(int number) {
        this.number = number;
    }

    public void viewer(){
        System.out.println(cipher());

    }
    private int cipher(){
        int i=0;

        while(number>=1){
            number=number/10;
            i++;}

        return i;
    }

}
