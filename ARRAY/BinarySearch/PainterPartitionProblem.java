public class PainterPartitionProblem {

    public static boolean isValid(int[]nums,int k,int mid){
        int painterCount = 1;
        int board = 0;
        for(int i = 0;i<nums.length;i++){
            if (board+nums[i]<=mid) {
                board += nums[i];
            }else{
                painterCount++;
                if (painterCount>k || nums[i]>mid) {
                    return false;
                }else{
                    board = 0;
                    board = board+nums[i];
                }
            }
        }
        return true;
    }

    public static int Problem(int[]nums,int k){
        int n = nums.length;
        if (n<k) {
            return -1;
        }
        int s =0;
        int sum = 0;
        int ans = -1;
        for(int i  = 0;i<n;i++){
            sum += nums[i];
        }
        int e = sum;
        while(s<=e){
            int mid = s+(e-s)/2;
            if (isValid(nums,k,mid)) {
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[]nums = {5,10,30,20,15};
        int k= 3;
        System.out.println(Problem(nums,k));
    }
}
