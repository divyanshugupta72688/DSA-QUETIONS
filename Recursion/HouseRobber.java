class HouseRobber{
    static int solve(int[]nums,int index){
        if (index>=nums.length) {
            return 0;
        }
        int includeans  =  nums[index]+solve(nums, index+2);
        int excludeans = 0+solve(nums, index+1);
        int finalans = Math.max(includeans, excludeans);
        return finalans;
    }
    public static int rob(int[]nums){
        int index = 0;
        int ans =solve(nums,index);
        return ans;
    }
}