package Day2;

public class MaximumProductSubarray {
    static int Product(int[]nums){
        int MaximumProduct = nums[0];
        int MinimumaProduct = nums[0];
        int ans = nums[0];
        for(int i = 1;i<nums.length;i++){
            if (nums[i]<0) {
                int temp = MaximumProduct;
                MaximumProduct = MinimumaProduct;
                MinimumaProduct = temp;
            }
            MaximumProduct = Math.max(MaximumProduct, nums[i]*MaximumProduct);
            ans = Math.max(ans, MaximumProduct);
        }
        return ans;
    }
}
