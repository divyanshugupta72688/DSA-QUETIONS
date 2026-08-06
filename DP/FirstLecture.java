package DP;

public class FirstLecture {


    // fibonacci number using memoziation

    class Fibonacci{
        static int[]dp;
        public int fib(int n){
            dp = new int[n+1];
            return helper(n);
        }
        public int helper(int n){
            if (n<=1) {
                return n;
            }
            if (dp[n]!=0) {
                return dp[n];
            }
            dp[n] = helper(n-1)+helper(n-2);
            return dp[n];
        }
    }


    
}
