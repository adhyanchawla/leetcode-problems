class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fib_mem(n, dp);
    }
    
    public int fib_mem(int n, int[] dp) {
        if(n <= 1) {
            return dp[n] = 1;
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        
        int count = 0;
        count = fib_mem(n - 1, dp) + fib_mem(n - 2, dp);
        
        return dp[n] = count;
        
    }
}