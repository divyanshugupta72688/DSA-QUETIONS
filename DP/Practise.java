
import java.util.Arrays;

public class Practise {

    // fibonacci number

    class Fibo {
        public int Fibonacci(int n) {
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
            dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
            return dp[n];
        }
    }

    // CLIMBING STAIR

    class Climbing {
        public int ClimbingStair(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return helper(n, dp);
        }

        public int helper(int n, int[] dp) {
            if (n <= 1) {
                return 1;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        }
    }

    // TRIBONACCI NUMBER

    class Tribonacci {
        public int Number(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return helper(n, dp);
        }

        public int helper(int n, int[] dp) {
            if (n == 0) {
                return 0;
            }
            if (n == 2 || n == 1) {
                return 1;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            return dp[n] = helper(n - 1, dp) + helper(n - 2, dp) + helper(n - 3, dp);
        }
    }

    // Min Cost Climbing Stairs (LeetCode 746).

    class Cost {
        public int MinimumCost(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return Math.min(helper(nums, dp, n - 1), helper(nums, dp, n - 2));
        }

        public int helper(int[] nums, int[] dp, int idx) {
            if (idx == 1 || idx == 0) {
                return nums[idx];
            }
            if (dp[idx] != -1) {
                return dp[idx];
            }
            return dp[idx] = nums[idx] + Math.min(helper(nums, dp, idx - 1), helper(nums, dp, idx - 2));
        }
    }

    // HOUSE ROBBER(198)
    class Rob {
        public int robbary(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            int index = 0;
            return helper(nums, dp, index);
        }

        public int helper(int[] nums, int[] dp, int index) {
            if (index >= nums.length) {
                return 0;
            }
            if (dp[index] != -1) {
                return dp[index];
            }
            return dp[index] = Math.max(nums[index] + helper(nums, dp, index + 2), helper(nums, dp, index + 1));
        }
    }

    // HOUSE ROBBARY QUETION(213)

    class House {
        public int HouseRob(int[] nums) {
            int n = nums.length;

            if (n == 1) {
                return nums[0];
            }
            int[] dp1 = new int[n];
            Arrays.fill(dp1, -1);
            int[] dp2 = new int[n];
            Arrays.fill(dp2, -1);

            // FIRST CASE FOR HANDELING IF ROBBER STARTS FROM 0 INDEX AND HE CAN NOT GET ANY
            // MONEY FROM LAST INDEX HE CAN REACH ONLY SECOND LAST INDEX

            int take = helper(nums, 0, n - 2, dp1);
            int skip = helper(nums, 1, n - 1, dp2);
            return Math.max(take, skip);
        }

        public int helper(int[] nums, int start, int end, int[] dp) {
            if (start > end) {
                return 0;
            }
            if (dp[start] != -1) {
                return dp[start];
            }
            int take = nums[start] + helper(nums, start + 2, end, dp);
            int skip = helper(nums, start + 1, end, dp);
            return dp[start] = Math.max(take, skip);
        }
    }

    // FRIENDS PAIRING PROBLEM

    class Pairing {
        public int PairingFriend(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return helper(n, dp);
        }

        public int helper(int n, int[] dp) {
            if (n <= 2) {
                return n;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            return dp[n] = (helper(n - 1, dp) + helper(n - 2, dp) * (n - 1));
        }
    }

    // HOW MANY WAYS TO ARRANGE IN WRONG WAY FOR GIVEN N

    class Way {
        public int Deaarange(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return helper(n, dp);
        }

        public int helper(int n, int[] dp) {
            if (n == 1) {
                return 0;
            }
            if (n == 0) {
                return 1;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            return dp[n] = (n - 1) * (helper(n - 1, dp) + helper(n - 2, dp));
        }
    }

    // UNIQUE PATH(62)

    class Unique {
        public int Path(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            return helper(0, 0, m, n, dp);
        }

        public int helper(int row, int coln, int m, int n, int[][] dp) {
            if (row >= m || coln >= n) {
                return 0;
            }
            if (row == m - 1 && coln == n - 1) {
                return 1;
            }
            if (dp[row][coln] != -1) {
                return dp[row][coln];
            }
            return dp[row][coln] = helper(row + 1, coln, m, n, dp) + helper(row, coln + 1, m, n, dp);
        }
    }

    // MINIMUM PATH SUM(64)

    class MinimumPathSum {
        public int Problem(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            return helper(0, 0, m, n, grid, dp);
        }

        public int helper(int row, int coln, int m, int n, int[][] grid, int[][] dp) {
            if (row >= m || coln >= n) {
                return Integer.MAX_VALUE;
            }
            if (row == m - 1 && coln == n - 1) {
                return grid[row][coln];
            }
            if (dp[row][coln] != -1) {
                return dp[row][coln];
            }
            return dp[row][coln] = grid[row][coln]
                    + Math.min(helper(row + 1, coln, m, n, grid, dp), helper(row, coln + 1, m, n, grid, dp));
        }
    }

    // KNAPSACK PROBLEM AUR UNBOUNDED KNAPSACK PROBLEM ME SIRF ITNA DIFFERNCE HOTA
    // HAI KI HUM USE BAAR BAAR LE SAKTE HAI ANS1 LINE IDX-1 NAHI HOGA

    class Knapsack {
        public int Problem(int w, int[] wt, int[] val) {
            int n = wt.length;
            int[][] dp = new int[n + 1][w + 1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= w; j++) {
                    dp[i][j] = -1;
                }
            }
            return helper(w, wt, val, n, dp);
        }

        public int helper(int w, int[] wt, int[] val, int n, int[][] dp) {
            if (n == 0 || w == 0) {
                return 0;
            }
            if (dp[n][w] != -1) {
                return dp[n][w];
            }
            if (wt[n - 1] <= w) {
                // include karenge
                int ans1 = val[n - 1] + helper(w - wt[n - 1], wt, val, n - 1, dp);
                // exclude pattern

                int ans2 = helper(w, wt, val, n - 1, dp);
                return dp[n][w] = Math.max(ans1, ans2);
            } else {
                return dp[n][w] = helper(w, wt, val, n - 1, dp);

            }
        }
    }

    // SUBSET PROBLEM Based On Include and Exclude Pattern

    class Subset {
        public boolean Problem(int[] nums) {
            int sum = 0;
            int n = nums.length;
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
            return helper(nums, 0, dp, target);
        }

        public boolean helper(int[] nums, int idx, int[][] dp, int target) {
            if (target == 0) {
                return true;
            }
            if (idx == nums.length || target < 0) {
                return false;
            }

            if (dp[idx][target] != -1) {
                return dp[idx][target] == 1;
            }
            boolean take = helper(nums, idx + 1, dp, target - nums[idx]);
            boolean nottake = helper(nums, idx + 1, dp, target);
            dp[idx][target] = (take || nottake) ? 1 : 0;
            return take || nottake;
        }
    }

}
