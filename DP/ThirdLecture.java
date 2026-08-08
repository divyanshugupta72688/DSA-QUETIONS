public class ThirdLecture {

    // UNIQUE PATH (62)
    class Unique {
        public int CountUniquePath(int m, int n) {
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

    // GIVEN UNIQUE QUETION WE CAN SOLVE USING TABULATION METHOD

    class Tabulation {
        public int SecondMethod(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    // minimum path sum (64)using tabulation

    class Minimum {
        public int MinimumPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i == 0) {
                        grid[i][j] += grid[i][j - 1];
                    } else if (j == 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else {
                        grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                    }
                }
            }
            return grid[m - 1][n - 1];
        }
    }

    // MINIMUM PATH USING MEMOZIATION

    class Memoziation {
        public int Path(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            return helper(0, 0, m, n, dp, grid);
        }

        public int helper(int row, int coln, int m, int n, int[][] dp, int[][] grid) {
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
                    + Math.min(helper(row + 1, coln, m, n, dp, grid), helper(row, coln + 1, m, n, dp, grid));
        }
    }

}