package Recursive;

public class GrayCode {

    public void gray2(int code[],int n,int index,int reverse){
        if(n==index){
            print_code(code,index);
        }
        code[index]=reverse;
        gray2(code,n,index+1,0);
        code[index]=1-reverse;
        gray2(code,n,index+1,1);

    }

    public void print_code(int[] code,int len){
        for(int i=0;i<len;i++){
            System.out.print(code[i]);
        }
        System.out.println();
    }

    public void grayCode(int[] code, int n, int index){
        if(n==index){
            print_code(code,index);
        }
        code[index]=0;
        grayCode(code,n,index+1);
        code[index]=1;
        reverseCode(code,n,index+1);
    }

    public void reverseCode(int[] code,int n,int index){
        if(n==index){
            print_code(code,index);
        }
        code[index]=1;
        grayCode(code,n,index+1);
        code[index]=0;
        reverseCode(code,n,index+1);

    }
}
