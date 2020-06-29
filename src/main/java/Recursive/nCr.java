package Recursive;

public class nCr {
    long[][] memo=new long[200][200];
    long nCr2(int n, int r){
        if(memo[n][r]!=0){
            return memo[n][r];
        }
        if(n ==r || r==0){
            return memo[n][r]=1;
        }
        return memo[n][r]=nCr2(n,r-1)+nCr2(n-1,r-1);
    }

    //Binomial coefficient
    public int nCr(int n,int r){
        if(n==r || r==0){
            return 1;
        }

        return nCr(n-1,r-1) + nCr(n-1,r);
    }

}
