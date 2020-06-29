package Recursive;

public class Fibonacci {
     int[] memo=new int[200];

    int fibonacci2(int n){
        if(memo[n]>0){
            return memo[n];
        }
        if(n==1 || n==2)
            return memo[n]=1;
        else
            return memo[n]=fibonacci2(n-1)+fibonacci2(n-2);
    }

    int fibonacci(int n){
        if(n==1||n==2)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

}
