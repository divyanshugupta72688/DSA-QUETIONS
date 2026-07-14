package Day2;

public class MaximumSubarrayOfSizeK {
    public static int Sum(int[]nums,int k){
        int n =nums.length;
        int WindowSum = 0;
        for(int i = 0;i<k;i++){
            WindowSum += nums[i];
        }
        int maxsum = WindowSum;
        for(int i  =k;i<n;i++){
            WindowSum += nums[i];
            WindowSum -=nums[i-k];
            maxsum = Math.max(maxsum, WindowSum);
        }
        return maxsum;
    }
}
