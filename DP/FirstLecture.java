package DP;

import java.util.Arrays;

public class FirstLecture {

    // fibonacci number using Memoziation(TOP-DOWN)(509)

    class Fibonacci {
        static int[] dp;

        public int fib(int n) {
            dp = new int[n + 1];
            return helper(n);
        }

        public int helper(int n) {
            if (n <= 1) {
                return n;
            }
            if (dp[n] != 0) {
                return dp[n];
            }
            dp[n] = helper(n - 1) + helper(n - 2);
            return dp[n];
        }
    }

    // MINIMUM COST USING RECURSION

    class solution {
        public int Min(int[] cost) {
            int n = cost.length;
            return Math.min(helper(cost, n - 1), helper(cost, n - 2));
        }

        public int helper(int[] cost, int idx) {
            if (idx == 1 || idx == 2) {
                return cost[idx];
            }
            return cost[idx] + Math.min(helper(cost, idx - 1), helper(cost, idx - 2));
        }
    }

    // USING DYNAMIC PROGRAMMING(746)

    class Solution {

        public int MinCost(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return Math.min(helper(cost, n - 1, dp), helper(cost, n - 2, dp));
        }

        public int helper(int[] cost, int idx, int[] dp) {
            if (idx == 1 || idx == 0) {
                return cost[idx];
            }
            if (dp[idx] != -1) {
                return dp[idx];
            }
            return dp[idx] = cost[idx] + Math.min(helper(cost, idx - 1, dp), helper(cost, idx - 2, dp));
        }
    }


    // TRIBONACCI NUMBER(1137)

    class Tri{
        public int TribonacciNumber(int n){
            int[] dp = new int[n+1];
            return helper(n,dp);
        }
        public int helper(int n,int[]dp){
            if (n<=1) {
                return n;
            }
            if (n==2) {
                return 1;
            }
            if (dp[n]!=0) {
                return dp[n];
            }
            dp[n] = helper(n-1, dp)+helper(n-2, dp)+helper(n-3, dp);
            return dp[n];
        }
    }

// CLIMBING STAIR(70)

class Climbing{
    public int ClimbingStair(int n){
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    public int helper(int n,int[]dp){
        if (n==1||n==0) {
            return 1;
        }
        if (dp[n]!=-1) {
            return dp[n];
        }
        dp[n] = helper(n-1, dp)+helper(n-2, dp);
        return dp[n];
    }
}

// HOUSE ROBBER(198)

class Robber{
    public int HouseRobber(int nums[]){
        int n = nums.length;
        int index = 0;
        int[]dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = helper(nums,index,dp);
        return ans;
    }
    public int helper(int[]nums,int index,int[]dp){
        if (index>=nums.length) {
            return 0;
        }
        if (dp[index]!=-1) {
            return dp[index];
        }
        int includeans = nums[index]+helper(nums, index+2, dp);
        int excludeans = 0+ helper(nums, index+1, dp);
        dp[index] = Math.max(includeans, excludeans);
        return dp[index];
    }
}




// HOUSE ROBBER SECOND(213)

class HouseRobberSecond{
    public int Rob(int[] nums){
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }
        int[]dp1 = new int[n];
        int[]dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        // pahle case me phla house include hoga aur last house exclude hoga

        int case1 = helper(nums,0,n-2,dp1);
        int case2 = helper(nums,1,n-1,dp2);

        return Math.max(case1, case2);
    }
    public int helper(int[] nums,int index,int end,int[]dp){
        if (index>end) {
            return 0 ;
        }
        if (dp[index]!=-1) {
            return dp[index];
        }
        int take = nums[index]+helper(nums, index+2, end, dp);
        int skip = helper(nums, index+1, end, dp);
        return dp[index]  = Math.max(take, skip);
    }
}


}
