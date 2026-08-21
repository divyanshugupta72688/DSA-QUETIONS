import java.util.Arrays;

public class Practise {

    // FIBONACCI SERIES(509)

    class fib {
        public int Dp(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return helper(n, dp);
        }

        public int helper(int n, int[] dp) {
            if (n <= 1) {
                return n;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        }
    }

    // TRIBONACCI SERIES(1137)

    class Tri {
        public int Tribonacci(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return helper(dp, n);
        }

        public int helper(int[] dp, int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            return dp[n] = helper(dp, n - 1) + helper(dp, n - 2) + helper(dp, n - 3);
        }
    }

    // minimum cost to climb a stair(746)
    class Min {
        public int MinimumCost(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            int index = 0;
            return Math.min(helper(index - 1, nums, dp), helper(index - 2, nums, dp));
        }

        public int helper(int index, int[] nums, int[] dp) {
            if (index == 0 || index == 1) {
                return nums[index];
            }
            if (dp[index] != -1) {
                return dp[index];
            }
            return dp[index] = nums[index] + Math.min(helper(index - 1, nums, dp), helper(index - 2, nums, dp));
        }
    }

    // HOUSE ROBBER (198)

    class Robber {
        public int HouseRobber(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return helper(0, nums, dp);
        }

        public int helper(int index, int[] nums, int[] dp) {
            if (index >= nums.length) {
                return 0;
            }
            if (dp[index] != -1) {
                return dp[index];
            }
            int case1 = nums[index] + helper(index + 2, nums, dp);
            int case2 = helper(index + 1, nums, dp);
            return dp[index] = Math.max(case1, case2);
        }
    }

    // HOUSE ROBBER SECOND QUETION(213)

    class House {
        public int Rob(int[] nums) {
            int n = nums.length;
            int[] dp1 = new int[n + 1];
            Arrays.fill(dp1, -1);
            int[] dp2 = new int[n + 1];
            Arrays.fill(dp2, -1);
            int case1 = helper(0, n - 2, nums, dp1);
            int case2 = helper(1, n - 1, nums, dp2);
            return Math.max(case1, case2);
        }

        public int helper(int start, int end, int[] nums, int[] dp) {
            if (start > end) {
                return 0;
            }
            if (dp[start] != -1) {
                return dp[start];
            }
            int sit1 = nums[start] + helper(start + 2, end, nums, dp);
            int sit2 = helper(start + 1, end, nums, dp);
            return dp[start] = Math.max(sit1, sit2);
        }
    }
}
