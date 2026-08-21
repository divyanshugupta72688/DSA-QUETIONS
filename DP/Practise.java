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

    // FRIENDS PAIRING PROBLEM

    class Friends {
        public int Pairing(int n) {
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
            return dp[n] = helper(n - 1, dp) + (helper(n - 2, dp) * (n - 1));
        }
    }

    // DEARRANGEMENT

    class Dearrange {

        public int Count(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return helper(n, dp);
        }

        public int helper(int n, int[] dp) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 0;
            }
            if (dp[n] != -1) {
                return dp[n];
            }
            return dp[n] = (n - 1) * (helper(n - 1, dp) + helper(n - 2, dp));
        }
    }

    // UNIQUE PATH(62)

    class Unique {
        public int Path(int n, int m) {
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            return helper(0, 0, m, n, dp);
        }

        public int helper(int row, int coln, int m, int n, int[][] dp) {
            if (row > m || coln > n) {
                return 0;
            }
            if (row == m && coln == n) {
                return 1;
            }
            if (dp[row][coln] != -1) {
                return dp[row][coln];
            }
            return dp[row][coln] = helper(row + 1, coln, m, n, dp) + helper(row, coln + 1, m, n, dp);
        }
    }

    // MINIMUM PATH SUM(64)

    class Minimum {
        public int PathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            return helper(0, 0, m, n, grid, dp);
        }

        private int helper(int row, int coln, int m, int n, int[][] grid, int[][] dp) {
            if (row >= m || coln >= n) {
                return Integer.MAX_VALUE;
            }
            if (row == m && coln == n) {
                return grid[row][coln];
            }
            if (dp[row][coln] != -1) {
                return dp[row][coln];
            }
            return dp[row][coln] = grid[row][coln]
                    + Math.min(helper(row + 1, coln, m, n, grid, dp), helper(row, coln + 1, m, n, grid, dp));
        }
    }

    // COUNT SQAURE (1277)

    class Count {
        public int Square(int[][] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    if (nums[i][j] == 0) {
                        continue;
                    }
                    if (i > 0 && j > 0) {
                        nums[i][j] = nums[i][j]
                                + Math.min(nums[i - 1][j - 1], Math.min(nums[i - 1][j], nums[i][j - 1]));
                    }
                    count += nums[i][j];
                }
            }
            return count;
        }
    }

    // 0/1 KNAPSACK

    class Knapsack {
        public int Problem(int w, int[] wt, int[] val) {
            int n = wt.length;
            int[][] dp = new int[n + 1][w + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
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
                int take = val[n - 1] + helper(w - wt[n - 1], wt, val, n - 1, dp);
                int nottake = helper(w, wt, val, n - 1, dp);
                return dp[n][w] = Math.max(take, nottake);
            } else {
                return dp[n][w] = helper(w, wt, val, n - 1, dp);
            }
        }
    }

    // UNBOUNDED KNAPSACK ME TAKE VALI LINE ME SIRF N-1 NAHI LETE HAI KYUKI THINGS
    // CAN BE REPEAT

    // TARGET SUM PARTIONING (416)

    class parttioning {
        public boolean Problem(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if ((sum % 2) != 0) {
                return false;
            }
            int target = sum / 2;
            int n = nums.length;
            int[][] dp = new int[n + 1][target + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
            }
            return helper(nums, dp, 0, target);
        }

        public boolean helper(int[] nums, int[][] dp, int index, int target) {
            if (target == 0) {
                return true;
            }
            if (index >= nums.length || target < 0) {
                return false;
            }
            if (dp[index][target] != -1) {
                return dp[index][target] == 1;
            }
            boolean take = helper(nums, dp, index + 1, target - nums[index]);
            boolean nottake = helper(nums, dp, index + 1, target);
            dp[index][target] = (take || nottake) ? 1 : 0;
            return take || nottake;
        }
    }

    // COIN CHANGE PROBLEM || (518)

    class Coin {
        public int Problem(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
            }
            return helper(coins, amount, dp, n);
        }

        private int helper(int[] coins, int amount, int[][] dp, int index) {
            if (amount == 0) {
                return 1;
            }
            if (index == 0) {
                return 0;
            }
            if (dp[index][amount] != -1) {
                return dp[index][amount];
            }
            if (coins[index - 1] <= amount) {
                int take = helper(coins, amount - coins[index - 1], dp, index);
                int nottake = helper(coins, amount, dp, index - 1);
                return dp[index][amount] = take + nottake;
            } else {
                return dp[index][amount] = helper(coins, amount, dp, index - 1);
            }
        }
    }

    // COIN CHANGE |(398)

    class CoinFirst {
        public int Problem(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
            }
            int ans = helper(coins, amount, dp, n);
            if (ans == Integer.MAX_VALUE - 1) {
                return -1;
            }
            return ans;
        }

        private int helper(int[] coins, int amount, int[][] dp, int index) {
            if (amount == 0) {
                return 0;
            }
            if (index == 0) {
                return Integer.MAX_VALUE - 1;
            }
            if (dp[index][amount] != -1) {
                return dp[index][amount];
            }
            if (coins[index - 1] <= amount) {
                int take = 1 + helper(coins, amount - coins[index - 1], dp, index);
                int nottake = helper(coins, amount, dp, index - 1);
                return dp[index][amount] = take + nottake;
            } else {
                return dp[index][amount] = helper(coins, amount, dp, index - 1);
            }
        }
    }
}
