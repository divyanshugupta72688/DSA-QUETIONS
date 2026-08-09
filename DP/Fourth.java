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
                return dp[n][w]=helper(w, val, wt, dp, n - 1);
            }
        }
    }


    
}
