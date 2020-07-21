package recursive;

public class Extra {

    //1^k+2^k+3^k+....n^k
    public int nk(int n,int k){

        int sum=0;

        if(n==1){
            return 1;
        }else{
            int temp=1;
            for(int i=0;i<k;i++){
              temp*=n;
            }
            sum+=temp+nk(n-1,k);
            return sum;
        }

    }

    public int nkNrecursive(int n,int k){
        int[] array=new int[n];
        int sum=0;
        for(int i=1;i<=n;i++){
        array[i-1]=i;
        int temp=1;
            for(int j=0;j<k;j++){
                temp*=array[i-1];
            }
            sum+=temp;
        }
        return sum;
    }
}

