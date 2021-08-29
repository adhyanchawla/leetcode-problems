class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        
        for(int n = 0; n <= cost.length - 1; n++) {
            if(n <= 1) {
                dp[n] = cost[n];
                continue;
            }
            
            int ans = Math.min(dp[n - 1], dp[n - 2]) + cost[n];
            
            dp[n] = ans;
        }
        
        return Math.min(dp[cost.length-1], dp[cost.length - 2]);
    }
}