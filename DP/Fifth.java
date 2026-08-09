import java.util.Arrays;

public class Fifth {
    // COINS CHANGE PROBLEM

    class Coins {
        public int Problem(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
            }
            int ans = helper(coins, amount, n, dp);
            if (ans == Integer.MAX_VALUE - 1) {
                return -1;
            }
            return ans;
        }

        public int helper(int[] coins, int amount, int idx, int[][] dp) {
            if (amount == 0) {
                return 0;
            }
            if (idx == 0) {
                return Integer.MAX_VALUE - 1;
            }
            if (dp[idx][amount] != -1) {
                return dp[idx][amount];
            }
            if (coins[idx - 1] <= amount) {
                int take = 1 + helper(coins, amount - coins[idx - 1], idx, dp);
                int nottake = helper(coins, amount, idx - 1, dp);
                return dp[idx][amount] = Math.min(take, nottake);
            } else {
                return dp[idx][amount] = helper(coins, amount, idx - 1, dp);
            }
        }

    }
}
