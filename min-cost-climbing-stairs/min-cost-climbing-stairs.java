class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        return minCost(cost, dp, cost.length);
    }
    
    public int minCost(int[] cost, int[] dp, int idx) {
        if(idx <= 1) return dp[idx] = cost[idx];
        
        if(dp[idx] != 0) return dp[idx];
        
        
        int oneStep = minCost(cost, dp, idx - 1);
        int twoStep = minCost(cost, dp, idx - 2);
        
        int minPath = Math.min(oneStep, twoStep) + ((idx != cost.length) ? cost[idx] : 0);
        
        return dp[idx] = minPath;
    }
}