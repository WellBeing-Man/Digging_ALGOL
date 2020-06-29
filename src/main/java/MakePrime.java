
public class MakePrime {

    int answer;
    public int solution(int[] nums) {
        int[] combiArr=new int[3];
        combination(nums,nums.length,3,0,0,combiArr);
        return answer;
    }

    private void combination(int[] nums, int n, int r, int index, int target, int[] combiArr) {
        if(r==0){
            int sum=0;
            for(int i=0;i<index;i++){
                sum+=nums[combiArr[i]];
            }
            if(isPrime(sum)){
                answer++;
            }
        }else if(target==n){
            return;
        }else {
            combiArr[index]=target;
            combination(nums,n,r-1,index+1,target+1,combiArr);
            combination(nums,n,r,index,target+1,combiArr);
        }



    }

    private boolean isPrime(int sum) {

            for(int i=2;i<sum;i++){
                if(sum%i==0){
                    return false;
                }
            }
            return true;
    }
}
