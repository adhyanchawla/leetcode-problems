class Solution {
    public int tribonacci(int n) {
        int[]dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fib_mem(n, dp);
    }
    
    public int fib_mem(int n, int[] dp) {
        if(n < 0) {
            return 0;    
        }
        
        if(n >= 0 && n <= 2) {
            if(n == 2) {
                return dp[n] = 1;
            } else{
                return dp[n] = n;
            }
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int fibn = fib_mem(n - 1, dp) + fib_mem(n - 2, dp) + fib_mem(n - 3, dp);
        
        return dp[n] = fibn;
        
     }
}