import java.util.*;

public class SecondLecture {

// FriendsPairingProblem on gfg

    class FriendsPairingProblem {
        public int Problem(int n) {
            int[] dp = new int[n];
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
            return dp[n] = helper(n - 1, dp) + helper(n - 2, dp) * (n - 1);
        }
    }

// dearrange count 

class Dearrange{

    public int Count(int n){
        int[]dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n,dp);
    }
    public int helper(int n,int[]dp){
        if (n==0) {
            return 1;
        }
        if (n==1) {
            return 0;
        }
        if (dp[n]!=-1) {
            return dp[n];
        }
        return dp[n] = (n-1)*(helper(n-1, dp)+helper(n-2, dp));
    }
}



}
