package Day2;

import java.util.Arrays;

public class ChocolateDistribution {
    public static int Minimum(int[]nums,int m){
        Arrays.sort(nums);
        int diff = 0;
        diff = nums[m-1]-nums[0];
        int Minimum = diff;
        for(int i = m;i<nums.length;i++){
            diff =nums[i]-nums[i-m+1];
            Minimum = Math.min(Minimum, diff);
        }
        return Minimum;
    }
}
