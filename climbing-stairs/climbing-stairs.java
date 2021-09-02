class Solution {
    public int climbStairs(int n) {
        return fibo_mem(n, new int[n + 1]);   
    }
    
    public static int fibo_mem(int n, int[] dp) {
        if(n <= 1) {
            return dp[n] = 1;
        }

        if(dp[n] != 0) return dp[n];

        int ans = fibo_mem(n - 1, dp) + fibo_mem(n - 2, dp);

        return dp[n] = ans;
    }
}