import java.util.Arrays;

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


// COUNT SQUARE SUBMATRICES WITH ALL ONES(1277)

class Solution{

    public int Problem(int[][]arr){
        int m = arr.length;
        int n = arr[0].length;
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]==0) {
                    continue;
                }
                if (i>0 && j>0) {
                    arr[i][j] = arr[i][j]+Math.min(arr[i-1][j], Math.min(arr[i][j-1], arr[i-1][j-1]));
                }
                count += arr[i][j];
            }
        }
        return count;
    }
}

// UNBOUDED KNAPSACK

class Unbounded{
    public int Problem(int[]val,int[]wt,int w){
        int n = wt.length;
        int[][]dp = new int[n+1][w+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(val,wt,w,n,dp);
    }
    public int helper(int[]val,int[]wt,int w,int idx,int[][]dp){
        if (idx==0 || w==0) {
            return 0;
        }
        if (dp[idx][w]!=-1) {
            return dp[idx][w];
        }
        if (wt[idx-1]<=w) {
            int take = val[idx-1]+helper(val, wt, w-wt[idx-1], idx, dp);
            int nottake = helper(val, wt, w, idx-1, dp);
            return dp[idx][w] = Math.max(take, nottake);
        }else{
            return dp[idx][w] = helper(val, wt, w, idx-1, dp);
        }
    }
}



}