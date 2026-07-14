package Day2;
// kadens algorithm
public class Kaden {
    static int MaximumSubarraySum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int maximumsum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maximumsum = Math.max(maximumsum, sum);
            if (sum<0) {
                sum = 0;
            }
        }
        return maximumsum;
    }

}
