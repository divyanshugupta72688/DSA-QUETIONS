class Lower{
    public static int LowerBound(int[]nums,int target){
        int n = nums.length;
        int s = 0;
        int e = n-1;
        int ans = -1;
        while (s<=e) {
            int mid = s + (e-s)/2;
            if (nums[mid]>=target) {
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {10,20,30,30,30,30,30,40,50};
        int target = 35;
        int ans = LowerBound(nums, target);
        System.out.println("ans ->"+ans);
    }
}