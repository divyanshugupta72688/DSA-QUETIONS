import java.lang.reflect.Array;
import java.util.Arrays;

public class Fourth {

    // RECURSION SOLUTION OF KNAPSACK PROBLEM(0-1)

    class Knapsack {

        public int Problem(int[] val, int[] wt, int W, int n) {

            // Base case
            if (W == 0 || n == 0) {
                return 0;
            }

            // Agar current item ka weight capacity ke andar hai
            if (wt[n - 1] <= W) {

                // Include
                int ans1 = val[n - 1]
                        + Problem(val, wt, W - wt[n - 1], n - 1);

                // Exclude
                int ans2 = Problem(val, wt, W, n - 1);

                return Math.max(ans1, ans2);

            } else {

                // Include nahi kar sakte, sirf exclude
                return Problem(val, wt, W, n - 1);
            }
        }
    }

    // MEOMOZIATION SOLUTION OF KNAPSACK PROBLEM(0/1)

    class Memoziation {
        public int Problem(int w, int[] val, int[] wt) {
            int n = wt.length;
            int[][] dp = new int[n + 1][w + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= w; j++) {
                    dp[i][j] = -1;
                }
            }
            return helper(w, val, wt, dp, n);
        }

        public int helper(int w, int[] val, int[] wt, int[][] dp, int n) {
            if (w == 0 || n == 0) {
                return 0;
            }
            if (dp[n][w] != -1) {
                return dp[n][w];
            }
            if (wt[n - 1] <= w) {
                int ans1 = val[n - 1] + helper(w - wt[n - 1], val, wt, dp, n - 1);
                int ans2 = helper(w, val, wt, dp, n - 1);
                return dp[n][w] = Math.max(ans1, ans2);
            } else {
                return dp[n][w] = helper(w, val, wt, dp, n - 1);
            }
        }
    }

    // SUBSET SUM(416) recursive problem

    class Subset {

        public boolean Problem(int[] nums) {
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            return helper(nums, 0, target);
        }

        public boolean helper(int[] nums, int idx, int target) {
            if (target == 0) {
                return true;
            }
            if (idx == nums.length || target < 0) {
                return false;
            }
            boolean take = helper(nums, idx + 1, target - nums[idx]);
            boolean nottake = helper(nums, idx + 1, target);
            return take || nottake;
        }
    }

    // target sum parttioning (416)

    class Target {
        public boolean Problem(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            int[][] dp = new int[n][target + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            return helper(nums, 0, target, dp);
        }

        public boolean helper(int[] nums, int idx, int target, int[][] dp) {
            if (target == 0) {
                return true;
            }
            if (idx == nums.length || target < 0) {
                return false;
            }
            if (dp[idx][target] != -1) {
                return dp[idx][target] == 1;
            }
            boolean take = helper(nums, idx + 1, target - nums[idx], dp);
            boolean nottake = helper(nums, idx + 1, target, dp);
            dp[idx][target] = (take || nottake) ? 1 : 0;
            return take || nottake;
        }
    }
}
